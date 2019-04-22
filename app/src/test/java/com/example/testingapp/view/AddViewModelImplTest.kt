package com.example.testingapp.view

import android.content.Context
import com.example.testingapp.R
import com.example.testingapp.business.Adder
import com.example.testingapp.business.IntValidator
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AddViewModelImplTest {

  companion object {
    const val NO_INT = "NO_INT"
    const val INT = "37"
    const val INT2 = "88"
    const val ERROR_MESSAGE = "THIS IS THE ERROR MESSAGE!"
    const val OK_MESSAGE = "THIS IS THE OK MESSAGE!"
  }

  lateinit var context: Context
  lateinit var adder: Adder
  lateinit var intValidator: IntValidator
  lateinit var addViewModel: AddViewModel

  @Before
  fun setUp() {
    context = mock<Context>()
    adder = mock<Adder>()
    intValidator = mock<IntValidator>()
    addViewModel = AddViewModelImpl(
        context,
        adder,
        intValidator
    )
  }

  @Test
  fun execSum_firstParamIsNotNumber_errorMessageIsGot() {
    `when`(intValidator.asInt(NO_INT)).thenReturn(null)
    `when`(context.getString(R.string.validation_error, NO_INT))
        .thenReturn(ERROR_MESSAGE)
    val result = addViewModel.execSum(NO_INT, NO_INT)
    verify(context).getString(R.string.validation_error, NO_INT)
    assertThat(result).isEqualTo(ERROR_MESSAGE)
  }

  @Test
  fun execSum_secondParamIsNotNumber_errorMessageIsGot() {
    `when`(intValidator.asInt(NO_INT)).thenReturn(null)
    `when`(intValidator.asInt(INT)).thenReturn(37)
    `when`(context.getString(R.string.validation_error, NO_INT))
        .thenReturn(ERROR_MESSAGE)
    val result = addViewModel.execSum(INT, NO_INT)
    verify(intValidator).asInt(NO_INT)
    verify(intValidator).asInt(INT)
    verify(context).getString(R.string.validation_error, NO_INT)
    assertThat(result).isEqualTo(ERROR_MESSAGE)
  }

  @Test
  fun execSum_firstParamsAreNumbers_successiIsReturned() {
    `when`(intValidator.asInt(INT)).thenReturn(37)
    `when`(intValidator.asInt(INT2)).thenReturn(88)
    `when`(adder.add(37, 88)).thenReturn(100)
    `when`(context.getString(R.string.sum_result, 37, 88, 100))
        .thenReturn(OK_MESSAGE)
    val result = addViewModel.execSum(INT, INT2)
    verify(intValidator).asInt(INT)
    verify(intValidator).asInt(INT2)
    verify(context, never()).getString(anyInt(), anyString())
    verify(context).getString(R.string.sum_result, 37, 88, 100)
    verify(adder).add(37, 88)
    assertThat(result).isEqualTo(OK_MESSAGE)
  }

}