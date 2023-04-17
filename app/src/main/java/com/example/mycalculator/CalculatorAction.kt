package com.example.mycalculator

sealed class CalculatorAction
{

    data class Number(val number:Int):CalculatorAction()

    object Delete: CalculatorAction()

    object Decimal: CalculatorAction()

    object Clear:CalculatorAction()

    object Calculate:CalculatorAction()

    data class Operations(val operation:CalculatorOperation):CalculatorAction()

}

// Data class is useto hold data. MOST IMPORTANT --  IT IS USE TO TRANSFER DATA TO VIEW MODEL AS AN ACTION TYPE