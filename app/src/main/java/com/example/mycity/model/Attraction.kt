package com.example.mycity.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Attraction(
    val id: Int,
    val category: CategoryType,
    @StringRes val attractionResourceId: Int,
    @DrawableRes val imageResourceId: Int,
)
