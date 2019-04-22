package com.example.testingapp.business

import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test

class SimpleAdderImplTest {

  lateinit var simpleAdder: SimpleAdderImpl

  @Before
  fun setUp() {
    simpleAdder = SimpleAdderImpl()
  }

  @Test
  fun test_addingZero_returnsTheSame() {
    Truth.assertThat(simpleAdder.add(10, 0)).isEqualTo(10)
  }

  @Test
  fun test_addingOne_returnsPlusOne() {
    Truth.assertThat(simpleAdder.add(10, 1)).isEqualTo(11)
  }

  @Test
  fun test_addingOpposite_returnsZero() {
    Truth.assertThat(simpleAdder.add(10, -10)).isEqualTo(0)
  }
}