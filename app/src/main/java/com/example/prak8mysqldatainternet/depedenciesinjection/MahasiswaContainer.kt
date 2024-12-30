package com.example.prak8mysqldatainternet.depedenciesinjection

import MahasiswaRepository


interface AppContainer {
    val mahasiswaRepository: MahasiswaRepository
}

class MahasiswaContainer : AppContainer {

}
