package com.example.mycity.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mycity.R
import com.example.mycity.model.Attraction
import com.example.mycity.model.Category
import com.example.mycity.utils.ScreenContentType
import com.example.mycity.utils.ScreenNavigationType

// TODO: pass extra string to title
enum class Screen(@StringRes val title: Int) {
    CategoryListScreen(title = R.string.app_name),
    AttractionListScreen(title = R.string.attraction_list),
    AttractionDetailScreen(title = R.string.attraction_detail),
}

@Composable
fun MyCityAppBar(
    currentScreen: Screen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@Composable
fun MyCityApp(
    // TODO: figure out one one example initializes viewmodel as parameter and another
    // initializes in the body
    // viewModel: ScreenViewModel = viewModel(),
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    /*
    show Up button only  if there's a composable on the back stack
    If the app has no screens on the back stack show StartOrderScreen and hidethe Up button
    To check this, you need a reference to the back stack.
    */

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = Screen.valueOf(
        backStackEntry?.destination?.route ?: Screen.CategoryListScreen.name
    )

    /*
        To implement navigation drawer, determine navigation type based on the app's window size.
    */
    val navigationType: ScreenNavigationType

    /*
        For various window sizes to help determine the appropriate content type selection,
        depending on the screen size
     */
    val contentType: ScreenContentType

    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            navigationType = ScreenNavigationType.BOTTOM_NAVIGATION
            contentType = ScreenContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Medium -> {
            navigationType = ScreenNavigationType.NAVIGATION_RAIL
            contentType = ScreenContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Expanded -> {
            navigationType = ScreenNavigationType.PERMANENT_NAVIGATION_DRAWER
            contentType = ScreenContentType.LIST_AND_DETAIL
        }
        else -> {
            navigationType = ScreenNavigationType.BOTTOM_NAVIGATION
            contentType = ScreenContentType.LIST_ONLY
        }
    }


    val viewModel: ScreenViewModel = viewModel()

    // TODO: figure why why .value
    // val replyUiState = viewModel.uiState.collectAsState().value
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            MyCityAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = {
                    navController.navigateUp()
                }
            )
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = Screen.CategoryListScreen.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = Screen.CategoryListScreen.name) {
                viewModel.resetCategories()
                CategoryListScreen(
                    categories = uiState.categoryList,
                    onCategoryClick = {
                        viewModel.updateCurrentCategory(it as Category)
                        navController.navigate(Screen.AttractionListScreen.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium)),
                )
            }

            composable(route = Screen.AttractionListScreen.name) {
                AttractionListScreen(
                    attractions = uiState.attractionList,
                    onAttractionClick = {
                        viewModel.updateCurrentAttraction(it as Attraction)
                        navController.navigate(Screen.AttractionDetailScreen.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium)),
                )
            }

            composable(route = Screen.AttractionDetailScreen.name) {
                AttractionDetailScreen(
                    attraction = uiState.currentAttraction,
                    onNextButtonClicked = {
                        navController.popBackStack(Screen.CategoryListScreen.name, inclusive = false)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium)),
                )
            }
        }
    }
}
