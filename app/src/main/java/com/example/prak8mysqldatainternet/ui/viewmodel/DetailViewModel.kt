package com.example.prak8mysqldatainternet.ui.viewmodel

import MahasiswaRepository
import coil.network.HttpException
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prak8mysqldatainternet.model.Mahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.IOException


sealed class DetailUiState {
    object Loading : DetailUiState()
    data class Success(val mahasiswa: Mahasiswa) : DetailUiState()
    object Error : DetailUiState()
}

class DetailViewModel(private val repository: MahasiswaRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<DetailUiState>(DetailUiState.Loading)
    val uiState: StateFlow<DetailUiState> = _uiState

    fun getMahasiswaById(nim: String) {
        viewModelScope.launch {
            _uiState.value = DetailUiState.Loading
            try {
                val mahasiswa = repository.getMahasiswaById(nim)
                _uiState.value = DetailUiState.Success(mahasiswa)
            } catch (e: IOException) {
                e.printStackTrace()
                _uiState.value = DetailUiState.Error
            } catch (e: HttpException) {
                e.printStackTrace()
                _uiState.value = DetailUiState.Error
            }
        }
    }
}