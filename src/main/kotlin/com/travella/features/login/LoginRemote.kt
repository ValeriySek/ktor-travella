package com.travella.features

import kotlinx.serialization.Serializable

@Serializable
data class LoginReceiveRemote(
    val name: String,
    val password: String
)

@Serializable
data class LoginResponseRemote(
    val token: String,
)