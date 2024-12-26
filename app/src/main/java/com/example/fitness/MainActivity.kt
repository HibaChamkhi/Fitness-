package com.example.fitness

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.fitness.ui.theme.FitnessTheme
import com.example.presentation.MainScreen
import com.example.presentation.summary.SomeScreen

data class BottomNavigationItem(
    val title: String,
    val selectedIconResId: Int,
    val unselectedIcon: ImageVector,
)
const val WORKOUT_DETAIL_SCREEN = "workout_detail_screen"
const val SOME_SCREEN = "some_screen"
const val TIMER_SCREEN = "timer_screen"

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitnessTheme(
                darkTheme = false,
                dynamicColor = false
            ) {
                MainScreen()
            }
        }
    }
}







