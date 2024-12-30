package com.example.prak8mysqldatainternet.ui.viewmodel

import MahasiswaRepository
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class UpdateViewModel(private val mhs: MahasiswaRepository) : ViewModel() {
    var uiState by mutableStateOf(UpdateUiState())
        private set