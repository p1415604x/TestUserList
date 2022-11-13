package lt.testas.userlist.theme.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

object TestUserTheme {

    val dimen: Dimensions
        @Composable
        @ReadOnlyComposable
        get() = LocalDimensions.current

}

private val DarkColorPalette = darkColors(
    primary = Color.White,
    primaryVariant = Color.White.copy(alpha = 0.75f),
    secondary = Teal200,
    background = Color.DarkGray,
    surface = Color.DarkGray,
    onPrimary = Color.DarkGray,
    onSecondary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White,
)

private val LightColorPalette = lightColors(
    primary = Color.Black,
    primaryVariant = Color.Black.copy(alpha = 0.75f),
    secondary = Teal200,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
)

@Immutable
data class Dimensions(
    val screenHorizontalPadding: Dp = 24.dp,
    val screenVerticalPadding: Dp = 40.dp,
    val elementGap: Dp = 20.dp
)

internal val LocalDimensions = staticCompositionLocalOf { Dimensions() }

@Composable
fun TestUserListTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dimensions: Dimensions = Dimensions(),
    content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    CompositionLocalProvider(
        LocalDimensions provides dimensions,
    ) {
        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}