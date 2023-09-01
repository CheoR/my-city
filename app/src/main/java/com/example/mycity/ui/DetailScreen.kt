package com.example.mycity.ui

import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetailScreen(
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    Text(
        text = "Detail Screen!",
        modifier = modifier
    )
    Button(
        onClick = onNextButtonClicked,
        modifier = modifier.widthIn(min = 250.dp)
    ) {
        Text("Home")// stringResource(labelResourceId))
    }
}