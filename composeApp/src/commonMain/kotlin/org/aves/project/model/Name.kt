package org.aves.project.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/***
 * Project: KotlinAves
 * From: org.aves.project
 * Created by Jose Ortiz on 2024
 * More info: https://github.com/joseortiz-bot?tab=repositories
 ***/

@Serializable
data class Name(
  @SerialName("spanish") var spanish : String? = null,
  @SerialName("english") var english : String? = null,
  @SerialName("latin") var latin   : String? = null
)