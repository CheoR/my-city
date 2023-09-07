package com.example.mycity.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycity.R
import com.example.mycity.data.LocalCategoryDataProvider
import com.example.mycity.model.Category
import com.example.mycity.ui.theme.MyCityTheme

@Composable
fun BaseListScreen(
    list: List<Category>,
    onClick: (Category) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_medium)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
        modifier = modifier
    ) {
        items(list, key = { item -> item.id }){ item ->
            ListItem(
                item = item,
                onClick = onClick,
            )
        }
    }
}

@Composable
private fun ListItem(
    item: Category,
    onClick: (Category) -> Unit,
) {
    Card(
        elevation = CardDefaults.cardElevation(),
        modifier = Modifier,
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        onClick = { onClick(item) },
    ) {
        Row(
            modifier= Modifier
                .fillMaxWidth()
                .size(80.dp)  // dimensionResource(R.dimen.card_image_height))
                .background(color = MaterialTheme.colorScheme.secondary),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                color = MaterialTheme.colorScheme.onSecondary,
                style = MaterialTheme.typography.titleLarge,
                text= stringResource(item.categoryResourceId),
                modifier = Modifier
            )
        }
    }
}

@Preview()
@Composable
fun BaseListScreenPreview(){
    MyCityTheme() {
        Surface {
            BaseListScreen(
                list = LocalCategoryDataProvider.getCategoryData(),
                onClick = {}
            )
        }
    }
}
