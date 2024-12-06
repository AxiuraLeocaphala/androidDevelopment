package com.example.myapplication

import android.app.Application
import com.example.data1.db.AppDatabase
import com.example.data1.preferences.ProductSharedPreferences

class ProductApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppDatabase.initDB(applicationContext)
//        Инициализируем ProductSharedPreferences
        ProductSharedPreferences.initPrefetences(applicationContext)
    }
}