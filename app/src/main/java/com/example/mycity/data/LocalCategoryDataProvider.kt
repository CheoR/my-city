package com.example.mycity.data

import com.example.mycity.R
import com.example.mycity.model.Category
import com.example.mycity.model.CategoryType

object LocalCategoryDataProvider {
    val defaultCategory = getCategoryData()[0]

    fun getCategoryData(): List<Category> {
        return listOf(
            Category(
                id =  1,
                categoryResourceId = R.string.music,
                categoryType = CategoryType.MUSIC,
                imageResourceId = R.drawable.placeholder,
            ),
            Category(
                id =  2,
                categoryResourceId = R.string.food,
                categoryType = CategoryType.FOOD,
                imageResourceId = R.drawable.placeholder,
            ),
            Category(
                id =  3,
                categoryType = CategoryType.HISTORICAL_AND_CULTURE,
                categoryResourceId = R.string.historical_and_cultural,
                imageResourceId = R.drawable.placeholder,
            ),
            Category(
                id =  4,
                categoryType = CategoryType.OUTDOORS_AND_NATURE,
                categoryResourceId = R.string.outdoor_and_nature,
                imageResourceId = R.drawable.placeholder,
            ),
            Category(
                id =  5,
                categoryType = CategoryType.NIGHTLIFE_AND_ENTERTAINMENT,
                categoryResourceId = R.string.nightlife_and_entertainment,
                imageResourceId = R.drawable.placeholder,
            ),
        )

    }
}