package com.example.module

interface Repository {
    suspend fun insertProducts()
    suspend fun getProducts(): List<Product>
    suspend fun getCurrentDayOfMonth(): String
}