package com.example.mycity.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

enum class CategoryType {
    MUSIC,
    FOOD,
    HISTORICAL_AND_CULTURE,
    OUTDOORS_AND_NATURE,
    NIGHTLIFE_AND_ENTERTAINMENT,
}

data class Category(
    val id: Int,
    val categoryType: CategoryType,
    @StringRes val categoryResourceId: Int,
    @DrawableRes val imageResourceId: Int,
)
