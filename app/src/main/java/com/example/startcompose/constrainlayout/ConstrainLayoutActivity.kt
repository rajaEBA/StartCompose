package com.example.startcompose.constrainlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.*
import com.example.startcompose.ui.theme.StartComposeTheme

class ConstrainLayoutActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StartComposeTheme {
                val constraints = ConstraintSet {
                    val greenBox = createRefFor("green")
                    val redBox = createRefFor("red")
                    val guideLine = createGuidelineFromTop(0.5f)

                    constrain(greenBox) {
                        top.linkTo(guideLine)
                       // top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        width = Dimension.value(100.dp)
                        height = Dimension.value(100.dp)
                    }

                    constrain(redBox) {
                        top.linkTo(parent.top)
                        start.linkTo(greenBox.end)
                        //end.linkTo(parent.end)
                        width = Dimension.value(100.dp)
                        height = Dimension.value(100.dp)
                    }

                    createHorizontalChain(greenBox, redBox, chainStyle = ChainStyle.Packed)
                }

                ConstraintLayout(constraintSet = constraints, modifier = Modifier.fillMaxSize()) {
                    Box(modifier = Modifier.background(Color.Green).layoutId("green"))
                    Box(modifier = Modifier.background(Color.Red).layoutId("red"))
                }
            }
        }
    }
}