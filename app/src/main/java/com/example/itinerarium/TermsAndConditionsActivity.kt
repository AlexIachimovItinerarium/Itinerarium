package com.example.itinerarium

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class TermsAndConditionsActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_terms_and_conditions)
    val termsAndCoonditionsWebView: WebView = findViewById(R.id.termsAndConditionsWebView)
    termsAndCoonditionsWebView.loadUrl("file:///android_asset/terms-and-conditions.html")
  }
}
