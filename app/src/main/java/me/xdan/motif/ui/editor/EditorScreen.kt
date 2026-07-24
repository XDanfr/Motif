package me.xdan.motif.ui.editor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.xdan.motif.ui.theme.MotifTheme

@Composable
fun EditorScreen(
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = {
            EditorTopBar(onNavigateBack = onNavigateBack)
        },
        bottomBar = {
            EditorTools()
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp, vertical = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            WallpaperCanvas()
        }
    }
}

@Composable
private fun EditorTopBar(onNavigateBack: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onNavigateBack) {
            Text(
                text = "←",
                style = MaterialTheme.typography.headlineSmall
            )
        }
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "Untitled wallpaper",
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "1080 × 2340 · Phone",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Button(
            onClick = {},
            shape = RoundedCornerShape(20.dp, 20.dp, 20.dp, 8.dp)
        ) {
            Text("Export")
        }
    }
}

@Composable
private fun WallpaperCanvas() {
    Surface(
        modifier = Modifier
            .fillMaxWidth(0.72f)
            .widthIn(max = 320.dp)
            .aspectRatio(9f / 19.5f),
        shape = RoundedCornerShape(28.dp),
        color = MaterialTheme.colorScheme.primary,
        shadowElevation = 12.dp
    ) {
        Box(Modifier.fillMaxSize()) {
            Box(
                Modifier
                    .size(220.dp)
                    .offset(x = 130.dp, y = (-45).dp)
                    .rotate(20f)
                    .clip(RoundedCornerShape(72.dp, 24.dp, 72.dp, 24.dp))
                    .background(MaterialTheme.colorScheme.secondary)
            )
            Box(
                Modifier
                    .size(104.dp)
                    .offset(x = 26.dp, y = 180.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.tertiaryContainer)
            )
            Box(
                Modifier
                    .size(width = 220.dp, height = 96.dp)
                    .offset(x = (-45).dp, y = 390.dp)
                    .rotate(-14f)
                    .clip(RoundedCornerShape(48.dp, 16.dp, 48.dp, 16.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer)
            )
            Surface(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(80.dp),
                shape = RoundedCornerShape(30.dp, 12.dp, 30.dp, 12.dp),
                color = MaterialTheme.colorScheme.secondaryContainer,
                border = androidx.compose.foundation.BorderStroke(
                    width = 3.dp,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            ) {}
        }
    }
}

@Composable
private fun EditorTools() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(topStart = 34.dp, topEnd = 34.dp),
        color = MaterialTheme.colorScheme.surfaceContainer,
        tonalElevation = 3.dp
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 14.dp)
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(width = 36.dp, height = 4.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.outline)
            )
            Spacer(Modifier.height(14.dp))
            Text(
                text = "Canvas",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ToolButton("＋", "Shape", Modifier.weight(1f))
                ToolButton("●", "Colour", Modifier.weight(1f))
                ToolButton("▧", "Layers", Modifier.weight(1f))
                ToolButton("⋯", "More", Modifier.weight(1f))
            }
        }
    }
}

@Composable
private fun ToolButton(
    symbol: String,
    label: String,
    modifier: Modifier = Modifier
) {
    Surface(
        onClick = {},
        modifier = modifier,
        shape = RoundedCornerShape(20.dp, 20.dp, 20.dp, 8.dp),
        color = MaterialTheme.colorScheme.secondaryContainer
    ) {
        Column(
            modifier = Modifier.padding(vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(symbol, style = MaterialTheme.typography.titleLarge)
            Text(label, style = MaterialTheme.typography.labelLarge)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EditorScreenPreview() {
    MotifTheme {
        EditorScreen(onNavigateBack = {})
    }
}
