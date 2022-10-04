package com.samsoncj.sampleecommerce.features.data.data_source.db
import androidx.room.Database
import androidx.room.RoomDatabase
import com.samsoncj.sampleecommerce.features.domain.model.EcommerceModel

@Database(
    entities = [EcommerceModel::class],
    version = 1
)
abstract class EcommerceDatabase: RoomDatabase() {
    abstract val ecommerceDao:EcommerceDao
    companion object {
        const val DATABASE_NAME = "e_commerce_db"
    }
}