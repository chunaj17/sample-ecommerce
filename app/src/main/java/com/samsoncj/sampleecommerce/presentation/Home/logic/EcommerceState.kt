package com.samsoncj.sampleecommerce.presentation.Home.logic

import com.samsoncj.sampleecommerce.features.domain.model.EcommerceModel

data class EcommerceState(
    val data: List<EcommerceModel> = emptyList(),
    val isLoading:Boolean = false
)
