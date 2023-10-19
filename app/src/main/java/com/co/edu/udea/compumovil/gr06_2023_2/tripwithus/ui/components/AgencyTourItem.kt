package com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.model.Tour
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.theme.TripWithUsTheme
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.theme.asul
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.theme.asulBold
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.theme.darumaDrop

@Composable
fun AgencyTourItemComponent(
    data: Tour,
    index: Int,
    modifier: Modifier = Modifier
) {
    val gradient = when (index % 2) {
        0 -> TripWithUsTheme.colors.gradientTourItem1
        else -> TripWithUsTheme.colors.gradientTourItem2
    }
    Column(
        modifier = modifier
            .height(112.dp)
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
                        text = data.date + " " + data.hour,
                        fontSize = 16.sp,
                        color = TripWithUsTheme.colors.mainFontBlack,
                    )
                }
                Row(modifier = Modifier
                    .padding(top = 4.dp)
                    .fillMaxSize()
                ) {
                    Text(
                        fontFamily = asul,
                        text = data.state,
                        fontSize = 16.sp,
                        color = TripWithUsTheme.colors.mainFontBlack,
                    )
                    Spacer(Modifier.weight(1f))
                    Text(
                        fontFamily = asul,
                        text = "VER MAS",
                        fontSize = 20.sp,
                        color = TripWithUsTheme.colors.mainFontBlack,
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier
                            .padding(end = 8.dp)
                    )
                }
            }
        }
    }
}

@Preview()
@Composable
private fun TourItemPreview() {
    TripWithUsTheme {
        AgencyTourItemComponent(
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
            modifier = Modifier
                .padding(8.dp)
        )
    }
}