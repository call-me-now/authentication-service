package com.ougi.authentication

import com.ougi.authentication.plugins.configureRouting
import com.ougi.authentication.plugins.configureSecurity
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*


fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {
    install(ContentNegotiation) {
        json()
    }
    configureSecurity()
    configureRouting()
}