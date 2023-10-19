package com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView

private val DarkColorScheme = darkColorScheme(
        primary = Purple80,
        secondary = PurpleGrey80,
        tertiary = Pink80
)

private val LightColorScheme = TripWithUsColors(
    uiBackground = UiBackground,
    headerBackground = HeaderBackground,
    mainTitle = MainTitle,
    mainFontBlack = MainFontBlack,
    gradientTourItem1 = listOf(Ocean3, Shadow3),
    gradientTourItem2 = listOf(Lavender3, Rose2),
)

@Composable
fun TripWithUsTheme(
        darkTheme: Boolean = isSystemInDarkTheme(),
        // Dynamic color is available on Android 12+
        dynamicColor: Boolean = true,
        content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> LightColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current

    ProvideTripWithUsColors(LightColorScheme){
        MaterialTheme(
            typography = Typography,
            content = content
        )
    }
}

object TripWithUsTheme {
    val colors: TripWithUsColors
        @Composable
        get() = LocalTripWithUsColors.current
}

/**
 * TripWithUs custom Color Palette
 */
@Stable
class TripWithUsColors(
    uiBackground: Color,
    headerBackground: Color,
    mainTitle: Color,
    mainFontBlack: Color,
    gradientTourItem1: List<Color>,
    gradientTourItem2: List<Color>,
) {
    var uiBackground by mutableStateOf(uiBackground)
        private set
    var headerBackground by mutableStateOf(headerBackground)
        private set
    var mainTitle by mutableStateOf(mainTitle)
        private set
    var mainFontBlack by mutableStateOf(mainFontBlack)
        private set
    var gradientTourItem1 by mutableStateOf(gradientTourItem1)
        private set
    var gradientTourItem2 by mutableStateOf(gradientTourItem2)
        private set

    fun copy(): TripWithUsColors = TripWithUsColors(
        uiBackground = uiBackground,
        headerBackground = headerBackground,
        mainTitle = mainTitle,
        mainFontBlack = mainFontBlack,
        gradientTourItem1 = gradientTourItem1,
        gradientTourItem2 = gradientTourItem2,
    )
}
@Composable
fun ProvideTripWithUsColors(
    colors: TripWithUsColors,
    content: @Composable () -> Unit
) {
    val colorPalette = remember {
        // Explicitly creating a new object here so we don't mutate the initial [colors]
        // provided, and overwrite the values set in it.
        colors.copy()
    }
    CompositionLocalProvider(LocalTripWithUsColors provides colorPalette, content = content)
}

private val LocalTripWithUsColors = staticCompositionLocalOf<TripWithUsColors> {
    error("No JetsnackColorPalette provided")
}