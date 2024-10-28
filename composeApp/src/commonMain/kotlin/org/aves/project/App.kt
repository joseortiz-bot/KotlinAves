package org.aves.project

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.aves.project.ui.screens.bird.BirdDetailsScreen
import org.aves.project.ui.screens.bird.BirdListScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

/***
 * Project: KotlinAves
 * From: org.aves.project
 * Created by Jose Ortiz on 2024
 * More info: https://github.com/joseortiz-bot?tab=repositories
 ***/

@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "list") {
        composable("list") {
            BirdListScreen(navController)
        }
        composable("details/{birdUid}") { backStackEntry ->
            val birdUid = backStackEntry.arguments?.getString("birdUid")
            BirdDetailsScreen(navController, birdUid)
        }

    }
}











