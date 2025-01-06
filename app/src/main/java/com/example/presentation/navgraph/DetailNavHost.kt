package com.example.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

import com.example.presentation.summary.SomeScreen
import com.example.presentation.summary.SummaryScreen
import com.example.presentation.summary.TimerScreen
import com.example.presentation.summary.WorkoutDetail
import com.example.workoutdetails.WorkoutDetailScreen

@Composable
fun DetailNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "workout_list"
    ) {
        composable("workout_list") {
            SummaryScreen(
                onWorkoutClick = { workoutId ->
                    navController.navigate("workout_detail/$workoutId")
                }
            )
        }
        composable(
            route = "workout_detail/{workoutId}",
            arguments = listOf(navArgument("workoutId") {
                type = NavType.LongType
            })
        ) { backStackEntry ->
            WorkoutDetailScreen(
                workoutDetail = WorkoutDetail(
                    workoutId = "1",
                    workoutDate = "Dec 26, 2024",
                    workoutTitle = "Morning Cardio",
                    workoutTimeRange = "6:00 AM - 7:00 AM",
                    totalWorkoutTime = "1h",
                    activeCalories = "450 kcal"
                ),
                onBackClick = { navController.popBackStack() },
                onNavigateToSomeScreen = { navController.navigate("some_screen") }
            )

        }
        composable("some_screen") {
            SomeScreen(navController = navController)
        }
        composable(
            route = "timer_screen",
        ) { backStackEntry ->
            TimerScreen(
                onBackClick = {
                    navController.popBackStack("workout_detail/1", false)
                }
            )
        }


    }
}


