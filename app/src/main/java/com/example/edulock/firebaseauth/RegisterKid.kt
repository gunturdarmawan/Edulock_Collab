package com.example.edulock.firebaseauth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.edulock.R
import com.example.edulock.combine.ChooseUser
import com.google.android.material.button.MaterialButton

class RegisterKid : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_kid)

        supportFragmentManager.beginTransaction().add(R.id.fragmentHolder,FirstFragment()).commit()
        supportFragmentManager.beginTransaction().add(R.id.fragmentHolder2,FirstFragment()).commit()

//        findViewById<MaterialButton>(R.id.buttonSimpanDataAnak).setOnClickListener{
//            Intent(this@RegisterKid, ChooseUser::class.java).also {
//                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//                startActivity(it)
//            }
}
}