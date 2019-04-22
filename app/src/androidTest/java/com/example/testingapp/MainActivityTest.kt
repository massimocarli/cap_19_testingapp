package com.example.testingapp

import android.content.Context
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.rule.ActivityTestRule
import androidx.test.uiautomator.UiDevice
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

  @get:Rule
  var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

  @Test
  fun wrongDataInFirstEditText_errorMessageIsShown() {
    // We insert some text into the first EditText
    onView(withId(R.id.inputA)).perform(typeText("AAA"))
    // We click on the button
    onView(withId(R.id.calculateButton)).perform(click())
    // We check on the error message
    val expectedText = getContext().getString(R.string.validation_error, "AAA")
    onView(withId(R.id.resultOutput)).check(matches(withText(expectedText)))
  }

  @Test
  fun wrongDataInSecondEditText_errorMessageIsShown() {
    // We insert some valid data into the first EditText
    onView(withId(R.id.inputA)).perform(typeText("123"))
    // We insert some wrong text into the first EditText
    onView(withId(R.id.inputB)).perform(typeText("BBB"))
    // We click on the button
    onView(withId(R.id.calculateButton)).perform(click())
    // We check on the error message
    val expectedText = getContext().getString(R.string.validation_error, "BBB")
    onView(withId(R.id.resultOutput)).check(matches(withText(expectedText)))
  }

  @Test
  fun correctData_sumIsDisplayed() {
    // We insert some valid data into the first EditText
    onView(withId(R.id.inputA)).perform(typeText("123"))
    // We insert some wrong text into the first EditText
    onView(withId(R.id.inputB)).perform(typeText("456"))
    // We click on the button
    onView(withId(R.id.calculateButton)).perform(click())
    // We check on the error message
    val expectedText = getContext().getString(R.string.sum_result, 123, 456, 579)
    onView(withId(R.id.resultOutput)).check(matches(withText(expectedText)))
  }

  @Test
  fun uiAutomator() {
    val device = UiDevice.getInstance(getInstrumentation())
    device.setOrientationRight()
    device.pressHome()
  }

  fun getContext(): Context = activityRule.activity
}

