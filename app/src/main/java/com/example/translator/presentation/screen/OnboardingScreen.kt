package com.example.translator.presentation.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.translator.R
import com.example.translator.presentation.navigation.NavRoute
import com.example.translator.presentation.viewmodel.OnboardingScreenViewModel
import com.example.translator.ui.theme.Roboto
import com.example.translator.ui.theme.TranslatorTheme
import com.example.translator.util.OnBoardingPage
import com.example.translator.util.UIText

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    navController: NavHostController,
    onboardingScreenViewModel: OnboardingScreenViewModel = hiltViewModel()
) {
    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third
    )
    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            pageCount = 3,
            state = pagerState
        ) { position ->
            PagerScreen(onBoardingPage = pages[position])
        }
        Row(
            Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .weight(1f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(pages.size) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(15.dp)
                )
            }
        }
        FinishButton(modifier = Modifier.weight(1f), pagerState = pagerState) {
            onboardingScreenViewModel.saveOnBoardingState(completed = true)
            navController.popBackStack()
            navController.navigate(NavRoute.BottomNavigationBar.route) {
                popUpTo(NavRoute.OnBoarding.route) {
                    inclusive = true
                }
            }
        }
    }
}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = "App logo",
            modifier = Modifier
                .fillMaxWidth()
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = onBoardingPage.title.asString(),
            textAlign = TextAlign.Center,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            fontWeight = FontWeight.Medium,
            fontFamily = Roboto
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 30.dp),
            text = onBoardingPage.description.asString(),
            textAlign = TextAlign.Justify,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            fontWeight = FontWeight.Light,
            fontFamily = Roboto
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FinishButton(
    modifier: Modifier,
    pagerState: PagerState,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .padding(horizontal = 40.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = pagerState.currentPage == 2
        ) {
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White
                )
            ) {
                Text(text = UIText.StringResource(R.string.finish_btn).asString())
            }
        }
    }
}

@Preview(showSystemUi = true, device = Devices.DEFAULT)
@Composable
fun OnBoardingScreenPreviewMedium() {
    TranslatorTheme {
        val navController = rememberNavController()
        OnboardingScreen(navController = navController)
    }
}

@Preview(showSystemUi = true, device = Devices.NEXUS_5)
@Composable
fun OnBoardingScreenPreviewSmall() {
    TranslatorTheme {
        val navController = rememberNavController()
        OnboardingScreen(navController = navController)
    }
}
