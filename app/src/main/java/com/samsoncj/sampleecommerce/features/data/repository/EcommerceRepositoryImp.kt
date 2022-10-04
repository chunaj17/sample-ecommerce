package com.samsoncj.sampleecommerce.features.data.repository

import com.samsoncj.sampleecommerce.features.data.data_source.api.ApiRequests
import com.samsoncj.sampleecommerce.features.data.data_source.db.EcommerceDao
import com.samsoncj.sampleecommerce.features.domain.model.EcommerceModel
import com.samsoncj.sampleecommerce.features.domain.repository.EcommerceRepository
import com.samsoncj.sampleecommerce.features.util.OverAllState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class EcommerceRepositoryImp(
    private val api: ApiRequests,
    private val dao: EcommerceDao
) : EcommerceRepository {
    override fun getProducts(): Flow<OverAllState<List<EcommerceModel>>> = flow {
        emit(OverAllState.Loading())
        println("hello")
        val getProducts = dao.getProducts()
        emit(OverAllState.Loading(data = getProducts))

        try {
            val remoteGetProducts = api.getProducts()
            dao.insertProducts(remoteGetProducts.map { it.toEcommerceModel() })

        } catch (e: HttpException) {
            emit(
                OverAllState.Error(
                    message = "some thing went wrong",
                    data = getProducts
                )
            )
        } catch (e: IOException) {
            OverAllState.Error(
                message = "Couldn't reach server",
                data = getProducts
            )
        }

        val newGetProductsData = dao.getProducts()
        emit(OverAllState.Success(newGetProductsData))
    }

}