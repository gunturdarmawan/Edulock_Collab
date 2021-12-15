package com.example.edulock.firebaseauth

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.util.Patterns
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.edulock.R
import com.example.edulock.lockapp.LockApp
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        findViewById<MaterialButton>(R.id.buttonLogin).setOnClickListener {
            val email = findViewById<TextInputEditText>(R.id.EmailLoginInput).text.toString().trim()
            val password = findViewById<TextInputEditText>(R.id.PasswordLoginInput).text.toString().trim()

            if (email.isEmpty()){
                findViewById<TextInputEditText>(R.id.EmailLoginInput).error = "Email Harus Diisi"
                findViewById<TextInputEditText>(R.id.EmailLoginInput).requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                findViewById<TextInputEditText>(R.id.EmailLoginInput).error = "Email tidak Valid"
                findViewById<TextInputEditText>(R.id.EmailLoginInput).requestFocus()
                return@setOnClickListener
            }

            if(password.isEmpty() || password.length < 6){
                findViewById<TextInputEditText>(R.id.PasswordLoginInput).error = "Pasword Harus Lebih dari 6 karakter"
                findViewById<TextInputEditText>(R.id.PasswordLoginInput).requestFocus()
                return@setOnClickListener
            }

            loginUser(email, password)
        }

        val textView = findViewById<TextView>(R.id.textLinkToRegister)
        val text = "Belum Punya Akun? Daftar"
        val ss = SpannableString(text)
        val fcsRed = ForegroundColorSpan(Color.rgb(8, 21, 136))

        ss.setSpan(fcsRed, 18, 24, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        textView.text = ss

        textView.setOnClickListener {
            val intent = Intent(this, Register:: class.java)
            startActivity(intent)
        }
    }

    private fun loginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if(it.isSuccessful){
                    Intent(this@Login, LockApp::class.java).also {
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                    }
                }
                else {
                    Toast.makeText(this, "Akun Salah atau tidak terdaftar", Toast.LENGTH_LONG).show()
                }
            }
    }

    override fun onStart() {
        super.onStart()
        if (auth.currentUser != null){
            Intent(this@Login, LockApp::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }
}