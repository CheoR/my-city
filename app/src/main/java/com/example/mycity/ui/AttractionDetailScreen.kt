package com.example.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycity.R
import com.example.mycity.data.LocalAttractionDataProvider
import com.example.mycity.model.Attraction
import com.example.mycity.ui.theme.MyCityTheme

@Composable
fun AttractionDetailScreen(
    attraction: Attraction,
    modifier: Modifier = Modifier,
    onNextButtonClicked: () -> Unit = {},
) {
    Column() {
        Box(
            modifier = Modifier
                .fillMaxWidth(1f),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(attraction.imageResourceId),
                contentDescription = null,
                modifier = Modifier
            )
        }
        Spacer(Modifier.height(50.dp))
        Text(
            text = stringResource(attraction.attractionResourceId),
            style = MaterialTheme.typography.titleLarge,
        )
        Spacer(Modifier.height(100.dp))
        Text(
            text = stringResource(attraction.attractionDetailId),
            style = MaterialTheme.typography.bodyMedium,
        )
        Spacer(Modifier.height(100.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(1f),
            horizontalArrangement = Arrangement.Center,
        ) {
            Button(
                onClick = onNextButtonClicked,
                modifier = modifier.widthIn(min = 250.dp)
            ) {
                Text(stringResource(id = R.string.home))
            }
        }
    }
}

@Preview
@Composable
fun PreviewAttractionDetailScreen(){
    MyCityTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            AttractionDetailScreen(
                attraction = LocalAttractionDataProvider.getAttractionData().getOrElse(0) {
                    LocalAttractionDataProvider.defaultAttraction
                },
                modifier = Modifier,
                onNextButtonClicked = {},
            )
        }
    }
}