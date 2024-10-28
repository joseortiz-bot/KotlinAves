package org.aves.project.ui.screens.bird

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.aves.project.common.BASE_URL
import org.aves.project.components.bird_list_components.BirdItem
import org.aves.project.data.network.NetworkUtils.httpClient
import org.aves.project.model.AvesData

/***
 * Project: KotlinAves
 * From: org.aves.project
 * Created by Jose Ortiz on 2024
 * More info: https://github.com/joseortiz-bot?tab=repositories
 ***/

@Composable
fun BirdListScreen(navController: NavController) {
    val apiUrl = BASE_URL
    var birds by remember { mutableStateOf<List<AvesData>>(emptyList()) }
    var errorMessage by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        errorMessage = ""
        try {
            birds = httpClient.get(apiUrl).body()
        } catch (e: Exception) {
            errorMessage = e.message ?: ""
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (birds.isNotEmpty()) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {
                items(birds) { bird ->
                    BirdItem(bird, navController)
                }
            }
        } else {
            Text(if (errorMessage.isEmpty()) "Loading..." else errorMessage)
        }
    }
}

