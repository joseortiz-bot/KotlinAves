package org.aves.project.components.bird_details_components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.aves.project.common.VOLVERATRAS
import org.aves.project.model.AvesData

/***
 * Project: KotlinAves
 * From: org.aves.project
 * Created by Jose Ortiz on 2024
 * More info: https://github.com/joseortiz-bot?tab=repositories
 ***/

@Composable
fun BirdDetailsContent(birdData: AvesData, navController: NavController) {
    BirdGallery(birdData.images?.gallery)

    Spacer(Modifier.height(16.dp))

    BirdInfoExpandable(birdData)

    Spacer(Modifier.height(16.dp))

    BirdDetailsSection(birdData)

    Spacer(Modifier.height(16.dp))

    BirdAdditionalInfo(birdData)

    Spacer(Modifier.height(24.dp))

    Button(onClick = { navController.popBackStack() }) {
        Text(VOLVERATRAS)
    }
}