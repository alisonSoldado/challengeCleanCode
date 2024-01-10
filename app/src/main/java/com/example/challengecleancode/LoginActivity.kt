package com.example.challengecleancode

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.challengecleancode.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener {
            val isEmail = binding.txtEditTextEmail.text?.contains("@")

            if (isEmail!!) {
                val sharedPreferences = getSharedPreferences("cleanCode", Context.MODE_PRIVATE)
                val allEntries: Map<String, *> = sharedPreferences.all
                var isEmailValid = false
                var isPasswordValid = false

                for ((key, value) in allEntries) {
                    if (key == "email" && value == binding.txtEditTextEmail.text.toString()) {
                        isEmailValid = true
                    } else if (key == "password" && value == binding.txtEditTextPassword.text.toString()) {
                        isPasswordValid = true
                    }
                }

                if (isEmailValid && isPasswordValid) {
                    val mainIntent = Intent(this, MainActivity::class.java)
                    mainIntent.putExtra("email", binding.txtEditTextEmail.text.toString())
                    startActivity(mainIntent)
                } else {
                    Toast.makeText(this, "E-mail or Password is incorrect", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "E-mail invalid", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonRegister.setOnClickListener {
            val registerIntent = Intent(this, RegisterActivity::class.java)
            startActivity(registerIntent)
        }
    }
}