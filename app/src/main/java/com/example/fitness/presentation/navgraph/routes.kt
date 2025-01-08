package com.example.fitness.presentation.navgraph

sealed class ScreenRoutes(val route: String) {
    object MainScreen : ScreenRoutes("main_screen")
    object WorkoutDetail : ScreenRoutes("workout_detail/1")
    object SomeScreen : ScreenRoutes("some_screen")
    object TimerScreen : ScreenRoutes("timer_screen")
}

