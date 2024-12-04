package com.example.data1

import com.example.data1.api.ProductClient
import com.example.module.Product
import com.example.module.Repository

class RepositoryImpl : Repository {
    override suspend fun getProduct(): List<Product> {
        return ProductClient.client.fetchProductList()
    }
}