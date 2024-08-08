package org.clo.server.config

import io.ktor.server.application.Application
import io.ktor.server.application.install
import org.clo.server.di.coroutinesModule
import org.koin.core.logger.Level
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

// TODO CONFIGURE MODULES

fun Application.configureKoin() {
    install(Koin) {
        slf4jLogger(Level.DEBUG)
        modules(coroutinesModule)
    }
}
