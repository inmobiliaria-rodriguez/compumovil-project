package com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.pages.user

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.model.Tour
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.components.HeaderComponent
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.components.UserTourItemComponent

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListOfTours(items: List<Tour>) { //items: List<Tour>
    LazyColumn {
        stickyHeader {
            HeaderComponent(text = "Tours Disponibles")
        }
        itemsIndexed(TestTours){ index, tour ->
            UserTourItemComponent(
                tour,
                index,
                modifier = Modifier
                    .padding(8.dp))
        }
    }
}

val TestTours = listOf(
    Tour(
        "Rapido Ochoa",
        "Uraba",
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
        "Popayan",
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