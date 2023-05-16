package com.example.api31android

import android.R.attr.name
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {
    lateinit var welcomeText: String;
    lateinit var tvWelcome: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        welcomeText = "Welcome " + intent.getStringExtra("userName") + "!";
        tvWelcome = findViewById(R.id.tvWelcome);
        tvWelcome.setText(welcomeText);

        //val intent = intent
        //val getName = intent.getStringExtra("name")
        //Set Text
        //Set Text
        //tvWelcome.setText(getName)

    }
}