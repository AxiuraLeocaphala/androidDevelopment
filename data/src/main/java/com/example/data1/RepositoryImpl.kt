package com.example.data1

import com.example.data1.api.ProductClient
import com.example.data1.db.AppDatabase
import com.example.data1.preferences.ProductSharedPreferences
import com.example.module.Product
import com.example.module.Repository
import java.time.LocalDate

class RepositoryImpl : Repository {
    private val db = AppDatabase.db
    private val productSharedPreferences = ProductSharedPreferences()

    override suspend fun insertProducts() {
        val data = ProductClient.client.fetchProductList()
        val convertedData = data.map { it.toProductEntity() }
        db.productDao().insertAll(convertedData)
    }

    override suspend fun getProducts(): List<Product> {
        val currentDayOfMonth = this.getCurrentDayOfMonth()
        val lastDay = productSharedPreferences.getLastDate()

        if(currentDayOfMonth != lastDay) {
            this.insertProducts()
            productSharedPreferences.saveDate(currentDayOfMonth)
        }

        return db.productDao().getAll()
    }

    override suspend fun getCurrentDayOfMonth(): String {
        return LocalDate.now().dayOfMonth.toString()
    }
}