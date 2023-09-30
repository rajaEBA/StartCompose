package com.example.startcompose.snackbar

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class SnackbarActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val state = rememberScaffoldState()
            var textFiledState by remember {
                mutableStateOf("")
            }
            val scope = rememberCoroutineScope()
            Scaffold(modifier = Modifier.fillMaxSize(),
                scaffoldState = state
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 8.dp)
                ) {
                    TextField(
                        value = textFiledState,
                        onValueChange = { textFiledState = it },
                        label = { Text(text = "Enter your name") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),

                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = {
                        scope.launch {
                            state.snackbarHostState.showSnackbar("HELLO $textFiledState")
                        }
                    }) {
                        Text(text = "Plz greet me")

                    }
                }
            }
        }
    }
}