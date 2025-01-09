package com.jetbrains.basicsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.jetbrains.basicsample.calculator.CalculatorScreen
import com.jetbrains.basicsample.calculator.CalculatorViewModel

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel by viewModels<CalculatorViewModel>()
            val sum = viewModel.sum.collectAsState()
            CalculatorScreen(
                sum = sum.value,
                onCalculate = { numberA, numberB ->
                    viewModel.calculateSum(numberA, numberB)
                }
            )
        }
    }
}
