package com.example.edulock.lockapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.edulock.R
import com.example.edulock.firebaseauth.Login
import com.google.firebase.auth.FirebaseAuth

class LockApp : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lock_app)

        auth = FirebaseAuth.getInstance()

        findViewById<TextView>(R.id.textLogout).setOnClickListener {
            auth.signOut()
            Intent(this@LockApp, Login::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }
}