package com.example.prak8mysqldatainternet.ui.viewmodel

import com.example.prak8mysqldatainternet.model.Mahasiswa


sealed class DetailUiState {
    object Loading : DetailUiState()
    data class Success(val mahasiswa: Mahasiswa) : DetailUiState()
    object Error : DetailUiState()
}