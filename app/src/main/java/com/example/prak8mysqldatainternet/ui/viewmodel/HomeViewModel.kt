package com.example.prak8mysqldatainternet.ui.viewmodel

sealed class HomeUiState {
    data class Success(val mahasiswa: List<Mahasiswa>) : HomeUiState()
    object Error : HomeUiState()
    object Loading : HomeUiState()
}

class HomeViewModel(private val mhs: MahasiswaRepository) : ViewModel() {
    var mhsUiState: HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set
