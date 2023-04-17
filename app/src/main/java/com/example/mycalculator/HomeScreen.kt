package com.example.mycalculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycalculator.ui.theme.MediumGray


@Composable
fun homeScreen()
{
    val viewModel= viewModel<CalculatorViewModel>()
    val state= viewModel.state
    val buttonSpacing= 8.dp



    Calculator(state = state, onAction = viewModel::onAction,
        buttonSpacing = buttonSpacing, modifier = Modifier
            .fillMaxSize()
            .background(
                MediumGray
            )
            .padding(16.dp)
    )
}


