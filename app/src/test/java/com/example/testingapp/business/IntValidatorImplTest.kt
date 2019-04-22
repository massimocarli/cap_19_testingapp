package com.example.testingapp.business

import com.example.testingapp.rules.LoggedWatchRule
import com.google.common.truth.Truth
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class IntValidatorImplTest {

  @get:Rule
  val myRule = LoggedWatchRule()

  lateinit var intValidator: IntValidator

  @Before
  fun setUp() {
    intValidator = IntValidatorImpl()
  }

  @Test
  fun asInt_isZero_returnsZero() {
    val result = intValidator.asInt("0")
    Truth.assertThat(result).isEqualTo(0)
  }

  @Test
  fun asInt_isLetters_returnsNull() {
    val result = intValidator.asInt("abc")
    Truth.assertThat(result).isNull()
  }

  @Test
  fun asInt_isNumberWithSpaces_returnsNull() {
    val result = intValidator.asInt("   12   ")
    Truth.assertThat(result).isEqualTo(12)
  }

  @Test
  fun asInt_isEmpty_returnsNull() {
    val result = intValidator.asInt("")
    Truth.assertThat(result).isNull()
  }

  @Test
  fun asInt_isSpaces_returnsNull() {
    val result = intValidator.asInt("     ")
    Truth.assertThat(result).isNull()
  }

  @Test
  fun asInt_isNull_returnsNull() {
    val result = intValidator.asInt(null)
    Truth.assertThat(result).isNull()
  }

  @Test
  fun asInt_negativeNumber_returnsRightValue() {
    val result = intValidator.asInt("-12")
    Truth.assertThat(result).isEqualTo(-12)
  }

  @Test
  fun asInt_negativeNumberWithSpaces_returnsRightValue() {
    val result = intValidator.asInt("   -12    ")
    Truth.assertThat(result).isEqualTo(-12)
  }

  @After
  fun tearDown() {
  }
}