package com.example.coffee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Countdown : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countdown)

val toResultBtn = findViewById<Button>(R.id.blackBtn)
        toResultBtn.setOnClickListener() {
            val intent = Intent(this, Result2::class.java)
            startActivity(intent)
        }

        val beigeBtn = findViewById<Button>(R.id.beigeBtn)
        beigeBtn.setOnClickListener() {
            val intent = Intent(this, Beige::class.java)
            startActivity(intent)
        }

        val goToMain = findViewById<Button>(R.id.goToMain)
        goToMain.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        }
    }