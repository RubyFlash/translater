package com.example.translator.presentation.navigation

sealed class Screen(val route: String){
    object Welcome: Screen(route = "welcome_screen")
    object Home: Screen(route = "home_screen")
    object Favorite: Screen(route = "favorite_screen")
    sealed class Quiz: Screen(route = "quiz_screen") {
        object QuizStart: Screen(route = "quiz_start")
        object QuizHistory: Screen(route = "quiz_history")
        object QuizSettings: Screen(route = "start_settings")
    }
}