package com.uladzislau_pravalenak.authorization.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.uldazislau_pravalenak.authorizationapp.ui.theme.Shapes
import com.uldazislau_pravalenak.authorizationapp.ui.theme.Typography

private val LightColorPalette = lightColors(
    primary = AppColor.Light.SeaSerpent,
    primaryVariant = AppColor.Light.SeaSerpent,
    onPrimary = Color.White,
    background = Color.White,
    secondary = AppColor.Light.CarminePink,
    secondaryVariant = AppColor.Light.Gainsboro,
    onSurface = AppColor.Light.Daintree,
    error = AppColor.Light.Error
)

private val DarkColorPalette = darkColors(
    primary = AppColor.Light.SeaSerpent,
    primaryVariant = AppColor.Light.SeaSerpent,
    onPrimary = Color.Black,
    secondary = AppColor.Light.CarminePink,
    secondaryVariant = AppColor.Light.Gainsboro,
    onSurface = Color.White,
    error = CustomColor.Error
)

@Composable
fun AuthorizationAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val uiController = rememberSystemUiController()
    SideEffect {
        uiController.setSystemBarsColor(Color.Transparent, !darkTheme)
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}