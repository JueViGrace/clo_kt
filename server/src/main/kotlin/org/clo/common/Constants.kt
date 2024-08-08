package org.clo.common

import io.ktor.http.HttpStatusCode
import io.ktor.server.util.toLocalDateTime
import io.ktor.util.InternalAPI
import java.util.Date

object Constants {
    const val UNEXPECTED_ERROR = "An unexpected error occurred"

    const val SALT_ROUNDS: Int = 10

    @OptIn(InternalAPI::class)
    val time = Date().toLocalDateTime().toString()

    val status = HttpStatusCode(HttpStatusCode.OK.value, HttpStatusCode.OK.description)
}
