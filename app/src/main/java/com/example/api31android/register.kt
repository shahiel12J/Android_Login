package com.example.api31android

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import okhttp3.ResponseBody
import org.json.JSONObject
import org.json.JSONTokener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        var Username: EditText
        var Password: EditText
        var UsernameString: String
        var PasswordString: String
        var btnRegUser: Button


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnRegUser = findViewById(R.id.btnRegInfo)
        btnRegUser.setOnClickListener {
            Username = findViewById(R.id.name)
            Password = findViewById(R.id.password)
            UsernameString = Username.getText().toString()
            PasswordString = Password.getText().toString()

            registerUser(Username,Password)
        }

    }

    fun getData(Name: String) {
        Toast.makeText(this, Name + " has been registered", Toast.LENGTH_SHORT).show();
    }

    fun registerUser(Name:EditText,Pass:EditText) {
        val userName: String = Name.getText().toString().trim()
        val password: String = Pass.getText().toString().trim()

        val call: Call<ResponseBody> = RetrofitClient
            .getInstance()
            .api
            .createUser(Users(userName, password))

        if (userName.isEmpty()) {
            Name.setError("Username is required")
            Name.requestFocus()
            return
        } else if (password.isEmpty()) {
            Pass.setError("Password is required")
            Pass.requestFocus()
            return
        }

        call.enqueue(object : Callback<ResponseBody?> {
            override fun onResponse(call: Call<ResponseBody?>?, response: Response<ResponseBody?>) {
                var s = ""
                try {
                    s = response.body()!!.string()
                } catch (e: IOException) {
                    e.printStackTrace()
                }

                if (s == "SUCCESS") {
                    Toast.makeText(
                        this@register,
                        "Successfully registered. Please login",
                        Toast.LENGTH_LONG
                    ).show()
                    startActivity(Intent(this@register, LoginActivity::class.java))
                } else {
                    Toast.makeText(this@register, "User already exists!", Toast.LENGTH_LONG)
                        .show()
                }


            }

            override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                Toast.makeText(this@register, t.message, Toast.LENGTH_LONG).show()
            }


        })
    }
}