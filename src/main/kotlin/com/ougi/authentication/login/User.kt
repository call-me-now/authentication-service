package com.ougi.authentication.login

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("username") val username: String,
    @SerialName("otpMd5") val otp: String,
)