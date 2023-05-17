package com.example.api31android

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

private lateinit var progressBar: ProgressBar
private lateinit var Back: Button
private lateinit var status: TextView
private var progressValue: Int = 0

private lateinit var progress1: Button
private lateinit var progress2: Button
private lateinit var progress3: Button
private lateinit var progress4: Button
private lateinit var progress5: Button

class TrackActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_track)

        progressBar = findViewById(R.id.progressbar)
        status = findViewById(R.id.status)
        Back = findViewById(R.id.Back)
        Back.setOnClickListener {
            intent = Intent(this, DashboardActivity::class.java)
            intent.putExtra("userName","")
            startActivity(intent)
        }

        progress1 = findViewById(R.id.progress1)
        progress1.setOnClickListener {
            progressValue = 0
            setProgressBar(progressValue)
            checkProgress(progressValue)
        }
        progress2 = findViewById(R.id.progress2)
        progress2.setOnClickListener {
            progressValue = 25
            setProgressBar(progressValue)
            checkProgress(progressValue)
        }
        progress3 = findViewById(R.id.progress3)
        progress3.setOnClickListener {
            progressValue = 50
            setProgressBar(progressValue)
            checkProgress(progressValue)
        }
        progress4 = findViewById(R.id.progress4)
        progress4.setOnClickListener {
            progressValue = 75
            setProgressBar(progressValue)
            checkProgress(progressValue)
        }
        progress5 = findViewById(R.id.progress5)
        progress5.setOnClickListener {
            progressValue = 100
            setProgressBar(progressValue)
            checkProgress(progressValue)
        }

    }
    fun setProgressBar(value:Int) {
        return progressBar.setProgress(value)
    }

    fun checkProgress(value:Int) {
        if (value == 0) {
            status.setText("Pending")
        }
        if (value == 25) {
            status.setText("We've just started")
        }
        if (value == 50) {
            status.setText("We're half way done")
        }
        if (value == 75) {
            status.setText("It's almost there")
        }
        if(value == 100){
            status.setText("Ready for collection")
        }
    }
}