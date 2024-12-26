package com.example.presentation.fitnessPlus

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class CyclingItem(
    val title: String,
    val subTitle: String,
)
@Composable
fun CyclingList(
    cycling: List<CyclingItem>
) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp) // space between items
    ) {
        items(cycling) { item ->
            // Call the Cycling composable
            Cycling(
                title = item.title,
                subTitle = item.subTitle,
            )
        }
    }
}
@Composable
fun Cycling(
    title: String,
    subTitle: String,
    modifier: Modifier = Modifier
) {
 Column {
     RoundedRectangleCanvas()
     Spacer(modifier = Modifier.width(8.dp))
     Text(
         text = title,
         color = Color.White,
         fontSize = 12.sp
     )
     Text(
         text = subTitle,
         color = Color.White,
         fontSize = 12.sp
     )
 }
}

@Composable
fun RoundedRectangleCanvas() {
    val rectangleColor = MaterialTheme.colorScheme.tertiary
    Canvas(modifier = Modifier.size(width = 230.dp, height = 136.dp)) {
        val cornerRadius = 16.dp.toPx()
        drawRoundRect(
            color = rectangleColor,
            cornerRadius = CornerRadius(cornerRadius, cornerRadius),
            style = Fill
        )
    }
}
