package com.example.itinerarium

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class LogInActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_log_in)
    goToSignUpActivity()
  }

  private fun goToSignUpActivity() {
    val textViewSignUp: TextView
    textViewSignUp = findViewById(R.id.textViewSignUp)
    textViewSignUp.setOnClickListener {
      val signUpIntent = Intent(this, SignUpActivity::class.java)
      startActivity(signUpIntent)
    }
  }
}
