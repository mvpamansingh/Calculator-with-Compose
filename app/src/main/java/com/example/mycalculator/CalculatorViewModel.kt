package com.example.mycalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel :ViewModel(){

    var state by mutableStateOf(CalculatorState())
        private set


    fun onAction(action: CalculatorAction)
    {

        when(action)
        {
            is CalculatorAction.Number-> enterNimber(action.number)
            is CalculatorAction.Decimal-> enterDecimal()
            is CalculatorAction.Clear -> state= CalculatorState()
            is  CalculatorAction.Operations -> enterOperation(action.operation)
            is CalculatorAction.Calculate -> performCalculation()
            is CalculatorAction.Delete -> performDeletion()
        }
    }

    private fun performDeletion() {

        when{
            state.number2.isNotBlank() -> state= state.copy(
                number2= state.number2.dropLast(1)
            )
            state.operation  !=null -> state= state.copy(
                operation = null
            )

            state.number1.isNotBlank() -> state= state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
    }

    private fun performCalculation() {

        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if(number1 != null && number2 != null) {
            val result = when(state.operation) {
                is CalculatorOperation.add -> number1 + number2
                is CalculatorOperation.subtract -> number1 - number2
                is CalculatorOperation.multiply -> number1 * number2
                is CalculatorOperation.division -> number1 / number2
                null -> return
            }
            state = state.copy(
                number1 = result.toString().take(15),
                number2 = "",
                operation = null
            )
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if(state.number1.isNotBlank()) {
            state = state.copy(operation = operation)
        }

    }

    private fun enterDecimal() {

        if(state.operation== null && !state.number1.contains(".")&& state.number1.isNotBlank())
        {
            state= state.copy(
                number1= state.number1 + "."
            )
            return
        }

        if(!state.number2.contains(".")&& state.number2.isNotBlank())
        {
            state= state.copy(
                number2= state.number2 + "."
            )
        }
    }

    private fun enterNimber(number: Int) {

        if(state.operation==null)
        {
            if(state.number1.length >= Max_Length)
            {
                return
            }


            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }

        if(state.number2.length>= Max_Length)
        {
            return
        }

        state= state.copy(
            number2= state.number2 + number
        )



    }


        companion object
        {
            private const val Max_Length = 8
        }

}