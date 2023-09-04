package com.example.mycity.data

import com.example.mycity.R
import com.example.mycity.model.Category

object LocalCategoryDataProvider {
    val defaultCategory = getCategoryData()[0]

    fun getCategoryData(): List<Category> {
        return listOf(
            Category(
                id =  1,
                categoryResourceId = R.string.music,
                imageResourceId = R.drawable.placeholder,
            ),
            Category(
                id =  1,
                categoryResourceId = R.string.food,
                imageResourceId = R.drawable.placeholder,
            ),
            Category(
                id =  1,
                categoryResourceId = R.string.historical_and_cultural,
                imageResourceId = R.drawable.placeholder,
            ),
            Category(
                id =  1,
                categoryResourceId = R.string.outdoor_and_nature,
                imageResourceId = R.drawable.placeholder,
            ),
            Category(
                id =  1,
                categoryResourceId = R.string.nightlife_and_entertainment,
                imageResourceId = R.drawable.placeholder,
            ),
        )

    }
}