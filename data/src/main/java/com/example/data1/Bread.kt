package com.example.data1

import com.example.module.Product

data class Bread(
    override val name: String = "Bread",
    override val count: Int
) : Product
