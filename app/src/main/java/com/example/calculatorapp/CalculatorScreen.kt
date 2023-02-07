package com.example.calculatorapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculatorapp.viewmodels.CalculatorViewModel

@Composable
fun CalculatorScreen() {

    val viewModel = viewModel<CalculatorViewModel>()

    val inputEditText = viewModel.inputText.collectAsState()

    val tipTotal = viewModel.tipToString.collectAsState()

    val inputNumber: (String) -> Unit =  { inputString ->
        viewModel.updateInputText(inputString)
    }

    Column(
        modifier = Modifier.padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
        Text(
            text = stringResource(id = R.string.calculate_tip),
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        InputNumberField(value = inputEditText.value, onValueChange = {
            inputNumber(it)
        })

        Spacer(modifier = Modifier.height(30.dp))

        PlusAndMinusButton()

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = R.string.tip_amount, tipTotal.value),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun InputNumberField(value: String, onValueChange: (String) -> Unit) {

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = stringResource(id = R.string.bill_amount),
                modifier = Modifier.fillMaxWidth()
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true
    )

}

@Composable
fun PlusAndMinusButton() {
  /*  val viewModel = viewModel<CalculatorViewModel>()
    Row(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
    ) {
        //val counter: MutableState<Int> = remember { mutableStateOf(0) }
       // viewModel.counter
        Button(
            onClick = {/*viewModel.counter.value--*/},
            shape = CircleShape,
            modifier = Modifier.size(50.dp)
        ) {
            Icon(painter = painterResource(id = R.drawable.remove_icon), contentDescription = "Decrease")
        }
        Text(
            text = "",//viewModel.counter.value.toString(),
            modifier = Modifier.align(Alignment.CenterVertically),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Button(
            onClick = {/*viewModel.counter.value++*/},
            shape = CircleShape,
            modifier = Modifier.size(50.dp)
        ) {
            Icon(Icons.Rounded.Add, contentDescription = "Increment")
        }
    }*/

}





