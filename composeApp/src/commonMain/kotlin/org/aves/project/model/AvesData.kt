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
data class AvesData(
  @SerialName("uid") var uid        : String?  = null,
  @SerialName("name") var name       : Name?    = Name(),
  @SerialName("map") var map        : Map?     = Map(),
  @SerialName("iucn") var iucn       : Iucn?    = Iucn(),
  @SerialName("habitat") var habitat    : String?  = null,
  @SerialName("didyouknow") var didyouknow : String?  = null,
  @SerialName("migration") var migration  : Boolean? = null,
  @SerialName("dimorphism") var dimorphism : Boolean? = null,
  @SerialName("size") var size       : String?  = null,
  @SerialName("order") var order      : String?  = null,
  @SerialName("species") var species    : String?  = null,
  @SerialName("images") var images     : Images?  = Images(),
  @SerialName("audio") var audio      : Audio?   = Audio(),
  @SerialName("_links") var Links      : Links?   = Links(),
  @SerialName("sort") var sort       : Int?     = null
)


















