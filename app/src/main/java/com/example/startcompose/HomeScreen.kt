package com.example.startcompose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.startcompose.ui.theme.*

@ExperimentalFoundationApi
@Composable
fun HomeScreen() {

    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            GreetingSection()
            ChipSection(listOf("Sweet sleep", "Insomnia", "Depression"))
            CurrentMeditationSection()

            FeatureSection(
                features = listOf(
                    Feature(
                        title = "Sleep meditation",
                        R.drawable.ic_headphone,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "Tips for sleeping",
                        R.drawable.ic_videocam,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    )
                )
            )


        }

        BottomMenu(items = listOf(
            BottomMenuContent("Home", R.drawable.ic_home),
            BottomMenuContent("Meditate", R.drawable.ic_bubble),
            BottomMenuContent("Sleep", R.drawable.ic_moon),
            BottomMenuContent("Music", R.drawable.ic_music),
            BottomMenuContent("Profile", R.drawable.ic_profile),
        ), modifier = Modifier.align(Alignment.BottomCenter)
        )

    }

}
@Composable
fun GreetingSection(
    name : String = "Raja"
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = "Good morning, $name",
                style = MaterialTheme.typography.h2
            )
            Text(
                text = "We wish you a wonderful day!",
                style = MaterialTheme.typography.body1
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }

}
@Composable
fun ChipSection(
    chips : List<String>
){
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow {
        items(chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(15.dp)
            ) {
                Text(text = chips[it], color = TextWhite)
            }
        }
    }
}

@Composable
fun CurrentMeditationSection(
    color: Color = LightRed
) {
    Row(
//        horizontalArrangement = Arrangement.SpaceBetween,
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = Modifier
//            .padding(15.dp)
//            .clip(RoundedCornerShape(10.dp))
//            .background(color)
//            .padding(horizontal = 15.dp, vertical = 20.dp)
//            .fillMaxWidth()

        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
//        Column(
//            verticalArrangement = Arrangement.Center
//        ) {
//            Text(text = "Daily Thought",
//                style = MaterialTheme.typography.h2)
//            Text(text = "Meditation 3-10 min",
//                style = MaterialTheme.typography.body1,
//                color = TextWhite)
//        }

        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Daily Thought",
                style = MaterialTheme.typography.h2
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = "Meditation • 3-10 min",
                style = MaterialTheme.typography.body1,
                color = TextWhite
            )

        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }

    }
}

@ExperimentalFoundationApi
@Composable
fun FeatureSection(features: List<Feature>) {

  Column(modifier = Modifier.fillMaxWidth()) {
      Text(
          text = "Feature",
          style = MaterialTheme.typography.h1,
          modifier = Modifier.padding(15.dp)
      )
      LazyVerticalGrid(
          columns = GridCells.Fixed(2),
          contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
          modifier = Modifier.fillMaxHeight()
      ) {
          items(features.size) {
              FeatureItem(feature = features[it])
          }

      }
  }
}

@Composable
fun FeatureItem(
    feature: Feature
) {
  BoxWithConstraints(
      modifier = Modifier
          .padding(7.5.dp)
          .aspectRatio(1f)
          .clip(RoundedCornerShape(10.dp))
          .background(feature.darkColor)
  ) {
      Box(
          modifier = Modifier
              .fillMaxSize()
              .padding(15.dp)
      ) {
          Text(
              text = feature.title,
              style = MaterialTheme.typography.h2,
              lineHeight = 26.sp,
              modifier = Modifier.align(Alignment.TopStart)
          )
          Icon(
              painter = painterResource(id = feature.iconId),
              contentDescription = feature.title,
              tint = Color.White,
              modifier = Modifier.align(Alignment.BottomStart)
          )
          Text(
              text = "Start",
              color = TextWhite,
              fontSize = 14.sp,
              fontWeight = FontWeight.Bold,
              modifier = Modifier
                  .clickable {

                  }
                  .align(Alignment.BottomEnd)
                  .clip(RoundedCornerShape(10.dp))
                  .background(ButtonBlue)
                  .padding(vertical = 6.dp, horizontal = 14.dp)
          )


      }

  }
}

@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0
) {

    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor,
            ) {
                selectedItemIndex = index
            }
        }

    }

}

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onItemClick()}
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )


        }
        Text(
            text = item.title,
            color = if (isSelected) activeTextColor else inactiveTextColor
        )

    }
    
}