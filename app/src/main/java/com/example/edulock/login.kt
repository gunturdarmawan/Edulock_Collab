package com.example.edulock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}