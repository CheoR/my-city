package com.example.mycity.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mycity.model.Category

@Composable
fun AttractionListScreen(
    attractions: List<Category>,
    title: String,
//    onNextButtonClicked: (Int) -> Unit,
    onClick: (Category) -> Unit,
    modifier: Modifier = Modifier
){
    Text(text=title)
    BaseListScreen(
        list = attractions,
        onClick = onClick,
    )
}
