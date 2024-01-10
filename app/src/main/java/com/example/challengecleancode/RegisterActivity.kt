package com.example.challengecleancode

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.challengecleancode.databinding.ActivityRegisterBinding

class RegisterActivity: AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonRegister.setOnClickListener {
            val sharedPreferences = getSharedPreferences("cleanCode", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()

            editor.putString("name", binding.txtEditTextName.text.toString())
            editor.putString("cpf", binding.txtEditTextCPF.text.toString())
            editor.putString("rg", binding.txtEditTextRG.text.toString())
            editor.putString("email", binding.txtEditTextEmail.text.toString())
            editor.putString("password", binding.txtEditTextPassword.text.toString())
            editor.commit()
            finish()
        }
    }
}