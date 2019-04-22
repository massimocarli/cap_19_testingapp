package com.example.testingapp.service

class RemoteAdderImpl : RemoteAdder.Stub() {
  override fun add(a: Int, b: Int): Int = a + b
}