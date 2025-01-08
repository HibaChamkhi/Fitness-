
package com.example.fitness.presentation.summary

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
    viewModel: TimerViewModel,
    onBackClick: () -> Unit = {},
    onShareClick: () -> Unit = {},
    title: String = "Strength Training"
) {
    val timeLeft by viewModel.timeLeft.collectAsState()
    val isRunning by viewModel.isRunning.collectAsState()

    val formattedTime = formatSecondsAsHHmmss(timeLeft)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
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
                // Back icon
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
                    color = Color(0xFFADFF2F),
                    fontSize = 16.sp,
                    modifier = Modifier.padding(start = 4.dp)
                )

                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.weight(1f))
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
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = formattedTime, // e.g. "00:20:00"
                color = Color.White,
                fontSize = 48.sp
            )
            Spacer(modifier = Modifier.height(40.dp))
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .background(Color(0xFF4A5B23), shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                IconButton(
                    onClick = { viewModel.onToggleTimer() }
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(
                                    if (isRunning) R.drawable.pause
                                    else R.drawable.play
                                )
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
                    onClick = { viewModel.onDecrementTime() },
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color(0xFFFF3B30), CircleShape)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(R.drawable.minus)
                                .build()
                        ),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                }
                IconButton(
                    onClick = { viewModel.onIncrementTime() },
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color(0xFFFF3B30), CircleShape)
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
            }

            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = { viewModel.onToggleTimer() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFADFF2F))
            ) {
                Text(
                    text = if (isRunning) "Pause" else "Start",
                    color = Color.Black,
                    fontSize = 18.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

// Helper function to format HH:mm:ss
private fun formatSecondsAsHHmmss(totalSeconds: Int): String {
    val hours = totalSeconds / 3600
    val minutes = (totalSeconds % 3600) / 60
    val seconds = totalSeconds % 60
    return String.format("%02d:%02d:%02d", hours, minutes, seconds)
}