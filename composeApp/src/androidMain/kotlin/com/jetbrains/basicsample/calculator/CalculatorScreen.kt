package com.jetbrains.basicsample.calculator

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.jetbrains.basicsample.greet

@Composable
fun CalculatorScreen(
    modifier: Modifier = Modifier,
    sum: Int = 0,
    onCalculate: (Int, Int) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
        ) {
            Text(greet(), Modifier.padding(8.dp))

            var firstNumber by rememberSaveable { mutableStateOf("") }
            var secondNumber by rememberSaveable { mutableStateOf("") }

            Row(verticalAlignment = Alignment.CenterVertically) {
                TextField(
                    value = firstNumber,
                    onValueChange = {
                        if (it.isDigitsOnly())
                            firstNumber = it
                    },
                    maxLines = 1,
                    modifier = Modifier.width(100.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                )
                Text(text = "+", modifier = Modifier.padding(4.dp))
                TextField(
                    value = secondNumber,
                    onValueChange = {
                        if (it.isDigitsOnly())
                            secondNumber = it
                    },
                    modifier = Modifier.width(100.dp),
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                )

                val first = firstNumber.toIntOrNull()
                val second = secondNumber.toIntOrNull()
                onCalculate(first ?: 0, second ?: 0)
                Text(
                    text = if (first != null && second != null) {
                        "= $sum"
                    } else {
                        "= \uD83E\uDD14"
                    },
                    modifier = Modifier
                        .width(100.dp)
                        .padding(4.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CalculatorScreenPreview() {
    CalculatorScreen(
        sum = 0,
        onCalculate = { _, _ -> }
    )
}