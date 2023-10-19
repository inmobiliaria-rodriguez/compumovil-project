package com.co.edu.udea.compumovil.gr06_2023_2.tripwithus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.model.Tour
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.components.HeaderComponent
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.components.UserTourItemComponent
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.pages.agency.ListOfMyTours
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.pages.user.ListOfTours
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.theme.TripWithUsTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripWithUsTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = TripWithUsTheme.colors.uiBackground) {
                    //ListOfMyTours(TestTours)
                    //ListOfTours(TestTours)
                }
            }
        }
    }
}

val TestTours = listOf(
    Tour(
        "Rapido Ochoa",
        "Urabá",
        "test",
        "4pm",
        "10 de Febrero",
        "20.000",
        "test",
        "test",
        "test",
        "En curso"
    ),
    Tour(
        "Flota Magdalena",
        "Manizales",
        "test",
        "10:00am",
        "15 de Marzo",
        "50.000",
        "test",
        "test",
        "test",
        "Pendiente"
    ),
    Tour(
        "Estepenco",
        "Popayán",
        "test",
        "16:00",
        "31 de Diciembre",
        "90.000",
        "test",
        "test",
        "test",
        "Finalizado"
    )
)