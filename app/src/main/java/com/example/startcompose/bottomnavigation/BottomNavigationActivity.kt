package com.example.startcompose.bottomnavigation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

class BottomNavigationActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Scaffold(
                bottomBar = {
                    BottomNavigationBar(
                        items = listOf(
                            BottomNavItem(
                                name = "Home",
                                route = "home",
                                icon = Icons.Default.ArrowBack
                            ),
                            BottomNavItem(
                                name = "Chat",
                                route = "chat",
                                icon = Icons.Default.ArrowBack
                            ),
                            BottomNavItem(
                                name = "Settings",
                                route = "setting",
                                icon = Icons.Default.ArrowBack
                            )
                        ),
                        navController = navController,
                        onItemClick = {
                            navController.navigate(it.route)
                        }
                    )
                }
            ) {
                BottomNavigation(navController = navController)
            }
        }
    }
}

@Composable
fun BottomNavigation(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen()

        }
        composable("chat") {
            ChatScreen()
        }
        composable("setting") {
            SettingsScreen()
        }

    }

}

@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
){
    val backStateEntry = navController.currentBackStackEntryAsState()
   BottomNavigation(
       modifier = modifier,
       backgroundColor = Color.DarkGray,
       elevation = 5.dp
   ) {
       items.forEach {item ->
           val selected = item.route == backStateEntry.value?.destination?.route
           BottomNavigationItem(
               selected = selected,
               onClick = { onItemClick(item)},
               selectedContentColor = Color.Green,
               unselectedContentColor = Color.Gray,
               icon = {
                   Column(horizontalAlignment = Alignment.CenterHorizontally) {
                       if (item.badgeCount > 0) {
                           BadgedBox(badge = {
                               Text(text = item.badgeCount.toString())
                           }) {
                               Icon(
                                   imageVector = item.icon,
                                   contentDescription = item.name
                               )
                           }
                       } else {
                           Icon(
                               imageVector = item.icon,
                               contentDescription = item.name
                           )

                       }
                       if (selected) {
                           Text(
                               text = item.name,
                               // textAlign = Alignment.Center,
                               fontSize = 10.sp
                           )
                       }
                   }
               }
           )
       }

   }

}

@Composable
fun HomeScreen(){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text= "Test home screen")
    }

}


@Composable
fun ChatScreen(){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text= "Test chat screen")
    }

}


@Composable
fun SettingsScreen(){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text= "Setting home screen")
    }

}