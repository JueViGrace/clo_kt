package org.clo.api.router

import io.ktor.server.routing.Route
import io.ktor.server.routing.route
import org.clo.api.product.router.productRoutes
import org.clo.api.user.router.userRoutes

fun Route.apiRoutes() {
    route("/api") {
        userRoutes()
        productRoutes()
    }
}
