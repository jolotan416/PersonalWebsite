package com.jolotan.personalwebsite.ui.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.WorkHistory
import androidx.compose.material.icons.outlined.Code
import androidx.compose.ui.graphics.vector.ImageVector

enum class DetailsType(val icon: ImageVector, val buttonText: String, val title: String) {
    Skills(
        icon = Icons.Default.Psychology,
        buttonText = "Skills",
        title = "What can I do?"
    ),
    Experience(
        icon = Icons.Default.WorkHistory,
        buttonText = "Experience",
        title = "What have I done?"
    ),
    Projects(
        icon = Icons.Outlined.Code,
        buttonText = "Projects",
        title = "What have I built?"
    )
}