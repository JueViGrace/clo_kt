plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.sqldelight)
    application
}

group = "org.clo"
version = libs.versions.app.version

application {
    mainClass.set("org.clo.ApplicationKt")
}

ktor {
    fatJar {
        archiveFileName.set("bakery.jar")
    }
}

dependencies {

    // Server
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.host.common)
    implementation(libs.ktor.server.status.pages)
    implementation(libs.ktor.server.webjars)
    implementation(libs.ktor.server.cors)
    implementation(libs.ktor.server.loggin)
    implementation(libs.ktor.server.call.id)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.serialization.json)
    implementation(libs.ktor.server.caching.headers)
    implementation(libs.ktor.server.request.validation)
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.server.caching.headers.jvm)
    implementation(libs.ktor.server.auth)
    implementation(libs.ktor.server.auth.jwt)
    implementation(libs.ktor.server.auth.sessions)

    // Client
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.cio)
    implementation(libs.ktor.client.logging)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.client.auth)

    // Templating
    implementation(libs.htmx)
    implementation(libs.ktor.server.thymeleaf)
    implementation(libs.ktor.server.html.builder)

    // Kotlin Serialization
    implementation(libs.kotlinx.serialization.json)

    // Kotlin Coroutines
    implementation(libs.kotlinx.coroutines.core)

    // Koin
    implementation(libs.koin.ktor)
    implementation(libs.koin.logger)

    // Sqldelight
    implementation(libs.sqldelight.driver)
    implementation(libs.sqldelight.coroutines.extensions)
    implementation(libs.sqldelight.async.extensions)

    // Postgres
    implementation(libs.mysql)

    // Datasource
    implementation(libs.hikari)

    // Bcrypt
    implementation(libs.kbcrypt)

    // Logger
    implementation(libs.logback)

    // Test
    testImplementation(libs.ktor.server.tests)
    testImplementation(libs.junit)
    testImplementation(libs.kotlin.test.junit)
}

sqldelight {
    databases {
        create("CloServer") {
            packageName.set("org.clo")
//            srcDirs("sqldelight")
//            deriveSchemaFromMigrations.set(true)
            dialect(libs.sqldelight.dialect)
        }
    }
}
