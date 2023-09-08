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
import com.example.mycity.model.Attraction
import com.example.mycity.model.Category
import com.example.mycity.ui.theme.MyCityTheme

@Composable
fun BaseListScreen(
    list: List<Any>,
    onClick: (Any) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_medium)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
        modifier = modifier
    ) {

        if(list[0] is Category) {
            items(list, key = { item -> (item as Category).id }){ item ->
                ListItem(
                    item = item as Category,
                    listItemClick = onClick,
                )
            }
        } else {
            items(list, key = { item -> (item as Attraction).id }){ item ->
                ListItem(
                    item = item as Attraction,
                    listItemClick = onClick,
                )
            }
        }
    }
}

@Composable
private fun ListItem(
    item: Any,
    listItemClick: (Any) -> Unit,
) {
    Card(
        elevation = CardDefaults.cardElevation(),
        modifier = Modifier,
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        onClick = {
            listItemClick(item)
                  },
    ) {
        Row(
            modifier= Modifier
                .fillMaxWidth()
                .size(80.dp)  // dimensionResource(R.dimen.card_image_height))
                .background(color = MaterialTheme.colorScheme.secondary),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {

            if(item is Category) {
                Text(
                    modifier = Modifier,
                    color = MaterialTheme.colorScheme.onSecondary,
                    style = MaterialTheme.typography.titleLarge,
                    // No cast needed cause of if check
                    text= stringResource(item.categoryResourceId),
                )
            } else {
                Text(
                    color = MaterialTheme.colorScheme.onSecondary,
                    style = MaterialTheme.typography.titleLarge,
                    text= stringResource((item as Attraction).attractionResourceId),
                    modifier = Modifier
                )
            }
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
