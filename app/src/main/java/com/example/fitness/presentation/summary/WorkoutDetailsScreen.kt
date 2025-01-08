package com.example.workoutdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.fitness.presentation.summary.WorkoutDetail


@Composable
fun WorkoutDetailScreen(
    workoutDetail: WorkoutDetail,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    onShareClick: () -> Unit = {},
    onNavigateToSomeScreen: () -> Unit = {

    }
) {
    Surface(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black),
        color = Color.Black
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            TopBar(
                onBackClick = onBackClick,
                onShareClick = onShareClick,
                workoutDate = workoutDetail.workoutDate
            )

            WorkoutSummarySection(
                workoutTitle = workoutDetail.workoutTitle,
                workoutTimeRange = workoutDetail.workoutTimeRange
            )

            Spacer(modifier = Modifier.height(16.dp))

            DetailsHeaderSection()

            Spacer(modifier = Modifier.height(12.dp))

            WorkoutInfoCard(
                totalWorkoutTime = workoutDetail.totalWorkoutTime,
                activeCalories = workoutDetail.activeCalories,
                onStartWorkoutClick = onNavigateToSomeScreen
            )
        }
    }
}


@Composable
fun TopBar(
    onBackClick: () -> Unit,
    onShareClick: () -> Unit,
    workoutDate: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onBackClick) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(com.example.fitness.R.drawable.backbutton)
                        .build()
                ),
                contentDescription = null,
                modifier = Modifier.size(17.dp)
            )
        }
        Text(
            text = "Summary",
            color = Color(0xFFADFF2F),
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = workoutDate,
            color = Color.White,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.width(8.dp))
        IconButton(onClick = onShareClick) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(com.example.fitness.R.drawable.share)
                        .build()
                ),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun WorkoutSummarySection(
    workoutTitle: String,
    workoutTimeRange: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(com.example.fitness.R.drawable.summary)
                    .build()
            ),
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = workoutTitle,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = workoutTimeRange,
                color = Color.Gray,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun DetailsHeaderSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Workouts Details",
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Show More",
            color = Color(0xFFADFF2F),
            fontSize = 18.sp
        )
    }
}

@Composable
fun WorkoutInfoCard(
    totalWorkoutTime: String,
    activeCalories: String,
    onStartWorkoutClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1C1C1C)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Workout Time",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                    Text(
                        text = totalWorkoutTime,
                        color = Color(0xFFADFF2F),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Active Calories",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                    Text(
                        text = activeCalories,
                        color = Color(0xFFFF3B30),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = onStartWorkoutClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                )
            ) {
                Text(
                    text = "Start Workout",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}


