package org.aves.project.components.bird_details_components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.aves.project.model.AvesData

/***
 * Project: KotlinAves
 * From: org.aves.project
 * Created by Jose Ortiz on 2024
 * More info: https://github.com/joseortiz-bot?tab=repositories
 ***/

@Composable
fun BirdInfoExpandable(bird: AvesData?) {
    var isExpanded by remember { mutableStateOf(false) }

    Surface(
        color = Color(0xFF8BC34A),
        shape = MaterialTheme.shapes.medium,
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { isExpanded = !isExpanded }
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = "Nombres",
                    style = MaterialTheme.typography.h6.copy(color = Color.Black)
                )


                Spacer(modifier = Modifier.weight(1f))


                Icon(
                    imageVector = if (isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Expandir/Contraer",
                    modifier = Modifier.padding(start = 8.dp)
                )
            }


            if (isExpanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Nombre en Español: ${bird?.name?.spanish ?: "N/A"}",
                    style = MaterialTheme.typography.body1.copy(color = Color.Black)
                )
                Text(
                    text = "Nombre en Inglés: ${bird?.name?.english ?: "N/A"}",
                    style = MaterialTheme.typography.body1.copy(color = Color.Black)
                )
                Text(
                    text = "Nombre en Latín: ${bird?.name?.latin ?: "N/A"}",
                    style = MaterialTheme.typography.body1.copy(color = Color.Black)
                )
            }
        }
    }
}
