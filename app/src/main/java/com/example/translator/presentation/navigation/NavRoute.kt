package com.example.translator.presentation.navigation

sealed class NavRoute(val route: String) {
    object OnBoarding: NavRoute("onboarding_route") {
        object OnBoardingScreen: NavRoute("onboarding_screen")
    }
    object BottomNavigationBar: NavRoute("bottom_nav_route") {
        object HomeScreen: NavRoute("home_screen")
        object FavoritesScreen: NavRoute("favorites_screen")
        object QuizScreen: NavRoute("quiz_screen")
    }
}
