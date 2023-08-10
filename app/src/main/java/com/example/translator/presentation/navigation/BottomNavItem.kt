package com.example.translator.presentation.navigation

import com.example.translator.R

sealed class BottomNavItem(val title: String, val icon: Int, val route: String) {
    object Home: BottomNavItem("Home", R.drawable.ic_baseline_home_24, "home_screen" )
    object Favorites: BottomNavItem("Favorites", R.drawable.ic_baseline_star_24, "favorites_screen" )
    object Quiz: BottomNavItem("Quiz", R.drawable.ic_baseline_school_24, "quiz_screen" )
}