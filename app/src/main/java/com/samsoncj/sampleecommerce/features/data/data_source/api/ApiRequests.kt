package com.samsoncj.sampleecommerce.features.data.data_source.api

import com.samsoncj.sampleecommerce.features.data.data_source.api.dto.EcommerceDto
import com.samsoncj.sampleecommerce.features.data.data_source.api.dto.body.AddProductBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiRequests {
    @GET("/products")
    suspend fun getProducts(): List<EcommerceDto>

    @GET("/products/{id}")
    suspend fun getProduct(
        @Path("id") id: Int
    ): List<EcommerceDto>

    @GET("/products?limit={num}")
    suspend fun limitedProducts(
        @Path("num") num: Int
    ): List<EcommerceDto>

    @GET("/products?sort={method}")
    suspend fun sortProducts(
        @Path("method") num: Int
    ): List<EcommerceDto>

    @GET("/products/categories")
    suspend fun getProductCategories(): List<EcommerceDto>

    @GET("/products/category/{group}")
    suspend fun getSingleCategory(
        @Path("group") group:String
    ): List<EcommerceDto>

    @POST("/products/{id}")
    @Headers("Content-Type:application/json")
    suspend fun updateProduct(
        @Path("id") id:Int,
        @Body requestBody: AddProductBody
    ): List<EcommerceDto>

    @POST("/products")
    @Headers("Content-Type:application/json")
    suspend fun addProduct(
        @Body requestBody: AddProductBody
    ): List<EcommerceDto>



    companion object {
        const val BASE_URL = "https://fakestoreapi.com/"
    }

}