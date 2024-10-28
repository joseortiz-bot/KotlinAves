package org.aves.project.components.bird_details_components

import androidx.compose.runtime.Composable
import org.aves.project.common.AMENAZAS
import org.aves.project.common.DIDYOUKNOW
import org.aves.project.common.HABITAT
import org.aves.project.components.DetailItem
import org.aves.project.model.AvesData

/***
 * Project: KotlinAves
 * From: org.aves.project
 * Created by Jose Ortiz on 2024
 * More info: https://github.com/joseortiz-bot?tab=repositories
 ***/

@Composable
fun BirdAdditionalInfo(birdData: AvesData) {
    DetailItem(label = HABITAT, value = birdData.habitat)
    DetailItem(label = AMENAZAS, value = birdData.iucn?.description)
    DetailItem(label = DIDYOUKNOW, value = birdData.didyouknow)
}