package com.example.api31android

import android.R.attr.name
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

private lateinit var btnTrack: CardView
private lateinit var btnBook: CardView
private lateinit var redeem: CardView
private lateinit var rate: CardView
private lateinit var logout: Button
class DashboardActivity : AppCompatActivity() {
    lateinit var welcomeText: String;
    lateinit var tvWelcome: TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        btnTrack = findViewById(R.id.track_service)
        btnTrack.setOnClickListener {
            intent = Intent(this, TrackActivity::class.java)
            startActivity(intent)
        }

        btnBook = findViewById(R.id.bookings)
        btnBook.setOnClickListener {
            startActivity(Intent(this, BookingActivity::class.java))
        }

        redeem=findViewById(R.id.redeem)
        redeem.setOnClickListener {
            intent = Intent(this, RedeemActivity::class.java)
            startActivity(intent)
        }

        rate=findViewById(R.id.rate)
        rate.setOnClickListener {
            intent = Intent(this, RateActivity::class.java)
            startActivity(intent)
        }

        logout=findViewById(R.id.btnLogout)
        logout.setOnClickListener {
            intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

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