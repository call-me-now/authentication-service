package com.ougi.authentication.plugins

import com.ougi.authentication.login.login
import com.ougi.authentication.jwt.JwtConfig.name
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() =
    routing {
        authenticate(this@configureRouting.name) {
            route("{...}") {
                handle {
                    call.respondRedirect { port = 8081 }
                }
            }
        }

        post("/login") { login() }
    }
