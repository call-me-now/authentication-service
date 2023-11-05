package com.ougi.authentication.login

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.ougi.authentication.jwt.JwtConfig.audience
import com.ougi.authentication.jwt.JwtConfig.issuer
import com.ougi.authentication.jwt.JwtConfig.secret
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*
import java.util.*

suspend fun PipelineContext<Unit, ApplicationCall>.login() {
    val user = call.receive<User>()
    if (user != User("user", "1111")) {
        call.respond(HttpStatusCode.NotFound, "User not found")
        return
    }

    val token =
        JWT.create()
            .withAudience(application.audience)
            .withIssuer(application.issuer)
            .withClaim(USERNAME, user.username)
            .withExpiresAt(Date(System.currentTimeMillis() + 60000))
            .sign(Algorithm.HMAC256(application.secret))

    call.respond(hashMapOf("token" to token))
}

private const val USERNAME = "username"