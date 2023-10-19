package com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.theme.TripWithUsTheme
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.theme.darumaDrop

@Composable
fun HeaderComponent(text: String) {
    val headerModifier = Modifier
        .fillMaxWidth()
        .height(90.dp)
        .background(TripWithUsTheme.colors.headerBackground)

    val contentModifier = Modifier
        .padding(15.dp)

    Row(
        modifier = headerModifier,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            fontFamily = darumaDrop,
            text = text,
            modifier = contentModifier,
            fontSize = 40.sp,
            color = TripWithUsTheme.colors.mainTitle
        )
    }
}

