package com.example.mycity.ui

import androidx.lifecycle.ViewModel
import com.example.mycity.data.LocalAttractionDataProvider
import com.example.mycity.data.LocalCategoryDataProvider
import com.example.mycity.model.Attraction
import com.example.mycity.model.Category
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class ScreenViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        ScreenUiState(
            categoryList = LocalCategoryDataProvider.getCategoryData(),
            attractionList = LocalAttractionDataProvider.getAttractionData(),
            currentCategory = LocalCategoryDataProvider.getCategoryData().getOrElse(0) {
                LocalCategoryDataProvider.defaultCategory
            },
            currentAttraction = LocalAttractionDataProvider.getAttractionData().getOrElse(0) {
                LocalAttractionDataProvider.defaultAttraction
            }
        )
    )
    val uiState: StateFlow<ScreenUiState> = _uiState

    private fun setAttractionList(selectedCategory: Category) {
        _uiState.update {
            it.copy(attractionList =
                it.attractionList.filter {
                        attraction -> attraction.category == selectedCategory.categoryType
                }
            )
        }

    }
    fun updateCurrentCategory(selectedCategory: Category) {
        _uiState.update {
            it.copy(currentCategory = selectedCategory)
        }
        setAttractionList(selectedCategory)
    }

    fun resetCategories() {
        _uiState.value = ScreenUiState(
            categoryList = LocalCategoryDataProvider.getCategoryData(),
            attractionList = LocalAttractionDataProvider.getAttractionData(),
            currentCategory = LocalCategoryDataProvider.getCategoryData().getOrElse(0) {
                LocalCategoryDataProvider.defaultCategory
            },
            currentAttraction = LocalAttractionDataProvider.getAttractionData().getOrElse(0) {
                LocalAttractionDataProvider.defaultAttraction
            }
        )
    }
}

data class ScreenUiState(
    val categoryList: List<Category> = emptyList(),
    val attractionList: List<Attraction> = emptyList(),
    val currentCategory: Category = LocalCategoryDataProvider.defaultCategory,
    val currentAttraction: Attraction = LocalAttractionDataProvider.defaultAttraction,
)
