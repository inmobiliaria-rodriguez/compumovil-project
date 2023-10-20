package com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.model.Tour
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.theme.TripWithUsTheme
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.theme.darumaDrop
@Composable
fun ButtonItem(
    text: String,
    buttonColors: Color = TripWithUsTheme.colors.buttonDarkColor,
    fontColor: Color = Color.White,
    btnModifier: Modifier = Modifier,
    fontModifier: Modifier = Modifier,
    onClickFunction: () -> Unit
) {

    Box(
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = { onClickFunction() },
            colors = ButtonDefaults.buttonColors(buttonColors),
            shape = RoundedCornerShape(8.dp),
            modifier = btnModifier
                .width(150.dp)
        ) {
            Text(
                fontFamily = darumaDrop,
                text = text,
                color = fontColor,
                fontSize = 22.sp,
                modifier = fontModifier
            )
        }
    }
}

@Preview()
@Composable
private fun ButtonPreview() {
    TripWithUsTheme {
        ButtonItem(
            text = "Preview",
            onClickFunction = {}
        )
    }
}

@Preview()
@Composable
private fun BackButtonPreview() {
    TripWithUsTheme {
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
    }
}