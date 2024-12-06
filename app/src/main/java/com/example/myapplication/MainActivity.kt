package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.data1.RepositoryImpl
import com.example.data1.preferences.ProductSharedPreferences
import com.example.module.Repository
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val repository: Repository = RepositoryImpl()
    private val productSharedPreferences = ProductSharedPreferences()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.IO).launch {
            val currentDayOfMonth = repository.getCurrentDayOfMonth()
            val lastDay = productSharedPreferences.getLastDate()

            Log.d("MainActivity", "Текущий день: ${currentDayOfMonth} Сохраненный день: ${lastDay}")
            if(currentDayOfMonth != lastDay) {
                Log.d("MainActivity", "Сохраненнение нового дня")
                repository.insertProducts()
                productSharedPreferences.saveDate(currentDayOfMonth)
            }

            val data = repository.getProducts()

            withContext(Dispatchers.Main) {
                val adapter = ProductAdapter(data)
                binding.recyclerViewProducts.adapter = adapter
                binding.recyclerViewProducts.layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }
}