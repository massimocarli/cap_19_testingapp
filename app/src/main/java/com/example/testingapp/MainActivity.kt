package com.example.testingapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.testingapp.business.Adder
import com.example.testingapp.business.IntValidator
import com.example.testingapp.business.IntValidatorImpl
import com.example.testingapp.business.SimpleAdderImpl
import com.example.testingapp.view.AddViewModel
import com.example.testingapp.view.AddViewModelImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adder: Adder
    lateinit var viewModel: AddViewModel
    lateinit var validator: IntValidator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adder = SimpleAdderImpl()
        validator = IntValidatorImpl()
        viewModel = AddViewModelImpl(this, adder, validator)
    }


    fun calculate(view: View) {
        resultOutput.text = viewModel.execSum(
                inputA.text.toString(),
                inputB.text.toString()
        )
    }
}
