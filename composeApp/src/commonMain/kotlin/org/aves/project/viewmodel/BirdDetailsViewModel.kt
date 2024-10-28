package org.aves.project.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.launch
import org.aves.project.common.BASE_URL
import org.aves.project.data.network.NetworkUtils
import org.aves.project.model.AvesData
import org.koin.core.component.KoinComponent

/***
 * Project: KotlinAves
 * From: org.aves.project
 * Created by Jose Ortiz on 2024
 * More info: https://github.com/joseortiz-bot?tab=repositories
 ***/

class BirdDetailsViewModel(private val networkUtils: NetworkUtils) : ViewModel(), KoinComponent {

    private val _birdData = mutableStateOf<AvesData?>(null)
    val birdData: State<AvesData?> get() = _birdData

    private val _errorMessage = mutableStateOf("")
    val errorMessage: State<String> get() = _errorMessage

    fun fetchBirdDetails(birdUid: String?) {
        viewModelScope.launch {
            if (birdUid != null) {
                try {
                    _birdData.value = networkUtils.httpClient.get("${BASE_URL}$birdUid").body() // Usas networkUtils aquí
                } catch (e: Exception) {
                    _errorMessage.value = e.message ?: "Error fetching data"
                }
            }
        }
    }
}
