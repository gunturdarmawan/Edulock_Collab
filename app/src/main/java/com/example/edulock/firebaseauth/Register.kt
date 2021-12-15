package com.example.edulock.firebaseauth

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.util.Patterns
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.edulock.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()
        findViewById<MaterialButton>(R.id.buttonNextRegister).setOnClickListener {

            val emailRegisterId = findViewById<TextInputEditText>(R.id.textEmailRegist)
            val passRegisterId = findViewById<TextInputEditText>(R.id.textPasswordRegist)

            val email = emailRegisterId.text.toString().trim()
            val password = emailRegisterId.text.toString().trim()


            if (email.isEmpty()){
                emailRegisterId.error = "Email Harus Diisi"
                findViewById<TextInputEditText>(R.id.textEmailRegist).requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                emailRegisterId.error = "Email tidak Valid"
                emailRegisterId.requestFocus()
                return@setOnClickListener
            }

            if(password.isEmpty() || password.length < 6){
                passRegisterId.error = "Pasword Harus Lebih dari 6 karakter"
                passRegisterId.requestFocus()
                return@setOnClickListener
            }
            registerUser()
        }

        val textView = findViewById<TextView>(R.id.textLinkToLogin)
        val text = "Sudah Punya Akun? Login"
        val ss = SpannableString(text)
        val fcsRed = ForegroundColorSpan(Color.rgb(8, 21, 136))

        ss.setSpan(fcsRed, 18, 23, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        textView.text = ss

        textView.setOnClickListener {
            val intent = Intent(this, Login:: class.java)
            startActivity(intent)
        }
    }

    private fun registerUser() {
        val email = findViewById<TextInputEditText>(R.id.textEmailRegist).text.toString().trim()
        val password = findViewById<TextInputEditText>(R.id.textPasswordRegist).text.toString().trim()
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Intent(this@Register, RegisterKid::class.java).also {
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                    }
                } else {
                    Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
    }

    override fun onStart() {
        super.onStart()
        if (auth.currentUser != null){
            Intent(this@Register, RegisterKid::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }
}