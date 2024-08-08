package org.clo.server

import io.ktor.server.application.Application
import io.ktor.server.netty.EngineMain
import org.clo.database.driver.DriverFactory.configureDatabase
import org.clo.server.config.configureHTTP
import org.clo.server.config.configureKoin
import org.clo.server.config.configureMonitoring
import org.clo.server.config.configureRouting
import org.clo.server.config.configureSecurity
import org.clo.server.config.configureSerialization
import org.clo.server.config.configureValidation
import org.clo.server.router.appRoutes
import org.clo.web.client.KtorClient.configureClient
import org.clo.web.config.configureTemplating

fun main(args: Array<String>) {
    EngineMain.main(args)
}

fun Application.module() {
    // Basic configuration
    configureKoin()
    configureSecurity()
    configureDatabase()
    configureClient()
    configureRouting()
    configureValidation()
    configureHTTP()
    configureMonitoring()
    configureSerialization()
    configureTemplating()

    // Application routes
    appRoutes()
}
