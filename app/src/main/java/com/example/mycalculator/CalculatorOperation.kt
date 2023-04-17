package com.example.mycalculator

sealed class CalculatorOperation(val symbol:String)
{
    object add:CalculatorOperation("+")
    object subtract:CalculatorOperation("-")
    object multiply:CalculatorOperation("x")
    object division:CalculatorOperation("/")

}
