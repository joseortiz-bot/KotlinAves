package org.aves.project.components.bird_details_components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.aves.project.common.DIMORFISMO
import org.aves.project.common.ESPECIE
import org.aves.project.common.IUCN
import org.aves.project.common.LONGITUD
import org.aves.project.common.MIGRATORIA
import org.aves.project.common.ORDEN
import org.aves.project.model.AvesData

/***
 * Project: KotlinAves
 * From: org.aves.project
 * Created by Jose Ortiz on 2024
 * More info: https://github.com/joseortiz-bot?tab=repositories
 ***/

@Composable
fun BirdDetailsSection(birdData: AvesData) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        elevation = 4.dp,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            listOf(
                DIMORFISMO to birdData.dimorphism,
                MIGRATORIA to birdData.migration,
                LONGITUD to birdData.size,
                ORDEN to birdData.order,
                ESPECIE to birdData.species,
                IUCN to birdData.iucn?.title
            ).forEach { (label, value) ->
                Text(
                    text = buildAnnotatedString {
                        withStyle(SpanStyle(fontWeight = FontWeight.Bold)) { append(label) }
                        append(" ${value ?: "N/A"}")
                    },
                    fontSize = 18.sp,
                )
            }
        }
    }
}