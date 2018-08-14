package com.example.itinerarium.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.example.itinerarium.R
import com.example.itinerarium.utils.ScreenNavigation

class LogInActivity : AppCompatActivity() {

  lateinit var signInButton: Button

  lateinit var screenNavigation: ScreenNavigation

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_log_in)

    screenNavigation = ScreenNavigation(this)

    signInButton = findViewById(R.id.buttonSignIn)
    signInButton.setOnClickListener {
      screenNavigation.switchActivity(this, HomeActivity::class.java)
    }

    goToSignUpActivity()

  }

  private fun goToSignUpActivity() {
    val textViewSignUp: TextView
    textViewSignUp = findViewById(R.id.textViewSignUp)
    textViewSignUp.setOnClickListener {
      screenNavigation.switchActivity(this, TermsAndConditionsActivity::class.java)
    }
  }
}
