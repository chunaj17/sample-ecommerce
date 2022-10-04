package com.samsoncj.sampleecommerce.di

import android.app.Application
import androidx.room.Room
import com.samsoncj.sampleecommerce.features.data.data_source.api.ApiRequests
import com.samsoncj.sampleecommerce.features.data.data_source.db.EcommerceDatabase
import com.samsoncj.sampleecommerce.features.data.repository.EcommerceRepositoryImp
import com.samsoncj.sampleecommerce.features.domain.repository.EcommerceRepository
import com.samsoncj.sampleecommerce.features.domain.use_case.EcommerceUseCases
import com.samsoncj.sampleecommerce.features.domain.use_case.GetProducts
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideEcommerceDatabase(app:Application):EcommerceDatabase{
        return Room.databaseBuilder(
            app,
            EcommerceDatabase::class.java,
            EcommerceDatabase.DATABASE_NAME
        ).build()

    }

    @Provides
    @Singleton
    fun provideApiRequest():ApiRequests {
        return Retrofit.Builder()
            .baseUrl(ApiRequests.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiRequests::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(
        api:ApiRequests,
        dao: EcommerceDatabase
    ): EcommerceRepository {
        return EcommerceRepositoryImp(
            api = api,
            dao = dao.ecommerceDao
        )
    }

    @Provides
    @Singleton
    fun provideEcommerceUseCases(
        repository: EcommerceRepository
    ):EcommerceUseCases {
        return EcommerceUseCases(
            getProducts = GetProducts(repository)
        )
    }
}