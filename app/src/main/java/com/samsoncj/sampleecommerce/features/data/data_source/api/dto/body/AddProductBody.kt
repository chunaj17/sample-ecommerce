package com.samsoncj.sampleecommerce.features.data.data_source.api.dto.body

data class AddProductBody(
    val title: String,
    val price: Double,
    val description: String,
    val image: String,
    val category:String
)
