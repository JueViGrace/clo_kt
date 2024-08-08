package org.clo.server.router

import io.ktor.server.application.Application
import io.ktor.server.routing.routing
import org.clo.api.router.apiRoutes
import org.clo.web.router.webRoutes

fun Application.appRoutes() {
    routing {
        apiRoutes()
        webRoutes()
    }
}
