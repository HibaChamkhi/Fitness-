package com.example.presentation.summary

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.fitness.R

@Composable
fun SummaryScreen(
    modifier: Modifier = Modifier,
    onWorkoutClick: (String) -> Unit
) {
    val workoutList = listOf(

        WorkoutDetail(
            workoutId = "1",
            workoutTitle = "Traditional Strength Training",
            workoutTimeRange = "3:05 AM - 3:07 AM",
            workoutDate = "Tue, Aug 9",
            totalWorkoutTime = "0:02",
            activeCalories = "0CAL"
        ),

        WorkoutDetail(
            workoutId = "1",
            workoutTitle = "Traditional Strength Training",
            workoutTimeRange = "3:05 AM - 3:07 AM",
            workoutDate = "Tue, Aug 9",
            totalWorkoutTime = "0:02",
            activeCalories = "0CAL"
        )
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
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = "SUNDAY, APR 9", color = Color.Gray, fontSize = 14.sp)
                Text(text = "Summary", color = Color.White, fontSize = 40.sp)
            }
            Image(
                painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(R.drawable.profile)
                        .build()
                ),
                contentDescription = null,
                modifier = Modifier.size(36.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(text = "Workouts", color = Color.White, fontSize = 22.sp)
            Text(text = "Show More", color = MaterialTheme.colorScheme.secondary, fontSize = 18.sp)
        }
        WorkoutList(workouts = workoutList,
            onWorkoutClick = onWorkoutClick
        )
    }
}

//@Preview
//@Composable
//fun PreviewSummaryScreen() {
//    SummaryScreen()
//}
