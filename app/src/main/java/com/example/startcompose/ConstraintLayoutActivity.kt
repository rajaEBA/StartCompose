package com.example.startcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.*
import com.example.startcompose.ui.theme.StartComposeTheme

class ConstraintLayoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StartComposeTheme {
                Text("Test box")
                val contraints = ConstraintSet {
                    val greenBox = createRefFor("greenbox")
                    val redBox = createRefFor("redbox")
                    val guildLine = createGuidelineFromTop(0.5f)

                    constrain(greenBox){
                        top.linkTo(guildLine)
                        start.linkTo(parent.start)
                        width = Dimension.value(100.dp)
                        height = Dimension.value(100.dp)
                    }

                    constrain(redBox) {
                        top.linkTo(parent.top)
                        start.linkTo(greenBox.end)
                        width = Dimension.value(100.dp)
                        height = Dimension.value(100.dp)
                    }
                    createHorizontalChain(greenBox, redBox, chainStyle = ChainStyle.Packed)

                }

                ConstraintLayout(contraints, modifier = Modifier.fillMaxSize()) {
                    Box(
                        modifier = Modifier
                            .background(Color.Green)
                            .layoutId("greenbox")
                    )
                    Box(
                        modifier = Modifier
                            .background(Color.Red)
                            .layoutId("redbox")
                    )
                }
            }
        }
    }
}