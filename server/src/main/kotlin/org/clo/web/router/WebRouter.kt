package org.clo.web.router

import io.ktor.server.application.call
import io.ktor.server.html.respondHtml
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.route
import io.ktor.server.thymeleaf.respondTemplate
import kotlinx.html.body
import org.clo.web.view.components.headerAuthMenu
import org.clo.web.view.components.headerNavMenu
import org.clo.web.view.components.headerProfileMenu
import org.clo.web.view.components.socialMenu

fun Route.webRoutes() {
    get("/") {
        call.respondTemplate("index.html", emptyMap())
    }

    route("/components") {
        components()
    }
}

fun Route.components() {
    get("/main") {
        call.respondTemplate("main.html")
    }

    header()

    footer()

    get("/home") {
        call.respondTemplate("home.html")
    }

    get("/contact") {
    }

    get("/shop") {
    }
}

fun Route.header() {
    route("/header") {
        get {
            call.respondTemplate("header.html")
        }

        get("/nav") {
            call.respondHtml {
                body {
                    headerNavMenu()
                }
            }
        }

        get("/auth") {
            call.respondHtml {
                body {
                    if (false) {
                        headerProfileMenu()
                    } else {
                        headerAuthMenu()
                    }
                }
            }
        }
    }
}

fun Route.footer() {
    route("/footer") {
        get {
            call.respondTemplate("footer.html")
        }

        get("/social") {
            call.respondHtml {
                body {
                    socialMenu()
                }
            }
        }
    }
}
