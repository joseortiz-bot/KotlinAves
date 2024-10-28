package org.aves.project.ui.screens.bird



import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.aves.project.components.bird_details_components.BirdDetailsContent
import org.aves.project.data.network.NetworkUtils
import org.aves.project.viewmodel.BirdDetailsViewModel

/***
 * Project: KotlinAves
 * From: org.aves.project
 * Created by Jose Ortiz on 2024
 * More info: https://github.com/joseortiz-bot?tab=repositories
 ***/

@Composable
fun BirdDetailsScreen(
    navController: NavController,
    birdUid: String?,
    viewModel: BirdDetailsViewModel = BirdDetailsViewModel( NetworkUtils )
) {
    val birdData by viewModel.birdData
    val errorMessage by viewModel.errorMessage

    LaunchedEffect(birdUid) {
        viewModel.fetchBirdDetails(birdUid)
    }

    if (birdData == null && errorMessage.isEmpty()) {
        // Mostrar el indicador de carga si los datos aún no se han cargado
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                if (birdData != null) {
                    BirdDetailsContent(birdData!!, navController)
                } else {
                    Text(if (errorMessage.isEmpty()) "Loading bird details..." else errorMessage)
                }
            }
        }
    }
}






