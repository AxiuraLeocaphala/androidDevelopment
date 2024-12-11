package com.example.module

interface Repository {
    suspend fun getProducts(): List<Product>
}