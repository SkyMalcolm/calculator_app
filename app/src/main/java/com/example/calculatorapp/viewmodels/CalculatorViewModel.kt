package com.example.calculatorapp.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat

class CalculatorViewModel: ViewModel() {

    private val _inputText = MutableStateFlow("")
    val inputText: StateFlow<String> = _inputText

    private val _tipInputText = MutableStateFlow("")
    val tipInputText: StateFlow<String> = _tipInputText

    val tipPercent = tipInputText.value.toDoubleOrNull() ?: 0.0

    private val _tipToString = MutableStateFlow("")
    val tipToString: StateFlow<String> = _tipToString
   // val counter: MutableState<Int> = mutableStateOf(0)


    fun updateInputText(text: String) {
        _inputText.update { text }

    }

    fun updateTipInputText(tipText: String) {
        _tipInputText.update { tipText }
        calculateTip(inputText.value.toDoubleOrNull() ?: 0.0, tipText.toDoubleOrNull() ?: 0.0)
    }

    fun calculateTip(amount: Double, tipPercentage: Double) {
        val tip = (tipPercentage / 100) * amount
        val tipFormattedForCurrency = NumberFormat.getCurrencyInstance().format(tip)
        _tipToString.update { tipFormattedForCurrency }
    }

}