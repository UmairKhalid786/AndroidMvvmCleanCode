package com.techlad.android_mvvm_clean_code.nevigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.techlad.android_mvvm_clean_code.feature_sections.presentation.SectionsScreen
import com.techlad.android_mvvm_clean_code.feature_sections.presentation.SectionsViewModel
import com.techlad.android_mvvm_clean_code.feature_sections.presentation.section_details.SectionDetailsScreen
import com.techlad.android_mvvm_clean_code.nevigation.DetailsParam.Companion.SECTION_URL

/**
 * Created by umair.khalid on 25,January,2022
 **/

@ExperimentalMaterialApi
@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.Sections.title) {
        // e.g will add auth routes here if when we will extend project
        composable(Screens.Sections.title) {
            SectionsScreen(navController)
        }
        composable(Screens.SectionsDetail.title, arguments = listOf(
            navArgument(SECTION_URL) { type = NavType.StringType })
        ) {

            // Share parent viewmodel with given route
            val parentEntry = remember {
                navController.getBackStackEntry(Screens.Sections.title)
            }
            val vm = hiltViewModel<SectionsViewModel>(parentEntry)
            SectionDetailsScreen(Modifier, it.arguments?.getString(SECTION_URL), viewModel = vm)
        }
    }
}