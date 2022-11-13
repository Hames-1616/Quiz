package com.example.emailui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.VideoCall
import androidx.compose.ui.graphics.vector.ImageVector

sealed class bottomdata(
    val icon : ImageVector,
    val title : String
) {
    object mail :bottomdata(
        icon= Icons.Filled.Mail,
        title = "Mail"
    )
    object meet : bottomdata(
        icon = Icons.Filled.VideoCall,
        title = "Meet"
    )
}