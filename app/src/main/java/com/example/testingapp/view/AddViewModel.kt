package com.example.testingapp.view

import com.example.testingapp.business.Adder

/**
 * Simple interface for a ViewModel which adds the 2 values given in input
 */
interface AddViewModel {

    /**
     * We sum the values and get the formatted String for the result
     */
    fun execSum(a: String, b: String): String
}