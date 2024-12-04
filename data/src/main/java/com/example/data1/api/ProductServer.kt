package com.example.data1.api

import com.example.data1.api.model.ProductApi
import retrofit2.http.GET

interface ProductServer {
    @GET("/products")
    suspend fun fetchProductList(): List <ProductApi>
}