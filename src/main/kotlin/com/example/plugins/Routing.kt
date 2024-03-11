package com.example.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import com.example.*
import io.ktor.http.*

fun Application.configureRouting() {
    routing {
        val gen = NoteGenerator()
        get("/scales/{key}/{type}/notes") {
            val key = call.parameters["key"]
            val scale = call.parameters["type"]
            if (scale != null && key != null && validateKey(key) && validateScale(scale))
                call.respond(HttpStatusCode.OK, gen.getNotes(gen.replaceKeyName(key), scale))
            else
                call.respond(HttpStatusCode.NotFound, "No such key and scale combination found.")
        }
    }
}

//TODO: /scales/find "POST" [list of notes], return all scales and modes with these in them. If none applied, chromatic.