package com.techlad.android_mvvm_clean_code.nevigation

import com.techlad.android_mvvm_clean_code.nevigation.DetailsParam.Companion.SECTION_URL

/**
 * Created by umair.khalid on 25,January,2022
 **/

sealed class Screens(val title: String) {
    object Sections : Screens("sections_screen")
    object SectionsDetail : Screens("details_screen/{$SECTION_URL}")
}

class DetailsParam {
    companion object {
        const val SECTION_URL = "sectionUrl"
    }
}
