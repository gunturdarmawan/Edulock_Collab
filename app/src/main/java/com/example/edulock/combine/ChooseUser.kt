package com.example.edulock.combine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.edulock.R
import com.google.android.material.bottomsheet.BottomSheetDialog

class ChooseUser : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilih_user)

        val view: View = layoutInflater.inflate(R.layout.bottomsheet_pilih_user, null)
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(view)
        dialog.show()

        val btnShow: Button = findViewById(R.id.buttonPilihAkun)
        btnShow.setOnClickListener {
            val view: View = layoutInflater.inflate(R.layout.bottomsheet_pilih_user, null)
            val dialog = BottomSheetDialog(this)
            dialog.setContentView(view)
            dialog.show()
        }
    }
}