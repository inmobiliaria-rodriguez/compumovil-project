package com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.theme.TripWithUsTheme
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.theme.darumaDrop

@Composable
fun ButtonItem(
    text: String,
    onClickFunction: () -> Unit
) {

    Box(
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = { onClickFunction() },
            colors = ButtonDefaults.buttonColors(TripWithUsTheme.colors.buttonDarkColor),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.width(150.dp)
        ) {
            Text(
                fontFamily = darumaDrop,
                text = text,
                color = Color.White,
                fontSize = 18.sp
            )
        }
    }
}
