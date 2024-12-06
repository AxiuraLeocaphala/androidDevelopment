package com.example.data1.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data1.db.dao.ProductDao
import com.example.data1.db.entities.ProductEntity


@Database(entities = [ProductEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao

    companion object {
        lateinit var db: AppDatabase

        fun initDB (applicationContext: Context) {
            db = Room
                .databaseBuilder(applicationContext, AppDatabase::class.java, "product_db")
                .build()
        }
    }
}