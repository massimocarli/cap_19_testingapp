package com.example.testingapp.service

import android.content.Context
import android.content.Intent
import android.os.IBinder
import androidx.test.core.app.ApplicationProvider
import androidx.test.rule.ServiceTestRule
import com.google.common.truth.Truth
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.TimeoutException

class AdderServiceTest {

  @get:Rule
  val serviceRule = ServiceTestRule()

  @Test
  @Throws(TimeoutException::class)
  fun testWithBoundService() {
    val serviceIntent = Intent(
        ApplicationProvider.getApplicationContext<Context>(),
        AdderService::class.java
    )
    val binder: IBinder = serviceRule.bindService(serviceIntent)

    val result = (binder as RemoteAdder).add(2, 4)
    Truth.assertThat(result).isEqualTo(6)
  }

}