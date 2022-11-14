package com.example.emailui.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun fab(scroll:ScrollState){
    val x = scroll.value
    if(scroll.value>100)
    {
        ExtendedFloatingActionButton(onClick = { /*TODO*/ },
        containerColor = MaterialTheme.colorScheme.primary)
        {
            Text("Compose")
            Icon(imageVector = Icons.Filled.Edit, contentDescription =null )
        }
    }
    else
    FloatingActionButton(
        onClick = { /*TODO*/ },
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        Icon(imageVector = Icons.Filled.Edit, contentDescription =null )

    }
}






















