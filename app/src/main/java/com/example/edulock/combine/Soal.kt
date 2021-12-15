package com.example.edulock.combine
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.edulock.R
import com.example.edulock.firebaseauth.Register


class Soal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soal)

        val textView = findViewById<TextView>(R.id.textToHint)
        val text = "Butuh Petunjuk? Bantuan"
        val ss = SpannableString(text)
        val fcsRed = ForegroundColorSpan(Color.rgb(8, 21, 136))

        ss.setSpan(fcsRed, 16, 23, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        textView.text = ss

        textView.setOnClickListener {

        }

    }

}