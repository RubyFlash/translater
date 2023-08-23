package com.example.translator.presentation.navigation

import com.example.translator.R

sealed class BottomNavItem(val label: String,val contentDescription: String, val icon: Int, val route: String) {
    object Home: BottomNavItem("Home","Navigate to Home", R.drawable.ic_baseline_home_24, NavRoute.BottomNavigationBar.HomeScreen.route )
    object Favorites: BottomNavItem("Favorites", "Navigate to Favorites", R.drawable.ic_baseline_star_24, NavRoute.BottomNavigationBar.FavoritesScreen.route )
    object Quiz: BottomNavItem("Quiz","Navigate to Quiz", R.drawable.ic_baseline_school_24, NavRoute.BottomNavigationBar.QuizScreen.route )
}