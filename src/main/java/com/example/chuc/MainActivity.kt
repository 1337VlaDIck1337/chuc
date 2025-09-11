package com.example.chuc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val logInButton: Button = findViewById(R.id.logIn)
        val loginEditText: EditText = findViewById(R.id.login)
        val passwordEditText: EditText = findViewById(R.id.password)

        val correctLogin = "qwe"
        val correctPassword = "asd"

        logInButton.setOnClickListener {
            val enteredLogin = loginEditText.text.toString()
            val enteredPassword = passwordEditText.text.toString()

            if (enteredLogin == correctLogin && enteredPassword == correctPassword) {
                Toast.makeText(this, "Успешно", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Неверно", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
