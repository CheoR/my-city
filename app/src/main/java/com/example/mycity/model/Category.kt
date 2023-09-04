package com.example.mycity.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category(
    val id: Int,
    @StringRes val categoryResourceId: Int,
    @DrawableRes val imageResourceId: Int,
)
