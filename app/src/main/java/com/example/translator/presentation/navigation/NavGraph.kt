package com.example.translator.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.translator.presentation.screen.FavoritesScreen
import com.example.translator.presentation.screen.HomeScreen
import com.example.translator.presentation.screen.OnboardingScreen
import com.example.translator.presentation.screen.QuizScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        navigation(
            startDestination = NavRoute.OnBoarding.OnBoardingScreen.route,
            route = NavRoute.OnBoarding.route
        ) {
            composable(route = NavRoute.OnBoarding.OnBoardingScreen.route) {
                OnboardingScreen(navController = navController)
            }
        }

        navigation(
            startDestination = NavRoute.BottomNavigationBar.HomeScreen.route,
            route = NavRoute.BottomNavigationBar.route
        ) {
            composable(route = NavRoute.BottomNavigationBar.HomeScreen.route) {
                HomeScreen(navController = navController)
            }
            composable(route = NavRoute.BottomNavigationBar.FavoritesScreen.route) {
                FavoritesScreen(navController = navController)
            }
            composable(route = NavRoute.BottomNavigationBar.QuizScreen.route) {
                QuizScreen(navController = navController)
            }
        }
    }
}