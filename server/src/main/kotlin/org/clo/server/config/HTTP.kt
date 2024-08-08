package org.clo.server.config

import io.ktor.http.HttpHeaders
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.cors.routing.CORS
import io.ktor.server.webjars.Webjars

fun Application.configureHTTP() {
    install(CORS) {
        allowHeader(HttpHeaders.Authorization)
    }

    install(Webjars)

   /* routing {
        install(CachingHeaders) {
            options { _, content ->
                when (content.contentType?.withoutParameters()) {
                    ContentType.Text.Plain -> CachingOptions(MaxAge(maxAgeSeconds = 24 * 60 * 60))
                    ContentType.Text.Html -> CachingOptions(MaxAge(maxAgeSeconds = 24 * 60 * 60))
                    ContentType.Text.CSS -> CachingOptions(MaxAge(maxAgeSeconds = 24 * 60 * 60))

                    else -> null
                }
            }
        }
    }*/
}
