package com.travella.features.cach

import com.travella.features.registration.RegisterReceiveRemote


data class TokenCache(
    val name: String,
    val token: String
)

object InMemoryCache {

    val userList: MutableList<RegisterReceiveRemote> = mutableListOf()
    val token: MutableList<TokenCache> = mutableListOf()
}