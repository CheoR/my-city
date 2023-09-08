package com.example.mycity.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mycity.model.Category

@Composable
fun CategoryListScreen (
    categories: List<Category>,
//    onNextButtonClicked: (Int) -> Unit,
    onCategoryClick: (Any) -> Unit,
    modifier: Modifier = Modifier
) {

    BaseListScreen(
        modifier = modifier,
        list = categories,
        onClick = onCategoryClick,
    )
}