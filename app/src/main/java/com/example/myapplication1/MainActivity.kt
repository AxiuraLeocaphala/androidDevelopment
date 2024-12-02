package com.example.myapplication1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonNavigate.setOnClickListener{
            startActivity(MainActivity2.createIntent(this))
        }
    }

    companion object {
        fun createIntent(fromContext: Context): Intent {
            return Intent(fromContext, MainActivity::class.java)
        }
    }
}