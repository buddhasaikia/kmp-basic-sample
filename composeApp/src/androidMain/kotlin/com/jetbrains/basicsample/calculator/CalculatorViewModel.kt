package com.jetbrains.basicsample.calculator

import androidx.lifecycle.ViewModel
import com.jetbrains.basicsample.Calculator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CalculatorViewModel : ViewModel() {
    private var _sum = MutableStateFlow(0)
    val sum: StateFlow<Int> = _sum.asStateFlow()

    fun calculateSum(numberA: Int, numberB: Int) {
        val sum = Calculator.sum(numberA, numberB)
        _sum.update { sum }
    }
}