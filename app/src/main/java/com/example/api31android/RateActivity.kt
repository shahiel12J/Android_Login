package com.example.api31android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.isVisible

private lateinit var empStar1: ImageView
private lateinit var fulStar1: ImageView

private lateinit var empStar2: ImageView
private lateinit var fulStar2: ImageView

private lateinit var empStar3:ImageView
private lateinit var fulStar3:ImageView

private lateinit var empStar4:ImageView
private lateinit var fulStar4:ImageView

private lateinit var empStar5:ImageView
private lateinit var fulStar5:ImageView

private lateinit var btnBack: Button
private lateinit var btnSubmit:Button

class RateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate)

        empStar1 = findViewById(R.id.star1E)
        empStar2 = findViewById(R.id.star2E)


        fulStar1 = findViewById(R.id.star1F)
        fulStar2 = findViewById(R.id.star2F)

        empStar3 = findViewById(R.id.star3E)
        fulStar3 = findViewById(R.id.star3F)

        empStar4 = findViewById(R.id.star4E)
        fulStar4 = findViewById(R.id.star4F)

        empStar5 = findViewById(R.id.star5E)
        fulStar5 = findViewById(R.id.star5F)

        btnBack = findViewById(R.id.btnBack)
        btnSubmit = findViewById(R.id.btnSubmit)

        btnBack.setOnClickListener{
            intent = Intent(this, DashboardActivity::class.java)
            intent.putExtra("userName","")
            startActivity(intent)
        }

        btnSubmit.setOnClickListener{
            Toast.makeText(this, "Submitted Successfully", Toast.LENGTH_SHORT).show()
            intent = Intent(this, DashboardActivity::class.java)
            intent.putExtra("userName","")
            startActivity(intent)
        }


        empStar1.setOnClickListener{
            empStar1.isVisible = false
            fulStar1.isVisible = true

        }

        fulStar1.setOnClickListener{
            empStar1.isVisible = true
            fulStar1.isVisible = false

            empStar2.isVisible = true
            fulStar2.isVisible = false

            empStar3.isVisible = true
            fulStar3.isVisible = false

            empStar4.isVisible = true
            fulStar4.isVisible = false

            empStar5.isVisible = true
            fulStar5.isVisible = false
        }

        empStar2.setOnClickListener{
            empStar1.isVisible = false
            fulStar1.isVisible = true

            empStar2.isVisible = false
            fulStar2.isVisible = true
        }

        fulStar2.setOnClickListener{

            empStar2.isVisible = true
            fulStar2.isVisible = false

            empStar3.isVisible = true
            fulStar3.isVisible = false

            empStar4.isVisible = true
            fulStar4.isVisible = false

            empStar5.isVisible = true
            fulStar5.isVisible = false
        }

        empStar3.setOnClickListener{
            empStar1.isVisible = false
            fulStar1.isVisible = true

            empStar2.isVisible = false
            fulStar2.isVisible = true

            empStar3.isVisible = false
            fulStar3.isVisible = true
        }

        fulStar3.setOnClickListener {
            empStar3.isVisible = true
            fulStar3.isVisible = false

            empStar4.isVisible = true
            fulStar4.isVisible = false

            empStar5.isVisible = true
            fulStar5.isVisible = false
        }

        empStar4.setOnClickListener{
            empStar1.isVisible = false
            fulStar1.isVisible = true

            empStar2.isVisible = false
            fulStar2.isVisible = true

            empStar3.isVisible = false
            fulStar3.isVisible = true

            empStar4.isVisible = false
            fulStar4.isVisible = true
        }

        fulStar4.setOnClickListener {
            empStar4.isVisible = true
            fulStar4.isVisible = false

            empStar5.isVisible = true
            fulStar5.isVisible = false
        }

        empStar5.setOnClickListener{
            empStar1.isVisible = false
            fulStar1.isVisible = true

            empStar2.isVisible = false
            fulStar2.isVisible = true

            empStar3.isVisible = false
            fulStar3.isVisible = true

            empStar4.isVisible = false
            fulStar4.isVisible = true

            empStar5.isVisible = false
            fulStar5.isVisible = true
        }
        fulStar5.setOnClickListener{
            empStar5.isVisible = true
            fulStar5.isVisible = false
        }
    }
}