package com.example.module

interface Repository {
    suspend fun getProduct(): List<Product>
}