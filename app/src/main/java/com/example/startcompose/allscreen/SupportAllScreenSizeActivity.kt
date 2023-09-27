package com.example.startcompose.allscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.startcompose.ui.theme.StartComposeTheme

class SupportAllScreenSizeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StartComposeTheme {
                val windowInfo = rememberWindowInfo()
                if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact) {
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(20) {
                            Text(
                                text = "Item $it",
                                // fontSize = 25.dp,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.Cyan)
                                    .padding(10.dp)
                            )
                        }

                        items(20) {
                            Text(
                                text = "Item $it",
                                // fontSize = 25.dp,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.Yellow)
                                    .padding(10.dp)
                            )
                        }

                    }
                } else {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        LazyColumn(modifier = Modifier.weight(1f)) {
                            items(20) {
                                Text(
                                    text = "Item $it",
                                    // fontSize = 25.dp,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(Color.Cyan)
                                        .padding(10.dp)
                                )
                            }
//                            items(10) {
//                                Text(
//                                    text = "Item $it",
//                                    // fontSize = 25.dp,
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .background(Color.Yellow)
//                                        .padding(10.dp)
//                                )
//                            }
                        }

                        LazyColumn(modifier = Modifier.weight(1f)) {
                            items(20) {
                                Text(
                                    text = "Item $it",
                                    // fontSize = 25.dp,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(Color.Yellow)
                                        .padding(10.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}