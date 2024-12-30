package com.example.prak8mysqldatainternet.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
    data class Mahasiswa (
        val nama: String,
        val nim: String,

        @SerialName("jenis_kelamin")
        val jenisKelamin: String,

        val alamat: String,
        val kelas: String,
        val angkatan:String
    )
