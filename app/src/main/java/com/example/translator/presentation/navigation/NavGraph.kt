package com.example.translator.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.translator.presentation.screen.HomeScreen
import com.example.translator.presentation.screen.OnboardingScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String
){
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
            startDestination = NavRoute.Home.HomeScreen.route,
            route = NavRoute.Home.route
        ) {
            composable(route = NavRoute.Home.HomeScreen.route) {
                HomeScreen()
            }
        }
    }
}