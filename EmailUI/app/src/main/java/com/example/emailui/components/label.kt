package com.example.emailui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun label(item: menu): String {
    var s=""
    if(item.icon!=null) {
        s = item.title?.let {
            Text(
                it,
                fontSize = 15.sp,
                modifier = Modifier.padding(start = 20.dp, bottom = 4.dp)
            )
        }.toString()
    }
    else
    {
             s = item.title?.let {
                 Text(
                     it,
                     fontSize = 12.sp,
                     modifier = Modifier.padding(bottom = 5.dp)
                 )
             }.toString()
        }
    return s
    }

