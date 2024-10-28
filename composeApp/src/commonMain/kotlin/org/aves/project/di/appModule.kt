package org.aves.project.di

import org.aves.project.data.network.NetworkUtils
import org.aves.project.model.AvesData
import org.aves.project.viewmodel.BirdDetailsViewModel
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
/***
 * Project: KotlinAves
 * From: org.aves.project
 * Created by Jose Ortiz on 2024
 * More info: https://github.com/joseortiz-bot?tab=repositories
 ***/
val appModule = module {
    single { NetworkUtils }
    single { AvesData(get()) }
    viewModel { BirdDetailsViewModel(get()) }
}


fun main() {
    startKoin {
        modules(appModule)
    }
    // ...
}