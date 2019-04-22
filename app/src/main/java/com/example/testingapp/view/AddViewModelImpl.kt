package com.example.testingapp.view

import android.content.Context
import com.example.testingapp.R
import com.example.testingapp.business.Adder
import com.example.testingapp.business.IntValidator

/**
 * Simple implementation of the AddViewModel which uses the Context in order
 * to get the String to use for formatting the result
 */
class AddViewModelImpl(
    val context: Context,
    val adder: Adder,
    val validator: IntValidator) : AddViewModel {

  override fun execSum(a: String, b: String): String {
    val aAsInt = validator.asInt(a)
    if (aAsInt == null) {
      return context.getString(R.string.validation_error, a)
    }
    val bAsInt = validator.asInt(b)
    if (bAsInt == null) {
      return context.getString(R.string.validation_error, b)
    }
    return context.getString(
        R.string.sum_result,
        aAsInt,
        bAsInt,
        adder.add(aAsInt, bAsInt))
  }
}