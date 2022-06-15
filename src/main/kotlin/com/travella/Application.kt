package com.travella

import com.travella.features.login.configureLoginRouting
import com.travella.features.registration.configureRegisterRouting
import io.ktor.server.engine.*
import io.ktor.server.cio.*
import com.travella.plugins.*

fun main() {
    embeddedServer(CIO, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureSerialization()
        configureLoginRouting()
        configureRegisterRouting()
    }.start(wait = true)
}
