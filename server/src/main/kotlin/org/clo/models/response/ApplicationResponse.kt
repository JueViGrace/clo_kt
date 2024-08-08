package org.clo.models.response

import io.ktor.http.HttpStatusCode
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.clo.common.Constants.UNEXPECTED_ERROR
import org.clo.common.Constants.time
import org.clo.models.response.AppResponse.FailureResponse
import org.clo.models.response.AppResponse.SuccessResponse

@Serializable
sealed class AppResponse<out T> {
    @Serializable
    data class SuccessResponse<out T>(
        @SerialName("status")
        val status: Int,
        @SerialName("description")
        val description: String,
        @Serializable
        @SerialName("body")
        val body: T,
        @SerialName("message")
        val message: String? = null,
    ) : AppResponse<T>()

    @Serializable
    data class FailureResponse(
        @SerialName("status")
        val status: Int,
        @SerialName("description")
        val description: String,
        @SerialName("time")
        val time: String = "",
        @SerialName("message")
        val message: String? = null,
        @SerialName("error")
        val error: String? = null,
        @SerialName("path")
        val path: String? = null,
    ) : AppResponse<Nothing>()

    fun getResponseStatus(): Int = when (this) {
        is FailureResponse -> this.status
        is SuccessResponse -> this.status
    }

    fun getResponseDescription(): String = when (this) {
        is FailureResponse -> this.description
        is SuccessResponse -> this.description
    }
}

object DefaultHttpResponse {
    // 200
    inline fun<reified T> ok(
        body: T,
        message: String? = null,
    ): SuccessResponse<T> {
        return SuccessResponse(
            status = HttpStatusCode.OK.value,
            description = HttpStatusCode.OK.description,
            body = body,
            message = message
        )
    }

    // 201
    inline fun<reified T> created(
        body: T,
        message: String? = null,
    ): SuccessResponse<T> {
        return SuccessResponse(
            status = HttpStatusCode.Created.value,
            description = HttpStatusCode.Created.description,
            body = body,
            message = message
        )
    }

    // 202
    inline fun<reified T> accepted(
        body: T,
        message: String? = null,
    ): SuccessResponse<T> {
        return SuccessResponse(
            status = HttpStatusCode.Accepted.value,
            description = HttpStatusCode.Accepted.description,
            body = body,
            message = message
        )
    }

    // 204
    inline fun<reified T> noContent(
        body: T,
        message: String? = null,
    ): SuccessResponse<T> {
        return SuccessResponse(
            status = HttpStatusCode.Created.value,
            description = HttpStatusCode.Created.description,
            body = body,
            message = message
        )
    }

    // 400
    fun badRequest(
        error: String = "Invalid Request",
        message: String? = null,
        path: String? = null
    ): FailureResponse {
        return FailureResponse(
            status = HttpStatusCode.BadRequest.value,
            description = HttpStatusCode.BadRequest.description,
            time = time,
            message = message,
            error = error,
            path = path
        )
    }

    // 401
    fun unauthorized(
        error: String = "You are not authorized",
        message: String? = null,
        path: String? = null
    ): FailureResponse {
        return FailureResponse(
            status = HttpStatusCode.Unauthorized.value,
            description = HttpStatusCode.Unauthorized.description,
            time = time,
            message = message,
            error = error,
            path = path
        )
    }

    // 403
    fun forbidden(
        error: String = "Forbidden resource",
        message: String? = null,
        path: String? = null
    ): FailureResponse {
        return FailureResponse(
            status = HttpStatusCode.Forbidden.value,
            description = HttpStatusCode.Forbidden.description,
            time = time,
            message = message,
            error = error,
            path = path
        )
    }

    // 404
    fun notFound(
        error: String,
        message: String? = null,
        path: String? = null
    ): FailureResponse {
        return FailureResponse(
            status = HttpStatusCode.NotFound.value,
            description = HttpStatusCode.NotFound.description,
            time = time,
            message = message,
            error = error,
            path = path
        )
    }

    fun methodNotAllowed(
        error: String,
        message: String? = null,
        path: String? = null
    ): FailureResponse {
        return FailureResponse(
            status = HttpStatusCode.MethodNotAllowed.value,
            description = HttpStatusCode.MethodNotAllowed.description,
            time = time,
            message = message,
            error = error,
            path = path
        )
    }

    // 409
    fun conflict(
        error: String,
        message: String? = null,
        path: String? = null
    ): FailureResponse {
        return FailureResponse(
            status = HttpStatusCode.Conflict.value,
            description = HttpStatusCode.Conflict.description,
            time = time,
            message = message,
            error = error,
            path = path
        )
    }

    // 500
    fun internalServerError(
        error: String = UNEXPECTED_ERROR,
        message: String? = null,
        path: String? = null
    ): FailureResponse {
        return FailureResponse(
            status = HttpStatusCode.InternalServerError.value,
            description = HttpStatusCode.InternalServerError.description,
            time = time,
            message = message,
            error = error,
            path = path
        )
    }
}
