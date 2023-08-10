package com.example.translator.presentation.navigation

sealed class NavRoute(val route: String) {
    object OnBoarding: NavRoute("onboarding_route") {
        object OnBoardingScreen: NavRoute("onboarding_screen")
    }
    object Home: NavRoute("home_route") {
        object HomeScreen: NavRoute("home_screen")
    }
}
