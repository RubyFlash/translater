package com.example.translator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.translator.presentation.navigation.SetupNavGraph
import com.example.translator.presentation.viewmodel.SplashScreenViewModel
import com.example.translator.ui.theme.TranslatorTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var splashScreenViewModel: SplashScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().setKeepOnScreenCondition {
            !splashScreenViewModel.isLoading.value
        }

        setContent {
            TranslatorTheme {
                val screen by splashScreenViewModel.startDestination
                val navController = rememberNavController()
                Surface {
                    SetupNavGraph(navController = navController, startDestination = screen)
                }
            }
        }
    }
}