package com.example.mycity.ui

import androidx.lifecycle.ViewModel
import com.example.mycity.data.LocalCategoryDataProvider
import com.example.mycity.model.Category
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class ScreenViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        ScreenUiState(
            categoryList = LocalCategoryDataProvider.getCategoryData(),
            currentCategory = LocalCategoryDataProvider.getCategoryData().getOrElse(0) {
                LocalCategoryDataProvider.defaultCategory
            }
        )
    )
    val uiState: StateFlow<ScreenUiState> = _uiState

    fun updateCurrentCategory(selectedCategory: Category) {
        _uiState.update {
            it.copy(currentCategory = selectedCategory)
        }
    }
}

data class ScreenUiState(
    val categoryList: List<Category> = emptyList(),
    val currentCategory: Category = LocalCategoryDataProvider.defaultCategory,
)
