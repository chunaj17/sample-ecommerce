package com.samsoncj.sampleecommerce.features.domain.use_case

import com.samsoncj.sampleecommerce.features.domain.model.EcommerceModel
import com.samsoncj.sampleecommerce.features.domain.repository.EcommerceRepository
import com.samsoncj.sampleecommerce.features.util.OverAllState
import kotlinx.coroutines.flow.Flow

class GetProducts(
    private val repository: EcommerceRepository
) {
    operator fun  invoke() : Flow<OverAllState<List<EcommerceModel>>> {
        return repository.getProducts()
    }
}