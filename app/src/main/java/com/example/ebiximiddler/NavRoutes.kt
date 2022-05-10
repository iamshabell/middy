package com.example.ebiximiddler

sealed class NavRoutes(val route: String) {
    object Login: NavRoutes("login_screen")
    object Registration: NavRoutes("registration_screen")
}
