package com.brianajusta.androidchapterchallengekelompoksatu

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import com.brianajusta.androidchapterchallengekelompoksatu.databinding.LoginScreenBinding
import com.brianajusta.androidchapterchallengekelompoksatu.landingpage.LandingPage

class LoginScreen : AppCompatActivity() {

    private lateinit var binding: LoginScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableButton()

        binding.etLoginEmail.doAfterTextChanged {
            enableButton()
        }
        binding.etLoginPassword.doAfterTextChanged {
            enableButton()
        }
    }

    private fun enableButton() {
        val email = binding.etLoginEmail.text.toString()
        val password = binding.etLoginPassword.text.toString()

        binding.btnLogin.isEnabled = email.isNotEmpty() && password.isNotEmpty()
    }
}