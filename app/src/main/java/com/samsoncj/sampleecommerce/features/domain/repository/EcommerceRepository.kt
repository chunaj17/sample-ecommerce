package com.samsoncj.sampleecommerce.features.domain.repository

import com.samsoncj.sampleecommerce.features.domain.model.EcommerceModel
import com.samsoncj.sampleecommerce.features.util.OverAllState
import kotlinx.coroutines.flow.Flow


interface EcommerceRepository {
    fun getProducts() : Flow<OverAllState<List<EcommerceModel>>>
}