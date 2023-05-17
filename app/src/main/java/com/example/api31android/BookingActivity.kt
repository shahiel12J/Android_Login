package com.example.api31android

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.Calendar

lateinit var pickDateBtn: Button
lateinit var selectedDateTV: TextView
lateinit var selectedTimeTV: TextView
lateinit var backButton:Button
lateinit var pickTimeBtn: Button
private lateinit var btnSubmit: Button

class BookingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        pickDateBtn = findViewById(R.id.idBtnPickDate)
        selectedDateTV = findViewById(R.id.idTVSelectedDate)
        backButton = findViewById(R.id.backButton)

        backButton.setOnClickListener{
            intent = Intent(this, DashboardActivity::class.java)
            intent.putExtra("userName","")
            startActivity(intent)
        }

        btnSubmit = findViewById(R.id.submitBooking)
        btnSubmit.setOnClickListener{intent.putExtra("userName","")
            Toast.makeText(this, "Submitted Successfully", Toast.LENGTH_SHORT).show()
            intent = Intent(this, DashboardActivity::class.java)
            intent.putExtra("userName","")
            startActivity(intent)
        }

        // on below line we are adding
        // click listener for our button
        pickDateBtn.setOnClickListener {
            // on below line we are getting
            // the instance of our calendar.
            val c = Calendar.getInstance()

            // on below line we are getting
            // our day, month and year.
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            // on below line we are creating a
            // variable for date picker dialog.
            val datePickerDialog = DatePickerDialog(
                // on below line we are passing context.
                this,
                { view, year, monthOfYear, dayOfMonth ->
                    // on below line we are setting
                    // date to our text view.
                    selectedDateTV.text =
                        (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                },
                // on below line we are passing year, month
                // and day for the selected date in our date picker.
                year,
                month,
                day
            )
            // at last we are calling show
            // to display our date picker dialog.
            datePickerDialog.show()
        }

        pickTimeBtn = findViewById(R.id.idBtnPickTime)
        selectedTimeTV=findViewById(R.id.idTVSelectedTime)


        // on below line we are adding click
        // listener for our button
        pickTimeBtn.setOnClickListener {
            // on below line we are getting
            // the instance of our calendar.
            val c = Calendar.getInstance()

            // on below line we are getting our hour, minute.
            val hour = c.get(Calendar.HOUR_OF_DAY)
            val minute = c.get(Calendar.MINUTE)

            // on below line we are initializing
            // our Time Picker Dialog
            val timePickerDialog = TimePickerDialog(
                this,
                { view, hourOfDay, minute ->
                    // on below line we are setting selected
                    // time in our text view.
                    selectedTimeTV.setText("$hourOfDay:$minute")
                },
                hour,
                minute,
                false
            )
            // at last we are calling show to
            // display our time picker dialog.
            timePickerDialog.show()
        }
    }
}