package me.xdan.motif.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = MotifTealDark,
    onPrimary = MotifOnTealDark,
    primaryContainer = MotifTealContainerDark,
    onPrimaryContainer = MotifOnTealContainerDark,
    secondary = MotifCoralDark,
    onSecondary = MotifOnCoralDark,
    secondaryContainer = MotifCoralContainerDark,
    onSecondaryContainer = MotifOnCoralContainerDark,
    tertiary = MotifMintDark,
    onTertiary = MotifOnMintDark,
    tertiaryContainer = MotifMintContainerDark,
    onTertiaryContainer = MotifOnMintContainerDark,
    background = MotifBackgroundDark,
    onBackground = MotifOnBackgroundDark,
    surface = MotifSurfaceDark,
    onSurface = MotifOnBackgroundDark,
    surfaceVariant = MotifSurfaceVariantDark,
    onSurfaceVariant = MotifOnSurfaceVariantDark,
    outline = MotifOutlineDark
)

private val LightColorScheme = lightColorScheme(
    primary = MotifTealLight,
    onPrimary = MotifOnTealLight,
    primaryContainer = MotifTealContainerLight,
    onPrimaryContainer = MotifOnTealContainerLight,
    secondary = MotifCoralLight,
    onSecondary = MotifOnCoralLight,
    secondaryContainer = MotifCoralContainerLight,
    onSecondaryContainer = MotifOnCoralContainerLight,
    tertiary = MotifMintLight,
    onTertiary = MotifOnMintLight,
    tertiaryContainer = MotifMintContainerLight,
    onTertiaryContainer = MotifOnMintContainerLight,
    background = MotifBackgroundLight,
    onBackground = MotifOnBackgroundLight,
    surface = MotifSurfaceLight,
    onSurface = MotifOnBackgroundLight,
    surfaceVariant = MotifSurfaceVariantLight,
    onSurfaceVariant = MotifOnSurfaceVariantLight,
    outline = MotifOutlineLight
)

@Composable
fun MotifTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Android 12+ uses the system's dynamic palette; earlier versions use Motif's fallback palette.
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        shapes = MotifShapes,
        typography = Typography,
        content = content
    )
}
