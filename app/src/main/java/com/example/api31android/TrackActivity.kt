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
            startActivity(intent)
        }
        progressValue = 25
        setProgressBar(progressValue)
        checkProgress(progressValue)
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