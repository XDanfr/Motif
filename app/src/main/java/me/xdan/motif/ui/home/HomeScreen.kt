package me.xdan.motif.ui.home

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.xdan.motif.ui.theme.MotifTheme

private data class WallpaperPreview(
    val id: String,
    val name: String,
    val variant: Int
)

private val sampleWallpapers = listOf(
    WallpaperPreview("tide-pool", "Tide pool", 0),
    WallpaperPreview("soft-orbit", "Soft orbit", 1),
    WallpaperPreview("coral-cut", "Coral cut", 2)
)

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun HomeScreen(
    onOpenEditor: (origin: String) -> Unit,
    sharedTransitionScope: SharedTransitionScope? = null,
    animatedVisibilityScope: AnimatedVisibilityScope? = null,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            item { MotifHeader() }
            item {
                CreateHero(
                    onCreateWallpaper = { onOpenEditor("create") },
                    onRandomWallpaper = { onOpenEditor("surprise") },
                    sharedTransitionScope = sharedTransitionScope,
                    animatedVisibilityScope = animatedVisibilityScope
                )
            }
            item {
                WallpaperSection(
                    title = "Saved",
                    subtitle = "Your latest designs",
                    wallpapers = sampleWallpapers,
                    originPrefix = "saved",
                    onOpenEditor = onOpenEditor,
                    sharedTransitionScope = sharedTransitionScope,
                    animatedVisibilityScope = animatedVisibilityScope
                )
            }
            item {
                WallpaperSection(
                    title = "Featured by Motif",
                    subtitle = "Included offline",
                    wallpapers = sampleWallpapers.reversed(),
                    originPrefix = "featured",
                    onOpenEditor = onOpenEditor,
                    sharedTransitionScope = sharedTransitionScope,
                    animatedVisibilityScope = animatedVisibilityScope
                )
            }
        }
    }
}

@Composable
private fun MotifHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            modifier = Modifier.size(48.dp),
            shape = RoundedCornerShape(18.dp, 18.dp, 18.dp, 7.dp),
            color = MaterialTheme.colorScheme.primary
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(
                    text = "✦",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
        Spacer(Modifier.width(12.dp))
        Column {
            Text(
                text = "Motif",
                style = MaterialTheme.typography.headlineLarge
            )
            Text(
                text = "Make your screen feel like yours",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun CreateHero(
    onCreateWallpaper: () -> Unit,
    onRandomWallpaper: () -> Unit,
    sharedTransitionScope: SharedTransitionScope?,
    animatedVisibilityScope: AnimatedVisibilityScope?
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
        shape = MaterialTheme.shapes.extraLarge,
        color = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
    ) {
        Box(Modifier.fillMaxSize()) {
            Box(
                Modifier
                    .size(180.dp)
                    .offset(x = 230.dp, y = (-55).dp)
                    .rotate(22f)
                    .clip(RoundedCornerShape(56.dp, 20.dp, 56.dp, 20.dp))
                    .background(MaterialTheme.colorScheme.secondaryContainer)
            )
            Box(
                Modifier
                    .size(92.dp)
                    .offset(x = 265.dp, y = 145.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.tertiary)
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = "Start something\nexpressive.",
                    style = MaterialTheme.typography.displaySmall
                )
                Spacer(Modifier.height(18.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    Button(
                        onClick = onCreateWallpaper,
                        modifier = Modifier.wallpaperSharedBounds(
                            key = "create",
                            sharedTransitionScope = sharedTransitionScope,
                            animatedVisibilityScope = animatedVisibilityScope
                        ),
                        shape = RoundedCornerShape(22.dp, 22.dp, 22.dp, 8.dp)
                    ) {
                        Text("Create wallpaper")
                    }
                    FilledTonalButton(
                        onClick = onRandomWallpaper,
                        modifier = Modifier.wallpaperSharedBounds(
                            key = "surprise",
                            sharedTransitionScope = sharedTransitionScope,
                            animatedVisibilityScope = animatedVisibilityScope
                        ),
                        shape = CircleShape
                    ) {
                        Text("Surprise me")
                    }
                }
            }
        }
    }
}

@Composable
private fun WallpaperSection(
    title: String,
    subtitle: String,
    wallpapers: List<WallpaperPreview>,
    originPrefix: String,
    onOpenEditor: (origin: String) -> Unit,
    sharedTransitionScope: SharedTransitionScope?,
    animatedVisibilityScope: AnimatedVisibilityScope?
) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            items(wallpapers) { wallpaper ->
                WallpaperCard(
                    wallpaper = wallpaper,
                    onClick = { onOpenEditor("$originPrefix-${wallpaper.id}") },
                    sharedTransitionKey = "$originPrefix-${wallpaper.id}",
                    sharedTransitionScope = sharedTransitionScope,
                    animatedVisibilityScope = animatedVisibilityScope
                )
            }
        }
    }
}

@Composable
private fun WallpaperCard(
    wallpaper: WallpaperPreview,
    onClick: () -> Unit,
    sharedTransitionKey: String,
    sharedTransitionScope: SharedTransitionScope?,
    animatedVisibilityScope: AnimatedVisibilityScope?
) {
    Surface(
        onClick = onClick,
        modifier = Modifier
            .width(132.dp)
            .height(192.dp)
            .wallpaperSharedBounds(
                key = sharedTransitionKey,
                sharedTransitionScope = sharedTransitionScope,
                animatedVisibilityScope = animatedVisibilityScope
            ),
        shape = when (wallpaper.variant) {
            1 -> RoundedCornerShape(32.dp, 10.dp, 32.dp, 32.dp)
            2 -> RoundedCornerShape(10.dp, 32.dp, 32.dp, 32.dp)
            else -> RoundedCornerShape(32.dp, 32.dp, 32.dp, 10.dp)
        },
        color = when (wallpaper.variant) {
            1 -> MaterialTheme.colorScheme.secondaryContainer
            2 -> MaterialTheme.colorScheme.tertiaryContainer
            else -> MaterialTheme.colorScheme.primary
        }
    ) {
        Box(Modifier.fillMaxSize()) {
            Box(
                Modifier
                    .size(112.dp)
                    .offset(x = 62.dp, y = (-24).dp)
                    .rotate(28f)
                    .clip(RoundedCornerShape(44.dp, 18.dp, 44.dp, 18.dp))
                    .background(
                        when (wallpaper.variant) {
                            1 -> MaterialTheme.colorScheme.tertiary
                            else -> MaterialTheme.colorScheme.secondary
                        }
                    )
            )
            Text(
                text = wallpaper.name,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(14.dp),
                style = MaterialTheme.typography.labelLarge,
                color = when (wallpaper.variant) {
                    0 -> MaterialTheme.colorScheme.onPrimary
                    1 -> MaterialTheme.colorScheme.onSecondaryContainer
                    else -> MaterialTheme.colorScheme.onTertiaryContainer
                },
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
private fun Modifier.wallpaperSharedBounds(
    key: String,
    sharedTransitionScope: SharedTransitionScope?,
    animatedVisibilityScope: AnimatedVisibilityScope?
): Modifier {
    if (sharedTransitionScope == null || animatedVisibilityScope == null) {
        return this
    }

    return with(sharedTransitionScope) {
        this@wallpaperSharedBounds.sharedBounds(
            sharedContentState = rememberSharedContentState(key = "wallpaper-$key"),
            animatedVisibilityScope = animatedVisibilityScope
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    MotifTheme {
        HomeScreen(
            onOpenEditor = {}
        )
    }
}
