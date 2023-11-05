package com.ougi.authentication

import com.ougi.authentication.plugins.configureContent
import com.ougi.authentication.plugins.configureRouting
import com.ougi.authentication.plugins.configureSecurity
import io.ktor.server.application.*
import io.ktor.server.netty.*


fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {
    configureContent()
    configureSecurity()
    configureRouting()
}