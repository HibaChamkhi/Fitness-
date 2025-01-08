package com.example.fitness.presentation.summary

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun CircularCountdownTimer(
    startCount: Int = 3,
    totalDurationMs: Int = 3000,
    circleSize: Float = 200f,
    strokeWidth: Float = 20f,
    onTimerFinish: () -> Unit
) {
    val circlePx = with(LocalDensity.current) { circleSize.dp.toPx() }
    val strokePx = with(LocalDensity.current) { strokeWidth.dp.toPx() }

    var currentCount by remember { mutableIntStateOf(startCount) }

    val animatedFraction = remember { Animatable(1f) }

    LaunchedEffect(Unit) {
        animatedFraction.animateTo(
            targetValue = 0f,
            animationSpec = tween(
                durationMillis = totalDurationMs,
                easing = LinearEasing
            )
        )
        onTimerFinish()
    }

    LaunchedEffect(Unit) {
        for (i in startCount downTo 1) {
            currentCount = i
            delay(totalDurationMs.toLong() / startCount)
        }
        currentCount = 0
    }

    val sweepAngle = 360 * animatedFraction.value

    Box(
        modifier = Modifier
            .size(circleSize.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawArc(
                color = androidx.compose.ui.graphics.Color(0xFF4A5B23), // dark green
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                topLeft = Offset.Zero,
                size = Size(circlePx, circlePx),
                style = Stroke(strokePx, cap = StrokeCap.Round, join = StrokeJoin.Round)
            )
            drawArc(
                color = androidx.compose.ui.graphics.Color(0xFFC8FF73), // lime green
                startAngle = -90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                topLeft = Offset.Zero,
                size = Size(circlePx, circlePx),
                style = Stroke(strokePx, cap = StrokeCap.Round, join = StrokeJoin.Round)
            )
        }
        BasicText(
            text = currentCount.toString(),
            style = TextStyle(
                color = androidx.compose.ui.graphics.Color.White,
                fontSize = 48.sp
            )
        )
    }
}

