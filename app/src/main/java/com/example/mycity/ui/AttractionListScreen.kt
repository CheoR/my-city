package com.example.mycity.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mycity.model.Attraction

@Composable
fun AttractionListScreen(
    attractions: List<Attraction>,
//    onNextButtonClicked: (Int) -> Unit,
    onAttractionClick: (Any) -> Unit,
    modifier: Modifier = Modifier
){
    BaseListScreen(
        list = attractions,
        onClick = onAttractionClick,
    )
}
