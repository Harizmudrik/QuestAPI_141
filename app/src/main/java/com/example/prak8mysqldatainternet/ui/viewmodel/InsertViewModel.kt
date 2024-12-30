package com.example.prak8mysqldatainternet.ui.viewmodel

class InsertViewModel(private val mhs: MahasiswaRepository) : ViewModel() {
    var uiState by mutableStateOf(InsertUiState())
        private set
