package com.example.prak8mysqldatainternet.depedenciesinjection

import MahasiswaRepository


interface AppContainer {
    val mahasiswaRepository: MahasiswaRepository
}

class MahasiswaContainer : AppContainer {
    private val baseUrl = "http://localhost/UmyTI/"
    private val json = Json{ignoreUnknownKeys = true}
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl).build()

    private val mahasiswaService: MahasiswaService by lazy { retrofit.create(MahasiswaService::class.java) }
    override val mahasiswaRepository: MahasiswaRepository by lazy { NetworkMahasiswaRepository(mahasiswaService) }
}
