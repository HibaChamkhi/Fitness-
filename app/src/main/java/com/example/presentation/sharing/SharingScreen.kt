package com.example.presentation.sharing

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.fitness.R


@Composable
fun SharingHeader(
    modifier: Modifier = Modifier,
    imageResId: Int = R.drawable.sharing,
    imageSize: Dp = 30.dp,
    title: String = "Sharing",
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 22.dp, vertical = 20.dp)

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(imageResId)
                        .build()
                ),
                contentDescription = null,
                modifier = Modifier.size(imageSize)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                color = Color.White,
                fontSize = 34.sp
            )
        }
    }
}

@Composable
fun SharingScreen(
    modifier: Modifier = Modifier,
    headerImageResId: Int = R.drawable.sharing,
    headerTitle: String = "Sharing",
    middleText: String = "Share Activity",
    bottomText: String = "See how your data is managed.."
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top section
        SharingHeader(
            imageResId = headerImageResId,
            title = headerTitle
        )

        // Middle text
        Text(
            text = middleText,
            color = Color.White,
            fontSize = 30.sp
        )

        // Bottom text
        Text(
            text = bottomText,
            color = MaterialTheme.colorScheme.secondary,
            fontSize = 16.sp
        )
    }
}

@Preview
@Composable
fun PreviewSharingScreen() {
    SharingScreen()
}
