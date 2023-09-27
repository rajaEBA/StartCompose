package com.example.startcompose.multiselection

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.startcompose.ui.theme.StartComposeTheme

class MultiSelectionActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StartComposeTheme {
                var items by remember {
                    mutableStateOf(
                        (1..20).map {
                            ListItem(
                                title = "Item $it",
                                isSelected = false
                            )
                        }
                    )
                }
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(items.size) { i ->
                        Row(modifier = Modifier
                            .fillMaxSize()
                            .clickable {
                                items = items.mapIndexed { j, item ->
                                    if (i == j) {
                                        item.copy(isSelected = !item.isSelected)
                                    } else item
                                }
                            }
                            .padding(15.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = items[i].title)
                            if (items[i].isSelected) {
                                Icon(
                                    imageVector = Icons.Default.Favorite,
                                    contentDescription = "selected",
                                    tint = Color.Green,
                                    modifier = Modifier.size(20.dp)
                                )

                            }

                        }
                    }
                }

            }
        }
    }
}