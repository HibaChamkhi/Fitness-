package com.example.presentation.fitnessPlus

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.fitness.R

@Composable
fun FitnessPlusScreen(modifier: Modifier = Modifier) {
    val categories = listOf(
        CategoryItem("KICKBOXING", R.drawable.category1),
        CategoryItem("HIIT", R.drawable.category2),
        CategoryItem("MEDITATION", R.drawable.category3),
        CategoryItem("MEDITATION", R.drawable.category3),
    )
    val cyclingList = listOf(
        CyclingItem("Cycling with Rahul", "10min Latest Hits Ep86"),
        CyclingItem("Cycling with Rahul", "10min Latest Hits Ep86"),
        CyclingItem("Cycling with Rahul", "10min Latest Hits Ep86"),
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 22.dp, vertical = 40.dp
            )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(R.drawable.apple)
                        .build()
                ),
                contentDescription = null,
                modifier = Modifier.size(42.dp)
            )
            Text(text = "Fitness+", color = Color.White, fontSize = 36.sp)
        }
        Spacer(modifier = Modifier.height(10.dp))
        CategoryList(categories = categories)
        Spacer(modifier = Modifier.height(10.dp))
        WelcomeBox()
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Cycling for the Weekend", color = Color.White, fontSize = 24.sp)
        Text(text = "Energizing, 10-minute rides", color = Color.Gray, fontSize = 16.sp)
        Spacer(modifier = Modifier.height(10.dp))
        CyclingList(cycling = cyclingList)
    }
}


@Preview
@Composable
fun PreviewFitnessPlusScreen() {
    FitnessPlusScreen()
}





