package com.example.fitness

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.fitness.ui.theme.FitnessTheme
import com.example.presentation.MainScreen

data class BottomNavigationItem(
    val title: String,
    val selectedIconResId: Int,
    val unselectedIcon: ImageVector,
)

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







