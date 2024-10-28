package org.aves.project.components.bird_details_components
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import org.aves.project.common.NO_IMAGES
import org.aves.project.components.banner_widgets.BannerCarouselWidget
import org.aves.project.model.Gallery

/***
 * Project: KotlinAves
 * From: org.aves.project
 * Created by Jose Ortiz on 2024
 * More info: https://github.com/joseortiz-bot?tab=repositories
 ***/

@Composable
fun BirdGallery(gallery: ArrayList<Gallery>?) {
    if (!gallery.isNullOrEmpty()) {
        BannerCarouselWidget(banners = gallery)
    } else {
        Text(text = NO_IMAGES)
    }
}