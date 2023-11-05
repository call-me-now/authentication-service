package com.ougi.authentication.plugins

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.ougi.authentication.jwt.JwtConfig.audience
import com.ougi.authentication.jwt.JwtConfig.issuer
import com.ougi.authentication.jwt.JwtConfig.name
import com.ougi.authentication.jwt.JwtConfig.secret
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.response.*


fun Application.configureSecurity() =
    authentication {
        jwt(this@configureSecurity.name) {

            verifier(
                JWT
                    .require(Algorithm.HMAC256(this@configureSecurity.secret))
                    .withAudience(this@configureSecurity.audience)
                    .withIssuer(this@configureSecurity.issuer)
                    .build()
            )

            validate { credential ->
                if (credential.payload.audience.contains(this@configureSecurity.audience)) JWTPrincipal(credential.payload)
                else null
            }

            challenge { _, _ ->
                call.respond(HttpStatusCode.Unauthorized, "Token is not valid or has expired")
            }
        }
    }

