package com.example.emailui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.emailui.components.*
import com.example.emailui.ui.theme.EmailUITheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmailUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    email()
                }
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun email() {

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val scroll = rememberScrollState()
// icons to mimic drawer destinations
    val items = listOf(
        menu.Allinboxes,
        menu.primary,
        menu.promotion,
        menu.alllabels,
        menu.updates,
        menu.drafts,
        menu.outbox,
        menu.snoz,
        menu.Important,
        menu.spam,
        menu.Schedule,
        menu.form,
        menu.trash,
        menu.Sent,
        menu.settings,
        menu.calendar,
        menu.missed,
        menu.divi
    )

    val selectedItem = remember { mutableStateOf(items[0]) }
    ModalNavigationDrawer(

        drawerState = drawerState,
        drawerContent =
        {
            ModalDrawerSheet(modifier = Modifier.verticalScroll(scroll))
            {
                Column() {
                    Text(
                        text = "Email",
                        modifier = Modifier
                            .padding(start = 20.dp, top = 20.dp),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Divider(
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(top = 13.dp)
                )
                Spacer(Modifier.height(30.dp))
                items.forEach { item ->

                    when {
                        item.isdivider -> {
                            Divider(
                                thickness = 1.dp,
                                color = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.padding(top = 13.dp)
                            )
                        }
                    }
                    NavigationDrawerItem(
                        icon = { item.icon?.let { Icon(it, contentDescription = null) } },
                        label = { label(item) },
                        shape = RoundedCornerShape(topEnd = 40.dp, bottomEnd = 40.dp),

                        selected = item == selectedItem.value,
                        onClick = {
                            scope.launch { drawerState.close() }//on clicking the item drawer is closed
                            selectedItem.value = item//remembers the item that selected it
                        },
                        modifier = Modifier
                            .padding(bottom = 2.dp, end = 52.dp)
                    )

                }
            }
        },

        content = {
            Scaffold(
                topBar = { Homeappbar(drawerState, scope)},
                bottomBar = { bottom()},
                floatingActionButton = { fab(scroll) }
            )
            {
                lazy(scroll)

            }
        }
    )
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EmailUITheme {
        email()
    }
}