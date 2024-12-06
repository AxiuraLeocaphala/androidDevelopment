package com.example.data1.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.module.Product

@Entity(tableName = "product")
data class ProductEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    override val id: Int,

    @ColumnInfo(name = "title")
    override val title: String,

    @ColumnInfo(name = "price")
    override val price: Double
) : Product

