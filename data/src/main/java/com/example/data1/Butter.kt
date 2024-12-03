package com.example.data1

import com.example.module.Product

data class Butter(
    override val name: String = "Butter",
    override val count: Int
) : Product
