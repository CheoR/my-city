package com.example.mycity.ui

import androidx.lifecycle.ViewModel
import com.example.mycity.data.LocalCategoryDataProvider
import com.example.mycity.model.Category
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CategoryViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        CategoryUiState(
            categoryList = LocalCategoryDataProvider.getCategoryData(),
            currentCategory = LocalCategoryDataProvider.getCategoryData().getOrElse(0) {
                LocalCategoryDataProvider.defaultCategory
            }
        )
    )
    val uiState: StateFlow<CategoryUiState> = _uiState
}

data class CategoryUiState(
    val categoryList: List<Category> = emptyList(),
    val currentCategory: Category = LocalCategoryDataProvider.defaultCategory,
//    val isShowingListPage: Boolean = true
)
