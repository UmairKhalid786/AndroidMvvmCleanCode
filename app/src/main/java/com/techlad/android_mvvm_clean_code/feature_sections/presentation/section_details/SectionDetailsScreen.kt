package com.techlad.android_mvvm_clean_code.feature_sections.presentation.section_details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.techlad.android_mvvm_clean_code.feature_sections.presentation.TryAgainWidget
import com.techlad.android_mvvm_clean_code.feature_sections.domain.Resource
import com.techlad.android_mvvm_clean_code.feature_sections.presentation.SectionsViewModel

/**
 * Created by umair.khalid on 25,January,2022
 **/

@Composable
fun SectionDetailsScreen(
    modifier: Modifier = Modifier,
    url: String?,
    viewModel: SectionsViewModel = hiltViewModel(),
) {

    val sectionsResponse = viewModel.sectionDetail.collectAsState()

    LaunchedEffect(key1 = url) {
        url?.let { viewModel.getSectionDetail(it) }
    }

    Box(modifier = modifier.fillMaxSize()) {
        when (sectionsResponse.value.status) {
            Resource.Status.LOADING -> {
                Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
            Resource.Status.SUCCESS -> {
                sectionsResponse.value.data?.let {
                    SectionDetailContent(it)
                }
            }
            Resource.Status.ERROR -> {
                TryAgainWidget(sectionsResponse.value.message) {
                    url?.let { viewModel.getSectionDetail(it) }
                }
            }
        }
    }
}
