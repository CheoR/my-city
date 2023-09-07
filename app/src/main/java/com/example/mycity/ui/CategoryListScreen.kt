package com.example.mycity.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mycity.model.Category

@Composable
fun CategoryListScreen (
    categories: List<Category>,
    title: String,
//    onNextButtonClicked: (Int) -> Unit,
    onClick: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        text = "Hello $title! Go eat!",
        modifier = modifier
    )
    BaseListScreen(
        list = categories,
        onClick = onClick,
    )
//        Button(
//            onClick = onNextButtonClicked,
//            modifier = modifier
//                .widthIn(min = 250.dp),
//            colors = ButtonDefaults.buttonColors(
//                contentColor = MaterialTheme.colorScheme.onPrimary,
//                containerColor = MaterialTheme.colorScheme.onBackground,
//            ),
//        ) {
//            Text("Next")// stringResource(labelResourceId))
//        }
}