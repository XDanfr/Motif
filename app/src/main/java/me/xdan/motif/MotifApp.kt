package me.xdan.motif

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.xdan.motif.ui.editor.EditorScreen
import me.xdan.motif.ui.home.HomeScreen

private const val HomeRoute = "home"
private const val EditorRoute = "editor"

@Composable
fun MotifApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeRoute,
        modifier = modifier
    ) {
        composable(HomeRoute) {
            HomeScreen(
                onCreateWallpaper = { navController.navigate(EditorRoute) },
                onOpenWallpaper = { navController.navigate(EditorRoute) }
            )
        }

        composable(EditorRoute) {
            EditorScreen(onNavigateBack = navController::popBackStack)
        }
    }
}
