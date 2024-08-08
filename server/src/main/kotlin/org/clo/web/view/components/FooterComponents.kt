package org.clo.web.view.components

import kotlinx.html.FlowContent
import kotlinx.html.a
import kotlinx.html.classes
import kotlinx.html.div
import kotlinx.html.i

fun FlowContent.socialMenu() = div {
    classes = setOf("flex", "flex-row", "justify-center", "gap-2", "p-2")

    listOf(
        SocialNetwork.Instagram,
        SocialNetwork.Youtube,
        SocialNetwork.Whatsapp
    ).forEach { item ->
        a {
            href = item.link
            attributes["role"] = "button"

            classes = setOf("flex")

            i {
                classes = setOf(
                    item.icon,
                    "hover:bg-gray-100",
                    "border",
                    "border-gray-100",
                    "rounded-md",
                    "text-gray-100",
                    "hover:text-black/80",
                    "hover:border-transparent",
                    "p-3"
                )
            }
        }
    }
}

sealed class SocialNetwork(
    val name: String,
    val icon: String,
    val link: String,
) {
    data object Instagram : SocialNetwork(
        name = "Instagram",
        icon = "bi bi-instagram",
        link = "https://www.instagram.com/clovenezuela/?hl=es-la"
    )

    data object Youtube : SocialNetwork(
        name = "Youtube",
        icon = "bi bi-youtube",
        link = "https://www.youtube.com/channel/UCzcmU8XXjmtuKzRM7pZ-ldA"
    )

    data object Whatsapp : SocialNetwork(
        name = "Whatsapp",
        icon = "bi bi-whatsapp",
        link = "https://wa.me/+584246342996"
    )
}
