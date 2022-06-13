package com.travella.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import kotlinx.serialization.Serializable

@Serializable
data class LatLng(
    val lat: Double,
    val lang: Double
)
@Serializable
data class Test(
    val latLng: LatLng,
    val name: String
)

fun Application.configureRouting() {

    routing {
        get("/places") {
            call.respond(
                Test(
                    LatLng(40.0, 30.0),
                    "Country"
                )
            )
        }
    }
}
