package com.example.api31android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

private lateinit var Back: Button
private lateinit var btnSubmit: Button

class RedeemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_redeem)

        Back = findViewById(R.id.back)
        Back.setOnClickListener {
            intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }

        btnSubmit = findViewById(R.id.btnsubmit)
        btnSubmit.setOnClickListener{
            Toast.makeText(this, "Submitted Successfully", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, DashboardActivity::class.java))
        }
    }
}