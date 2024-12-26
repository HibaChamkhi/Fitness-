package com.example.presentation.summary

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        CircularCountdownTimer(
            startCount = 3,
            totalDurationMs = 3000,
            circleSize = 200f,
            strokeWidth = 20f,
            onTimerFinish = {
                navController.navigate("timer_screen")
            }
        )
    }
}
