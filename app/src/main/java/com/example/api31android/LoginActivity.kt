package com.example.api31android

import android.R.attr.name
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException


private lateinit var btnReg:Button
private lateinit var btnLogin:Button
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        var Username: EditText
        var Password: EditText
        var UsernameString: String
        var PasswordString: String
        var btnRegUser: Button

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnReg = findViewById(R.id.btnReg)
        btnLogin = findViewById(R.id.btnLogin)
        btnReg.setOnClickListener {
            intent = Intent(this, register::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            Username = findViewById(R.id.username)
            Password = findViewById(R.id.pass)
            UsernameString = Username.getText().toString()
            PasswordString = Password.getText().toString()
            //Toast.makeText(this, " has been registered", Toast.LENGTH_SHORT).show();
            login(Username,Password)
        }


    }
    fun login(Name:EditText,Pass:EditText) {
        val userName: String = Name.getText().toString().trim()
        val password: String = Pass.getText().toString().trim()

        val call: Call<ResponseBody> = RetrofitClient
            .getInstance()
            .api
            .checkUser(Users(userName, password))

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

                if (s == userName) {
                    val intent = Intent(this@LoginActivity, DashboardActivity::class.java)
                    intent.putExtra("userName", userName)
                    Toast.makeText(
                        this@LoginActivity,
                        "Successfully login",
                        Toast.LENGTH_LONG
                    ).show()
                    startActivity(intent)
                } else {
                    Toast.makeText(this@LoginActivity, "User does not exists!", Toast.LENGTH_LONG)
                        .show()
                }


            }

            override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                Toast.makeText(this@LoginActivity, t.message, Toast.LENGTH_LONG).show()
            }


        })
    }


}