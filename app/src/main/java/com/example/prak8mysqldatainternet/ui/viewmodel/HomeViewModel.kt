package com.example.prak8mysqldatainternet.ui.viewmodel

sealed class HomeUiState {
    data class Success(val mahasiswa: List<Mahasiswa>) : HomeUiState()
    object Error : HomeUiState()
    object Loading : HomeUiState()
}

class HomeViewModel(private val mhs: MahasiswaRepository) : ViewModel() {
    var mhsUiState: HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set

    init {
        getMhs()
    }
}

fun getMhs() {
    viewModelScope.launch {
        mhsUiState = HomeUiState.Loading
        mhsUiState = try {
            HomeUiState.Success(mhs.getMahasiswa())
        } catch (e: IOException) {
            HomeUiState.Error
        } catch (e: HttpException) {
            HomeUiState.Error
        }
    }
}

fun deleteMhs(nim: String) {
    viewModelScope.launch {
        try {
            mhs.deleteMahasiswa(nim)
        } catch (e: IOException) {
            HomeUiState.Error
        } catch (e: HttpException) {
            HomeUiState.Error
        }
    }
}
}


