package org.clo.web.view.components

import kotlinx.html.FlowContent
import kotlinx.html.a
import kotlinx.html.button
import kotlinx.html.classes
import kotlinx.html.div
import kotlinx.html.img
import kotlinx.html.nav
import kotlinx.html.p
import org.clo.web.view.components.NavigationMenu.Contact
import org.clo.web.view.components.NavigationMenu.Home
import org.clo.web.view.components.NavigationMenu.Shop

fun FlowContent.headerNavMenu() = nav {
    classes = setOf("flex", "flex-row", "justify-between", "gap-4", "p-2")
    listOf(
        Home,
        Shop,
        Contact
    ).forEach { item ->
        div {
            classes = setOf("px-2", "hover:text-blue-400")
            button {
                a {
                    href = "/${item.name}"

                    +item.displayName
                }
            }
        }
    }
}

fun FlowContent.headerAuthMenu() = div {
    classes = setOf("flex", "flex-row", "justify-center", "items-center", "gap-4")

    a {
        href = "/login"
        button {
            classes = setOf(
                "border",
                "rounded",
                "p-2",
                "hover:bg-blue-300/50"
            )

            p {
                +"Log in"
            }
        }
    }
    a {
        href = "/signup"
        button {
            classes = setOf(
                "text-gray-100",
                "border",
                "rounded",
                "bg-blue-400",
                "p-2",
                "hover:bg-blue-500",
            )

            p {
                +"Sign up"
            }
        }
    }
}

fun FlowContent.headerProfileMenu() = div {
    button {
        classes = setOf("border", "rounded-full", "hover:border-blue-300")
        img {
            attributes["preload"] = "true"
            classes = setOf("size-8", "border", "rounded-full")
            src = "/favicon-32x32.png"
            alt = "Logo"
        }
    }
}

sealed class NavigationMenu(
    val name: String,
    val displayName: String,
) {
    data object Home : NavigationMenu(
        name = "",
        displayName = "Home"
    )
    data object Shop : NavigationMenu(
        name = "shop",
        displayName = "Shop"
    )
    data object Contact : NavigationMenu(
        name = "contact",
        displayName = "Contact"
    )
}
