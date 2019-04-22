package com.example.testingapp.business

/**
 * Simple implementation of the Adder interface
 */
class SimpleAdderImpl : Adder {

  /**
   * Just adds the 2 values
   */
  override fun add(a: Int, b: Int) = a + b
}