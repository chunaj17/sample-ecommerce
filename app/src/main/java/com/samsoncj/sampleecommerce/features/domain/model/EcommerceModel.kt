package com.samsoncj.sampleecommerce.features.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EcommerceModel(
    @PrimaryKey val id:Int,
    val category: String,
    val description:String,
    val image:String,
    val price: Double,
    val title:String
)