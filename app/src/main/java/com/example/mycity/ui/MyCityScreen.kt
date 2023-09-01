package com.example.mycity.ui

import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun MyCityScreen (
    name: String,
//    onNextButtonClicked: (Int) -> Unit,
    onNextButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        text = "Hello $name! Go eat!",
        modifier = modifier
    )
    Button(
        onClick = onNextButtonClicked,
        modifier = modifier.widthIn(min = 250.dp)
    ) {
        Text("Next")// stringResource(labelResourceId))
    }
}