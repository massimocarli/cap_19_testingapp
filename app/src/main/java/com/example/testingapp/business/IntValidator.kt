package com.example.testingapp.business

/**
 * Simple validator which checks if a given String is a Int
 */
interface IntValidator {

  /**
   * If the String contains a valid Int it returns it. Otherwise it returns null
   */
  fun asInt(str: String?): Int?
}