package me.xdan.motif.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val MotifShapes = Shapes(
    extraSmall = RoundedCornerShape(8.dp),
    small = RoundedCornerShape(14.dp),
    medium = RoundedCornerShape(22.dp),
    large = RoundedCornerShape(
        topStart = 18.dp,
        topEnd = 30.dp,
        bottomEnd = 30.dp,
        bottomStart = 30.dp
    ),
    extraLarge = RoundedCornerShape(
        topStart = 14.dp,
        topEnd = 42.dp,
        bottomEnd = 42.dp,
        bottomStart = 42.dp
    )
)
