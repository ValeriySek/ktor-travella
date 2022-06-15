package com.travella.features.registration

import com.travella.features.LoginReceiveRemote
import com.travella.features.LoginResponseRemote
import com.travella.features.cach.InMemoryCache
import com.travella.features.cach.TokenCache
import com.travella.plugins.LatLng
import com.travella.plugins.Test
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.UUID


fun Application.configureRegisterRouting() {

    routing {
        post("/register") {
            val login = call.receive(RegisterReceiveRemote::class)
            if (InMemoryCache.userList.map { it.name }.contains(login.name)) {
                call.respond(HttpStatusCode.Conflict, "User Exist")
            }
            val token = UUID.randomUUID().toString()
            InMemoryCache.userList.add(login)
            InMemoryCache.token.add(TokenCache(login.name, token))

            call.respond(RegisterResponseRemote(token))
        }
    }
}