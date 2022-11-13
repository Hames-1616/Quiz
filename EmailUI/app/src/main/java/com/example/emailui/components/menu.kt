package com.example.emailui.components

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class menu //objects of sealed class appear at the compile time
    (
    val icon : ImageVector?=null,
    val title : String?=null,
    val isdivider : Boolean =false,
    val isheader : Boolean = false
            )
{
        object Allinboxes : menu
            (
            icon = Icons.Filled.AllInbox,
            title = "All inboxes"
                    )
        object primary :menu (
            icon = Icons.Filled.Inbox,
            title = "Primary"
                )
        object promotion :menu(
            icon = Icons.Filled.Tag,
            title = "Promotion"
        )
    object alllabels : menu(
        title = "All Labels"
    )
    object updates :menu(
        title = "Updates",
        icon = Icons.Filled.Update
    )
    object snoz : menu(
        title = "Snoozed",
        icon = Icons.Filled.Snooze
    )
    object Important : menu(
        title = "Important",
        icon = Icons.Filled.LabelImportant
    )
    object drafts : menu (
        title = "Draft",
        icon = Icons.Filled.Drafts
            )
    object spam : menu(
        title = "Spam",
        icon = Icons.Filled.Stop
    )
    object outbox: menu (
        title = "Outbox",
        icon = Icons.Filled.Outbox
            )
    object trash : menu(
        title = "Trash",
        icon = Icons.Filled.Delete
    )
    object form : menu(
        title = "Forms",
        icon = Icons.Filled.Message
    )
    object Sent:menu(
        title = "Sent",
        icon = Icons.Filled.Send
    )
    object Schedule:menu(
        title = "Schedule",
        icon = Icons.Filled.Schedule
    )
    object calendar : menu(
        title = "Calender",
        icon = Icons.Filled.CalendarToday
    )
    object settings : menu (
        title = "Settings",
        icon = Icons.Filled.Settings
            )
    object missed : menu(
        title = "Missed",
        icon = Icons.Filled.CallMissed
    )
    object divi : menu (
        isdivider = true
            )
    }
