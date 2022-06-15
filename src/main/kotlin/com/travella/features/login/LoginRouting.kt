package com.travella.features.login

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


fun Application.configureLoginRouting() {

    routing {
        post("/login") {
            val login = call.receive(LoginReceiveRemote::class)
            if (InMemoryCache.userList.map { it.name }.contains(login.name)) {
                val token = UUID.randomUUID().toString()
                InMemoryCache.token.add(TokenCache(login.name, token))
                call.respond(LoginResponseRemote(token))
                return@post
            } else {

            }
            call.respond(HttpStatusCode.BadRequest)
//            call.respond(
//                Test(
//                    LatLng(40.0, 30.0),
//                    "Country"
//                )
//            )
        }
    }
}