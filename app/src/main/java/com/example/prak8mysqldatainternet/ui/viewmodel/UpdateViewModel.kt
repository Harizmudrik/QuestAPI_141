package com.example.prak8mysqldatainternet.ui.viewmodel

import MahasiswaRepository
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UpdateViewModel(private val mhs: MahasiswaRepository) : ViewModel() {
    var uiState by mutableStateOf(UpdateUiState())
        private set

    fun loadMahasiswa(nim: String) {
        viewModelScope.launch {
            try {
                val mahasiswa = mhs.getMahasiswaById(nim)
                uiState = UpdateUiState(updateUiEvent = mahasiswa.toUpdateUiEvent())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }