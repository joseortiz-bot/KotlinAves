package org.aves.project.data.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

/***
 * Project: KotlinAves
 * From: org.aves.project
 * Created by Jose Ortiz on 2024
 * More info: https://github.com/joseortiz-bot?tab=repositories
 ***/

object NetworkUtils {
    val httpClient = HttpClient {
        install(ContentNegotiation){
            json(json = Json { ignoreUnknownKeys = true }, contentType = ContentType.Any)
        }
    }
}

val provideApiServiceModule = module{
    single { NetworkUtils.httpClient }
}