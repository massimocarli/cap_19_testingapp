package com.example.testingapp.rules

import org.junit.rules.TestRule
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.junit.runners.model.Statement

class LoggedRule : TestRule {
  override fun apply(
      base: Statement?,
      description: Description?
  ): Statement {
    return object : Statement() {
      override fun evaluate() {
        println("TEST_STARTED")
        base?.evaluate()
        println("TEST_ENDED")
      }
    }
  }
}


class LoggedWatchRule : TestWatcher() {

  override fun starting(description: Description?) {
    super.starting(description)
    println("TEST_STARTED")
  }

  override fun finished(description: Description?) {
    println("TEST_ENDED")
    super.finished(description)
  }
}