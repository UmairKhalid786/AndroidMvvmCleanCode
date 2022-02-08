package com.techlad.android_mvvm_clean_code.feature_sections.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.techlad.android_mvvm_clean_code.feature_sections.domain.model.SubSection
import com.techlad.android_mvvm_clean_code.utils.TestTags.SECTIONS_LIST

/**
 * Created by umair.khalid on 25,January,2022
 **/

@ExperimentalMaterialApi
@Composable
fun SectionsList(
    list: List<SubSection>,
    onSectionClick: (SubSection) -> Unit
) {

    LazyColumn(contentPadding = PaddingValues(16.dp), modifier = Modifier.testTag(SECTIONS_LIST)) {
        items(list.size, {
            it.toString()
        }, itemContent = {
            SectionCard(section = list[it]) {
                onSectionClick(list[it])
            }
        })
    }
}