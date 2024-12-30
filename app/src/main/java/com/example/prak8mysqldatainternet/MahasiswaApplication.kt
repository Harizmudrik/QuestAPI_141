package com.example.prak8mysqldatainternet

import android.app.Application
import com.example.prak8mysqldatainternet.depedenciesinjection.AppContainer
import com.example.prak8mysqldatainternet.depedenciesinjection.MahasiswaContainer


class MahasiswaApplications:Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = MahasiswaContainer()
    }

}