package com.techlad.android_mvvm_clean_code.utils


/**
 * Created by umair.khalid on 25,January,2022
 **/

fun String.lastSegment(): String {
    return substring(lastIndexOf("/") + 1, length)
}

fun String.removeDtg(): String {
    return replace("{?dtg}", "")
}