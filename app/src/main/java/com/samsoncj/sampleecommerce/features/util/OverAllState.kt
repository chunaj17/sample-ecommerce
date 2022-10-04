package com.samsoncj.sampleecommerce.features.util

typealias SimpleResource = OverAllState<Unit>

sealed class OverAllState<T>(val data: T? = null, val message: String?=null){
    class Loading<T>(data: T? = null): OverAllState<T>(data)
    class Success<T>(data: T?): OverAllState<T>(data)
    class Error<T>(message: String, data: T? = null): OverAllState<T>(data, message)
}

