package com.example.mycalculator

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mycalculator.ui.theme.Purple700

import kotlinx.coroutines.delay

@Composable
fun AnimatedSplashScreen(navController:NavHostController)
{

    var startAnimation by remember{
        mutableStateOf(false)
    }

    val alphaAnim= animateFloatAsState(
        targetValue = if(startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )

    )

    LaunchedEffect(key1 = true )
    {
        startAnimation =true
        delay(4000)
        navController.popBackStack()
        navController.navigate(home.route)
    }


    Splash(alpha = alphaAnim.value)
}

@Composable
fun Splash(alpha:Float)
{


    Box(modifier =
    Modifier
        .background(if (isSystemInDarkTheme()) Color.Black else Purple700)
        .fillMaxSize()
    , contentAlignment = Alignment.Center
    )
    {


        Image(painter = painterResource(id = R.drawable.calculatora), contentDescription ="s",
        modifier= Modifier.size(240.dp))
//        Icon(modifier = Modifier
//            .size(120.dp)
//            .alpha(alpha),imageVector = Icons.Default.Email, contentDescription ="Logo ",
//        tint = Color.White
//        )
    }
}