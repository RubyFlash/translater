package com.example.translater

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.translater.ui.theme.TranslaterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TranslaterTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "translater_main_screen"
                ) {
                    composable("translater_main_screen") {

                    }
                    composable("translater_favorites_screen") {

                    }
                    composable("translater_quiz_screen") {

                    }
                }
            }
        }
    }
}