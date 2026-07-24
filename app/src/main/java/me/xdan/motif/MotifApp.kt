package me.xdan.motif

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import me.xdan.motif.ui.editor.EditorScreen
import me.xdan.motif.ui.home.HomeScreen

private const val HomeRoute = "home"
private const val EditorRoute = "editor/{origin}"

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun MotifApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    SharedTransitionLayout {
        NavHost(
            navController = navController,
            startDestination = HomeRoute,
            modifier = modifier,
            popEnterTransition = { EnterTransition.None },
            popExitTransition = {
                scaleOut(
                    targetScale = 0.9f,
                    transformOrigin = TransformOrigin(0.5f, 0.5f)
                ) + slideOutHorizontally { width -> width / 8 }
            }
        ) {
            composable(HomeRoute) {
                HomeScreen(
                    onOpenEditor = { origin ->
                        navController.navigate("editor/$origin")
                    },
                    sharedTransitionScope = this@SharedTransitionLayout,
                    animatedVisibilityScope = this@composable
                )
            }

            composable(
                route = EditorRoute,
                arguments = listOf(
                    navArgument("origin") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                EditorScreen(
                    origin = backStackEntry.arguments?.getString("origin") ?: "create",
                    onNavigateBack = navController::popBackStack,
                    sharedTransitionScope = this@SharedTransitionLayout,
                    animatedVisibilityScope = this@composable
                )
            }
        }
    }
}
