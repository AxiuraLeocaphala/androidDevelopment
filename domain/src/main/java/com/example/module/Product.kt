package com.example.module

interface Product {
    val name: String
    val count: Int
}

data class Milk(
    override val name: String = "Milk",
    override val count: Int
) : Product

data class Bread(
    override val name: String = "Bread",
    override val count: Int
) : Product

data class Butter(
    override val name: String = "Butter",
    override val count: Int
) : Product