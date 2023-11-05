package com.ougi.authentication.plugins

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*

fun Application.configureContent() = install(ContentNegotiation) { json() }