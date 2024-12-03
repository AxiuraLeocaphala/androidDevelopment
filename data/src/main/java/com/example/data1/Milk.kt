package com.example.data1

import com.example.module.Product

data class Milk(
    override val name: String = "Milk",
    override val count: Int
) : Product

