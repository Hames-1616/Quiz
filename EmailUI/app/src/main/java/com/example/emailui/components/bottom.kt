package com.example.emailui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun bottom() {
    val items = listOf(
        bottomdata.mail,
        bottomdata.meet
    )
        NavigationBar(
            modifier = Modifier.requiredHeight(72.dp)
        ) {
            items.forEach { item ->
                NavigationBarItem(
                    selected = false,
                    onClick = { /*TODO*/ },
                    icon = { Icon(item.icon, null) },
                    label = { Text(item.title, fontSize = 11.sp) },

                    )

            }

        }

    }


