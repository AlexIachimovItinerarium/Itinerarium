package com.example.itinerarium

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.SpannableStringBuilder
import android.text.style.ClickableSpan
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class SignUpActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_sign_up)
    setCountrySpinner()
    setcitySpinner()
  }

  private fun setCountrySpinner() {
    val countrySpinner: Spinner = findViewById(R.id.spinnerSignUpCountry)
    val countriesArray = resources.getStringArray(R.array.countries)
    var adapter = ArrayAdapter(this, R.layout.country_spinner_item, countriesArray)
    countrySpinner.adapter = adapter
    countrySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
      override fun onNothingSelected(parent: AdapterView<*>?) {
      }

      override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
      }
    }
  }


  private fun setcitySpinner() {
    val citySpinner: Spinner = findViewById(R.id.spinnerSignUpCity)
    val citiesArray = resources.getStringArray(R.array.cities)
    var adapter = ArrayAdapter(this, R.layout.country_spinner_item, citiesArray)
    citySpinner.adapter = adapter
    citySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
      override fun onNothingSelected(parent: AdapterView<*>?) {
      }

      override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
      }
    }
  }
}
