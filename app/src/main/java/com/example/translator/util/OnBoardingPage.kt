package com.example.translator.util

import androidx.annotation.DrawableRes
import com.example.translator.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: UIText,
    val description: UIText
) {
    object First: OnBoardingPage(
        image = R.drawable.ic_first_onboarding_screen,
        title = UIText.StringResource(R.string.first_title),
        description = UIText.StringResource(R.string.first_description)
    )

    object Second: OnBoardingPage(
        image = R.drawable.ic_second_onboarding_screen,
        title = UIText.StringResource(R.string.second_title),
        description = UIText.StringResource(R.string.second_description)
    )

    object Third: OnBoardingPage(
        image = R.drawable.ic_third_onboarding_screen,
        title = UIText.StringResource(R.string.third_title),
        description = UIText.StringResource(R.string.third_description)
    )
}