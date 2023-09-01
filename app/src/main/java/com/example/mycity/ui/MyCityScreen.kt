package com.example.mycity.ui

import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
        modifier = modifier
            .widthIn(min = 250.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = MaterialTheme.colorScheme.onPrimary,
            containerColor = MaterialTheme.colorScheme.onBackground,
        ),
    ) {
        Text("Next")// stringResource(labelResourceId))
    }
}