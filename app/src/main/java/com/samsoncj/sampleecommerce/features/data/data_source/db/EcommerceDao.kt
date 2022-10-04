package com.samsoncj.sampleecommerce.features.data.data_source.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.samsoncj.sampleecommerce.features.domain.model.EcommerceModel

@Dao
interface EcommerceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(products: List<EcommerceModel>)

    @Query("SELECT * FROM ecommercemodel")
    suspend fun getProducts(): List<EcommerceModel>
}