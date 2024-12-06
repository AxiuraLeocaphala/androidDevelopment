package com.example.data1

import com.example.data1.api.ProductClient
import com.example.data1.api.model.ProductApi
import com.example.data1.db.AppDatabase
import com.example.data1.db.entities.ProductEntity
import com.example.module.Product
import com.example.module.Repository
import java.time.LocalDate

class RepositoryImpl : Repository {
    private val db = AppDatabase.db

    override suspend fun insertProducts() {
        val data = ProductClient.client.fetchProductList()
//         Переманная data имеет тип данных ProductApi, что не соответствует
//         типу принимаемого параметра функции insertAll (ProductEntity).
//         Для того, чтобы добавить информацию о продуктах, полученную из сети,
//         в БД, необходимо конверторовать переменную data.
//         Для этого созданим метод-конвертор
        val convertedData = productApiToProductEntity(data)
        db.productDao().insertAll(convertedData)
    }

    fun productApiToProductEntity(listProduct: List<ProductApi>): List<ProductEntity> {
//        Согласно технической документации Kotlin, List - это коллекция, которая поддерживает
//        доступ к списку только для чтения (кортеж). Чтобы создать коллекцию, которая может
//        мутировать, будем использовать функцию mutableListOf
        val collectionData = mutableListOf<ProductEntity>()
        for(product in listProduct) {
            collectionData.add(
                ProductEntity(
                    id = product.id,
                    title = product.title,
                    price = product.price
                )
            )
        }
        return collectionData
    }

    override suspend fun getProducts(): List<Product> {
        return db.productDao().getAll()
    }

    override suspend fun getCurrentDayOfMonth(): String {
        return LocalDate.now().dayOfMonth.toString()
    }
}