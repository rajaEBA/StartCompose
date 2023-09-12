package com.example.startcompose

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class RecycleviewActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn {
                itemsIndexed(listOf("This", "is", "jetpack", "compose")) { index, string ->
                    Text(
                        text = string,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                         modifier = Modifier.fillMaxSize().padding(vertical = 10.dp)
                    )
//                   Text(
//                       text = string,
//                       fontSize = 24.sp,
//                       fontWeight = FontWeight.Bold,
//                       textAlign = Paint.Align.CENTER,
//                       modifier = Modifier.fillMaxSize().padding(vertical = 10.dp)
//                   )
                }
            }
        }
    }
}