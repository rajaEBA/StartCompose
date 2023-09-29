package com.example.startcompose.drawer

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import com.example.startcompose.ui.theme.StartComposeTheme
import kotlinx.coroutines.launch

class DrawerActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StartComposeTheme {
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        AppBar(onNavigationIconClick = {
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        })
                    },
                    drawerContent = {
                        DrawerHeader()
                        DrawerBody(
                            items = listOf(
                                MenuItem(
                                    id = "home",
                                    title = "Home",
                                    contentDescription = "Go to Home Screen",
                                    icon = Icons.Default.Home
                                ),
                                MenuItem(
                                    id = "setting",
                                    title = "Setting",
                                    contentDescription = "Go to Home Screen",
                                    icon = Icons.Default.Settings
                                ),
                                MenuItem(
                                    id = "help",
                                    title = "Help",
                                    contentDescription = "Go to Home Screen",
                                    icon = Icons.Default.Info
                                )

                            ),
                            onItemClick = {
                                println("Clicked on ${it.title}")
                            }
                        )
                    }) {
                }

            }
        }
    }
}