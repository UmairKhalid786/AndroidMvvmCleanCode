package com.techlad.android_mvvm_clean_code.feature_sections.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techlad.android_mvvm_clean_code.feature_sections.domain.usecases.SectionsUseCase
import com.techlad.android_mvvm_clean_code.feature_sections.domain.Resource
import com.techlad.android_mvvm_clean_code.feature_sections.domain.model.Section
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by umair.khalid on 25,January,2022
 **/

@HiltViewModel
class SectionsViewModel @Inject constructor(private val useCase: SectionsUseCase) : ViewModel() {

    private val _sectionsList = MutableStateFlow<Resource<Section>>(Resource.loading())
    val sectionsList: StateFlow<Resource<Section>> = _sectionsList

    private val _sectionDetail = MutableStateFlow<Resource<Section>>(Resource.loading())
    val sectionDetail: StateFlow<Resource<Section>> = _sectionDetail

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
    }

    init {
        // As its shared viewmodel so it will be called only once
        getAllSections()
    }

    fun getSectionDetail(url: String) {
        _sectionDetail.value = Resource.loading()
        viewModelScope.launch(exceptionHandler) {
            useCase.getSectionDetail(url).collect {
                _sectionDetail.value = it
            }
        }
    }

    fun getAllSections() {
        viewModelScope.launch(exceptionHandler) {
            delay(100)
            useCase.getAllSections().collect {
                _sectionsList.value = it
            }
        }
    }
}