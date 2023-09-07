package com.example.mycity.ui

import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mycity.model.Category

@Composable
fun AttractionDetailScreen(
    attraction: Category,
    title: String,
    modifier: Modifier = Modifier,
    onNextButtonClicked: () -> Unit = {},
) {
    Text(
        modifier = modifier,
        text = "Detail Screen!",
    )
    Button(
        onClick = onNextButtonClicked,
        modifier = modifier.widthIn(min = 250.dp)
    ) {
        Text("Home")// stringResource(labelResourceId))
    }
}