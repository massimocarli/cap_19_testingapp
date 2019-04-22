package com.example.testingapp.service

import android.app.Service
import android.content.Intent
import android.os.IBinder

class AdderService : Service() {

  lateinit var adderImpl: RemoteAdderImpl

  override fun onCreate() {
    super.onCreate()
    adderImpl = RemoteAdderImpl()
  }

  override fun onBind(intent: Intent?): IBinder? = adderImpl
}