package com.example.data1

import com.example.module.Bread
import com.example.module.Milk
import com.example.module.Product
import com.example.module.Repository

class RepositoryImpl : Repository {
    override fun getData(): List<Product> {
        return listOf(
            Milk(count = 5),
            Bread(count = 10)
        )
    }
}