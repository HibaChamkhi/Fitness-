package com.example.fitness.presentation.navgraph
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.fitness.presentation.MainScreen
import com.example.fitness.presentation.summary.SomeScreen
import com.example.fitness.presentation.summary.TimerScreen
import com.example.fitness.presentation.summary.TimerViewModel
import com.example.fitness.presentation.summary.WorkoutDetail
import com.example.workoutdetails.WorkoutDetailScreen

@Composable
fun MainNavHost(navController: NavHostController) {
    val viewModel: TimerViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.MainScreen.route
    ) {
        composable(ScreenRoutes.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(
            route = "workout_detail/{workoutId}",
            arguments = listOf(navArgument("workoutId") {
                type = NavType.LongType
            })
        ) { backStackEntry ->
            WorkoutDetailScreen(
                workoutDetail = WorkoutDetail(
                    workoutId = backStackEntry.arguments?.getLong("workoutId").toString(),
                    workoutDate = "Dec 26, 2024",
                    workoutTitle = "Morning Cardio",
                    workoutTimeRange = "6:00 AM - 7:00 AM",
                    totalWorkoutTime = "1h",
                    activeCalories = "450 kcal"
                ),
                onBackClick = { navController.popBackStack() },
                onNavigateToSomeScreen = {
                    navController.navigate(ScreenRoutes.SomeScreen.route)
                }
            )
        }
        composable(route = ScreenRoutes.SomeScreen.route) {
            SomeScreen(navController = navController)
        }
        composable(
            route = ScreenRoutes.TimerScreen.route,
        ) { backStackEntry ->
            TimerScreen(
                onBackClick = {
                    navController.popBackStack(ScreenRoutes.WorkoutDetail.route, false)
                },
                viewModel = viewModel
            )
        }
    }
}


