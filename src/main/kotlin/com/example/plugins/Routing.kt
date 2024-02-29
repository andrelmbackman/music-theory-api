package com.example.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import com.example.*

fun Application.configureRouting() {
    routing {
        val gen = NoteGenerator()
        val text = gen.getNotes("A", "minor")
        get("/") {
            //call.respondText("Hello, World!")
            call.respondText(text.toString())
        }
    }
}
