package com.example.startcompose.instagram

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.startcompose.R

@Composable
fun ProfileScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(name = "Raja Official instagram", modifier = Modifier.padding(10.dp) )
        Spacer(modifier = Modifier.size(4.dp))
        ProfileSection()
    }

}

@Composable
fun TopBar(
    name:String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxWidth()
    ){

        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_play),
            contentDescription = "back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.baseline_menu_24),
            contentDescription = "back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )

    }
}

@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            RoundImage(
                image = painterResource(id = R.drawable.img),
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
                )
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(modifier = modifier.weight(7f))
            ProfileDescription(
                displayName = "Programmer mentor",
                description = "10 years of coding experience \n"+
                        "want me to make your app? send me an email \n"+
                "subscribe to my youtube channel",
                url = "https://www.youtube.com/watch?",
                followedBy = listOf("codinginFlow","")

            )
        }

    }


}
@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
){
  Image(
      painter = image,
      contentDescription = "profile",
      modifier = modifier
          .aspectRatio(
              1f,
              matchHeightConstraintsFirst = true
          )
          .border(
              width = 1.dp,
              color = Color.LightGray,
              shape = CircleShape
          )
          .padding(3.dp)
          .clip(CircleShape)
  )
}

@Composable
fun StatSection(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileStat(nameText = "601", text = "Posts", modifier = modifier)
        ProfileStat(nameText = "100k", text = "Followers", modifier = modifier)
        ProfileStat(nameText = "71", text = "Following", modifier = modifier)

    }

}
@Composable
fun ProfileStat(
    nameText:String,
    text : String,
    modifier: Modifier
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = nameText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(height = 4.dp))
        Text(text = text)
    }

}

@Composable
fun ProfileDescription(
    displayName:String,
    description:String,
    url:String,
    followedBy:List<String>,
    otherCount:Int
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = description,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = url,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        if(followedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed by")
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if(index < followedBy.size){
                            append(", ")
                        }

                    }
                    if (otherCount > 2) {
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount otherCount")
                    }
                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }

    }


}