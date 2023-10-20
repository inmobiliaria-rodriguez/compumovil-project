package com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.pages.user

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.R
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.components.ButtonItem
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.theme.TripWithUsTheme
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.theme.darumaDrop
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.utils.tourList

@Preview
@Composable
fun MapsRoute() {
    val tour = tourList(context = LocalContext.current)[1];
    Column {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
                .shadow(elevation = 3.dp, shape = RoundedCornerShape(8.dp))
                .clip(RoundedCornerShape(8.dp))
                .background(Brush.horizontalGradient(TripWithUsTheme.colors.gradientHeader))

        ) {
            ButtonItem(
                text = "Volver",
                buttonColors = TripWithUsTheme.colors.mainTitle,
                btnModifier = Modifier
                    .padding(8.dp)
                    .width(120.dp),
                fontModifier = Modifier
                    .offset(y = -4.dp),
                onClickFunction = {}
            )
            Text(
                fontFamily = darumaDrop,
                text = "Cursando el tour:",
                fontSize = 30.sp,
                color = TripWithUsTheme.colors.mainFontBlack,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .offset(y = -10.dp)
                    .fillMaxWidth()
            )
            Text(
                fontFamily = darumaDrop,
                text = tour.name,
                fontSize = 34.sp,
                color = TripWithUsTheme.colors.mainFontBlack,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .offset(y = -10.dp)
                    .fillMaxWidth()
            )
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://i.blogs.es/ee0d50/googlemaps/1366_2000.jpg")
                    .crossfade(true)
                    .build(),
                contentDescription = "Maps sample image",
                modifier = Modifier.
                    padding(
                        start = 25.dp,
                        end = 25.dp,
                        bottom = 15.dp
                    ),
                contentScale = ContentScale.Crop,
            )
            Text(
                fontFamily = darumaDrop,
                text = "Tu guia:",
                fontSize = 22.sp,
                color = TripWithUsTheme.colors.mainFontBlack,
                textAlign = TextAlign.Left,
                modifier = Modifier
                    .padding(start = 25.dp)
                    .offset(y = -10.dp)
            )
            Text(
                fontFamily = darumaDrop,
                text = tour.guide,
                fontSize = 30.sp,
                color = TripWithUsTheme.colors.mainFontBlack,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(end = 30.dp)
                    .offset(y = -25.dp)
                    .fillMaxWidth()
            )
            Text(
                fontFamily = darumaDrop,
                text = "Hora de salida:",
                fontSize = 22.sp,
                color = TripWithUsTheme.colors.mainFontBlack,
                textAlign = TextAlign.Left,
                modifier = Modifier
                    .padding(start = 25.dp)
                    .offset(y = -25.dp)
            )
            Text(
                fontFamily = darumaDrop,
                text = tour.hour,
                fontSize = 30.sp,
                color = TripWithUsTheme.colors.mainFontBlack,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(end = 30.dp)
                    .offset(y = -40.dp)
                    .fillMaxWidth()
            )
            Text(
                fontFamily = darumaDrop,
                text = "Llegaras a las:",
                fontSize = 22.sp,
                color = TripWithUsTheme.colors.mainFontBlack,
                textAlign = TextAlign.Left,
                modifier = Modifier
                    .padding(start = 25.dp)
                    .offset(y = -40.dp)
            )
            Text(
                fontFamily = darumaDrop,
                text = "5:36 pm",
                fontSize = 30.sp,
                color = TripWithUsTheme.colors.mainFontBlack,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(end = 30.dp)
                    .offset(y = -55.dp)
                    .fillMaxWidth()
            )
        }
    }

}