package com.ougi.authentication.jwt

import io.ktor.server.application.*

object JwtConfig {
    val Application.secret get() = environment.config.property("jwt.secret").getString()
    val Application.issuer get() = environment.config.property("jwt.issuer").getString()
    val Application.audience get() = environment.config.property("jwt.audience").getString()
    val Application.name get() = environment.config.property("jwt.name").getString()
}