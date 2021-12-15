package com.example.edulock.combine
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.edulock.R
import com.google.android.material.bottomsheet.BottomSheetDialog


class Unlock : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unlock)

        val btnShow: Button = findViewById(R.id.buttonLihatPembahasan)
        btnShow.setOnClickListener {
            val view: View = layoutInflater.inflate(R.layout.bottomsheet_pembahasan, null)
            val dialog = BottomSheetDialog(this)
            dialog.setContentView(view)
            dialog.show()
        }
    }

}