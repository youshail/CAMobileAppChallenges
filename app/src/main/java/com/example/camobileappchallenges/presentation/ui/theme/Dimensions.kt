package com.example.camobileappchallenges.presentation.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimensions(
    val default: Dp = 0.dp,
    val spaceExtraSmall: Dp = 5.dp,
    val spaceSmall: Dp = 10.dp,
    val spaceMedium: Dp = 14.dp,
    val spaceLarge: Dp = 28.dp,
    val spaceExtraLarge: Dp = 50.dp
)

val LocalSpacing = compositionLocalOf { Dimensions() }
