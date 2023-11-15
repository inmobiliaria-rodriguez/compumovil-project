package com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.model.Tour
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.theme.TripWithUsTheme
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.theme.asul
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.theme.asulBold
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.theme.darumaDrop

@Composable
fun UserTourItemComponent(
    data: Tour,
    index: Int,
    modifier: Modifier = Modifier,
    onInscriptionTextClicked: () -> Unit,
) {
    var expanded by remember { mutableStateOf (false) }
    val gradient = when (index % 2) {
        0 -> TripWithUsTheme.colors.gradientTourItem1
        else -> TripWithUsTheme.colors.gradientTourItem2
    }
    Column(
        modifier = modifier
            .shadow(elevation = 3.dp, shape = RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
            .background(Brush.horizontalGradient(gradient))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                fontFamily = darumaDrop,
                text = data.name,
                fontSize = 36.sp,
                color = TripWithUsTheme.colors.mainFontBlack,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .offset(y = -10.dp)
                    .fillMaxWidth()
            )
            Column(
                modifier = Modifier
                    .offset(y = -10.dp)
                    .padding(start = 10.dp)
                    .fillMaxSize()
                    .width(IntrinsicSize.Max)
            ) {
                Text(
                    fontFamily = asulBold,
                    text = data.company,
                    fontSize = 16.sp,
                    color = TripWithUsTheme.colors.mainFontBlack,
                )
                Row(modifier = Modifier
                    .padding(top = 4.dp)
                ) {
                    Text(
                        fontFamily = asulBold,
                        text = "Fecha(s): ",
                        fontSize = 16.sp,
                        color = TripWithUsTheme.colors.mainFontBlack,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        fontFamily = asul,
                        text = data.date,
                        fontSize = 16.sp,
                        color = TripWithUsTheme.colors.mainFontBlack,
                    )
                }
                if(expanded) {
                    Row(modifier = Modifier
                        .padding(top = 4.dp)
                    ) {
                        Text(
                            fontFamily = asulBold,
                            text = "Hora de inicio: ",
                            fontSize = 16.sp,
                            color = TripWithUsTheme.colors.mainFontBlack,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            fontFamily = asul,
                            text = data.hour,
                            fontSize = 16.sp,
                            color = TripWithUsTheme.colors.mainFontBlack,
                        )
                    }

                    Row(modifier = Modifier
                        .padding(top = 4.dp)
                    ) {
                        Text(
                            fontFamily = asulBold,
                            text = "Guía: ",
                            fontSize = 16.sp,
                            color = TripWithUsTheme.colors.mainFontBlack,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            fontFamily = asul,
                            text = data.guide,
                            fontSize = 16.sp,
                            color = TripWithUsTheme.colors.mainFontBlack,
                        )
                    }
                }
                Row(modifier = Modifier
                    .padding(top = 4.dp)
                    .fillMaxSize()
                ) {
                    if(expanded) {
                        Text(
                            fontFamily = asulBold,
                            text = "Precio: ",
                            fontSize = 16.sp,
                            color = TripWithUsTheme.colors.mainFontBlack,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Text(
                        fontFamily = asul,
                        text = "$" + data.price,
                        fontSize = 16.sp,
                        color = TripWithUsTheme.colors.mainFontBlack,
                    )
                    Spacer(Modifier.weight(1f))

                    if (!expanded){
                        Text(
                            fontFamily = asul,
                            text = "Ver más",
                            fontSize = 20.sp,
                            color = TripWithUsTheme.colors.mainFontBlack,
                            fontWeight = FontWeight.Bold,
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .clickable {
                                    expanded = !expanded
                                }
                        )
                    }
                }
                if(expanded) {
                    Row(modifier = Modifier
                        .padding(top = 4.dp)
                    ) {
                        Text(
                            fontFamily = asulBold,
                            text = "Descripción:",
                            fontSize = 16.sp,
                            color = TripWithUsTheme.colors.mainFontBlack,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Row(modifier = Modifier
                        .padding(top = 6.dp)
                    ) {
                        Text(
                            fontFamily = asul,
                            text = data.description,
                            fontSize = 16.sp,
                            color = TripWithUsTheme.colors.mainFontBlack,
                        )
                    }

                    Row(modifier = Modifier
                        .padding(top = 6.dp)
                    ) {
                        Text(
                            fontFamily = asulBold,
                            text = "Cupos disponibles: ",
                            fontSize = 16.sp,
                            color = TripWithUsTheme.colors.mainFontBlack,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            fontFamily = asul,
                            text = data.capacity,
                            fontSize = 16.sp,
                            color = TripWithUsTheme.colors.mainFontBlack,
                        )
                    }
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
                            top = 20.dp,
                            bottom = 15.dp
                        ),
                        contentScale = ContentScale.Crop,
                    )
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            fontFamily = asul,
                            text = "Inscríbeme!",
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
                            color = TripWithUsTheme.colors.mainFontBlack,
                            fontWeight = FontWeight.Bold,
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .clickable {
                                    onInscriptionTextClicked()
                                }
                        )
                    }
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            fontFamily = asul,
                            text = "Ver ménos",
                            fontSize = 20.sp,
                            color = TripWithUsTheme.colors.mainFontBlack,
                            fontWeight = FontWeight.Bold,
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .clickable {
                                    expanded = !expanded
                                }
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun TourItemPreview() {
    TripWithUsTheme {
        UserTourItemComponent(
            data = Tour(
                "Estepenco",
                "Manizales",
                "test",
                "4pm",
                "10 de Febrero",
                "360.000",
                "test",
                "test",
                "test",
                "En curso"
            ),
            index = 0,
            onInscriptionTextClicked = {},
            modifier = Modifier
                .padding(8.dp)
        )
    }
}