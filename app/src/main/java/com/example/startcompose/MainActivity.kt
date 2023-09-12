package com.example.startcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.startcompose.ui.theme.StartComposeTheme
import kotlin.random.Random


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StartComposeTheme {

                val color = remember {
                    mutableStateOf(Color.Yellow)
                }

                Column(modifier = Modifier.fillMaxSize()){
                    ColorBox(modifier = Modifier
                        .weight(1f)
                        .fillMaxSize()
                    ){
                        color.value = it
                    }
                    Box(modifier = Modifier
                        .background(color.value)
                        .weight(1f)
                        .fillMaxSize()){

                    }
                }
//                val fontFamily = FontFamily(
//                    Font(R.font.lexend, FontWeight.Thin)
//                )
                //DefaultPreview()

//                val painter = painterResource(id = R.drawable.img)
//                val description = "Kermit in snow"
//                val title = "Kermit is playing in snow"
//                Box(modifier = Modifier
//                    .fillMaxWidth(0.5f)
//                    .padding(16.dp)){
//                    ImageLoad(painter = painter, contentDescription = description, title = title )
//                }

//                Box(modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color(0xFF101010))
//                ){
//                 Text(
//                     text = buildAnnotatedString {
//                         withStyle(style = SpanStyle(
//                                 color = Color.Green,
//                                 fontSize = 50.sp
//                             )
//                         ){
//                             append("J")
//                         }
//                         append("etpack")
//                         withStyle(style = SpanStyle(
//                             color = Color.Green,
//                             fontSize = 50.sp
//                         )
//                         ){
//                             append("C")
//                         }
//                         append("ompose")
//                     },
//                     color = Color.White,
//                     fontSize = 30.sp,
//                     fontFamily = fontFamily,
//                     fontWeight = FontWeight.Bold,
//                     fontStyle = FontStyle.Italic
//                 )
//                }

//                var name by remember{
//                    mutableStateOf("")
//                }
//                var names by remember {
//                    mutableStateOf(listOf<String>())
//                }
//
//                Column(modifier = Modifier
//                    .fillMaxSize()
//                    .padding(16.dp)
//                ) {
//
//                    Row(modifier = Modifier.fillMaxWidth(),
//                        verticalAlignment = Alignment.CenterVertically) {
//                        OutlinedTextField(
//                            modifier = Modifier.weight(1f),
//                            value = name,
//                            onValueChange = { text ->
//                                name = text
//                            },
//                            label = { Text("Label") },
//
//                        )
//
//                        Spacer(modifier = Modifier.width(16.dp))
//                        Button(onClick = {
//                            if (name.isNotBlank()) {
//                                names = names + name
//                                name = ""
//                            }
//                        }) {
//                            Text(text = "Add")
//                        }
//                    }
//                    LazyColumn(modifier = Modifier.weight(1f)) {
//                        items(names) { currentName ->
//                            Text(text = currentName,
//                            modifier = Modifier.fillMaxWidth()
//                                .padding(16.dp)
//                            )
//                            Divider()
//                        }
//                    }
//                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String) {
////    Box(
////        modifier = Modifier.size(400.dp)
////    ) {
////        Text(
////            text = "Hello $name!",
////            color = Color.Blue,
////            fontSize = 13.sp,
////            modifier = Modifier.align(Alignment.BottomEnd)
////        )
////        Text(
////            text = "some other test",
////            color = Color.Blue,
////            fontSize = 14.sp,
////            //modifier = Modifier.align(Alignment.TopStart)
////        )
////    }
//
////    Image( painter = painterResource(id = R.drawable.ic_launcher_foreground),
////        contentDescription = null
////    )
//
////    Icon(imageVector = Icons.Default.Person,
////        contentDescription = "Person Icon")
//
//    LazyColumn(modifier = Modifier.fillMaxSize()) {
//        items(8) { i ->
//            Icon(
//                imageVector = Icons.Default.Person,
//                contentDescription = "Person Icon"
//            )
//        }
//    }
//}

@Composable
fun ColorBox(
    modifier: Modifier = Modifier,
    updateColor: (Color) -> Unit
){
    Box(modifier = modifier
        .background(Color.Red)
        .clickable {
            updateColor(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            )
        }
    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StartComposeTheme {

    }
}

@Composable
fun ImageLoad(
    painter : Painter,
    contentDescription :String,
    title:String,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Gray)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ), startY = 300f
                        )
                    )
            ) {}
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ){
                Text(title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }


    }

}