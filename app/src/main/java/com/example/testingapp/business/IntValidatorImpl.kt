package com.example.testingapp.business

/**
 * Implementation of thew IntValidator
 */
class IntValidatorImpl : IntValidator {
  override fun asInt(str: String?): Int? {
    try {
      return str?.trim()?.toInt()
    } catch (ex: NumberFormatException) {
      return null
    }
  }
}