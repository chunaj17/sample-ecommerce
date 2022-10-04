package com.samsoncj.sampleecommerce.features.data.data_source.api.dto

import com.samsoncj.sampleecommerce.features.domain.model.EcommerceModel

data class EcommerceDto(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: RatingDto,
    val title: String
){
    fun toEcommerceModel(): EcommerceModel {
        return EcommerceModel(
            id = id,
            category = category,
            description = description,
            image = image,
            price = price,
            title = title
        )
    }

}