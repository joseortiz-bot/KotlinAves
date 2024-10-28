package org.aves.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform