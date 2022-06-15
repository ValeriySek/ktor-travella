package com.travella.features.registration

import kotlinx.serialization.Serializable

@Serializable
data class RegisterReceiveRemote(
    val name: String,
    val email: String,
    val password: String
)

@Serializable
data class RegisterResponseRemote(
    val token: String,
)