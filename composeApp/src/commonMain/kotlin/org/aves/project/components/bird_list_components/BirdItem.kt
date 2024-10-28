package org.aves.project.components.bird_list_components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import org.aves.project.model.AvesData

/***
 * Project: KotlinAves
 * From: org.aves.project
 * Created by Jose Ortiz on 2024
 * More info: https://github.com/joseortiz-bot?tab=repositories
 ***/

@Composable
fun BirdItem(bird: AvesData, navController: NavController) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate("details/${bird.uid}")
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = bird.images?.full,
            contentDescription = "Imagen de ${bird.name?.spanish}",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(2.8f / 3f)
                .clip(MaterialTheme.shapes.small)
                .clip(RoundedCornerShape(16.dp))
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = "Nombre en Español: ${bird.name?.spanish ?: "N/A"}",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
    Spacer(Modifier.height(8.dp))
}