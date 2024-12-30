package com.example.prak8mysqldatainternet.ui.viewmodel


object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer { HomeViewModel(aplikasiKontak().container.mahasiswaRepository) }
        initializer { InsertViewModel(aplikasiKontak().container.mahasiswaRepository) }
        initializer { UpdateViewModel(aplikasiKontak().container.mahasiswaRepository) }
        initializer { DetailViewModel(aplikasiKontak().container.mahasiswaRepository) }


    }
}
