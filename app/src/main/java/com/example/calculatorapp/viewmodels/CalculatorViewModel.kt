package com.example.calculatorapp.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat

class CalculatorViewModel: ViewModel() {

    private val _inputText = MutableStateFlow("")
    val inputText: StateFlow<String> = _inputText

    private val _tipToString = MutableStateFlow("")
    val tipToString: StateFlow<String> = _tipToString
   // val counter: MutableState<Int> = mutableStateOf(0)

    fun updateInputText(text: String) {
        calculateTip(text.toDoubleOrNull() ?: 0.0)
        _inputText.update { text }
    }

    fun calculateTip(amount: Double, tipPercentage: Double = 10.0) {
        val tip = tipPercentage / 100 * amount
        val tipFormattedForCurrency = NumberFormat.getCurrencyInstance().format(tip)
        _tipToString.update { tipFormattedForCurrency }
    }

}