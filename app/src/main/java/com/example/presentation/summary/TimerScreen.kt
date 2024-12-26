package com.example.presentation.summary

import androidx.compose.runtime.Composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
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
fun TimerScreen(
    // Callbacks
    onBackClick: () -> Unit = {},
    onShareClick: () -> Unit = {},
    onStartClick: () -> Unit = {},
    onPlusClick: () -> Unit = {},
    onMinusClick: () -> Unit = {},

    // State
    title: String = "Strength Training",
    currentTime: String = "20:00:00"
) {
    // Colors (adjust to your liking)
    val blackColor = Color.Black
    val limeGreen = Color(0xFFADFF2F) // or C8FF73
    val darkGreen = Color(0xFF4A5B23)
    val red = Color(0xFFFF3B30)
    val white = Color.White

    // Screen background
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(blackColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top bar
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBackClick) {
                    Image(
                        painter = rememberAsyncImagePainter(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(R.drawable.backbutton)
                                .build()
                        ),
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                }

                Text(
                    text = "Summary",
                    color = limeGreen,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(start = 4.dp)
                )

                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = title,
                    color = white,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.weight(1f))

                // Share icon
                IconButton(onClick = onShareClick) {
                    Image(
                        painter = rememberAsyncImagePainter(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(R.drawable.share)
                                .build()
                        ),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            // Time display in the center
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = currentTime,
                color = white,
                fontSize = 48.sp
            )
            Spacer(modifier = Modifier.height(40.dp))
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .background(darkGreen, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                IconButton(onClick = { /* handle play/pause logic */ }) {
                    Image(
                        painter = rememberAsyncImagePainter(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(com.example.fitness.R.drawable.play)
                                .build()
                        ),
                        contentDescription = null,
                        modifier = Modifier.size(50.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(40.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(40.dp)
            ) {
                IconButton(
                    onClick = onMinusClick,
                    modifier = Modifier
                        .size(50.dp)
                        .background(red, CircleShape)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(R.drawable.plus)
                                .build()
                        ),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                }
                // Plus
                IconButton(
                    onClick = onPlusClick,
                    modifier = Modifier
                        .size(50.dp)
                        .background(red, CircleShape)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(com.example.fitness.R.drawable.minus)
                                .build()
                        ),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            // Start button at the bottom
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = onStartClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = limeGreen)
            ) {
                Text(
                    text = "Start",
                    color = Color.Black,
                    fontSize = 18.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
