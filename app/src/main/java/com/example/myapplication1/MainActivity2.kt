package com.example.myapplication1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonNavigate.setOnClickListener{
            startActivity(MainActivity.createIntent(this))
        }
    }

    companion object {
        fun createIntent(fromContext: Context): Intent {
            return Intent(fromContext, MainActivity2::class.java)
        }
    }
}