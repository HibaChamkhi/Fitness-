package com.example.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.fitness.BottomNavigationItem
import com.example.fitness.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val items = listOf(
        BottomNavigationItem(
            title = "Summary",
            selectedIconResId = R.drawable.bottomnav2,
            unselectedIcon = Icons.Outlined.Home,
        ),
        BottomNavigationItem(
            title = "Fitness+",
            selectedIconResId = R.drawable.bottomnav2,
            unselectedIcon = Icons.Outlined.Email,
        ),
        BottomNavigationItem(
            title = "Sharing",
            selectedIconResId = R.drawable.bottomnav2,
            unselectedIcon = Icons.Outlined.Settings,
        ),
    )

    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.Black,
        bottomBar = {
            BottomNavigationBar(
                items = items,
                selectedIndex = selectedItemIndex,
                onItemSelected = { index ->
                    selectedItemIndex = index
                }
            )
        }
    ) {
        when (selectedItemIndex) {
            0 -> SummaryScreen()
            1 -> FitnessPlusScreen()
            2 -> SharingScreen()
        }
    }
}