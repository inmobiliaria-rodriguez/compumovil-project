package com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.pages.user

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.model.Tour
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.components.HeaderComponent
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.components.UserTourItemComponent
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.utils.tourList

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListOfTours(
    onInscriptionButtonClicked: () -> Unit
) {
    val TestTours = tourList(context = LocalContext.current);
    LazyColumn {
        stickyHeader {
            HeaderComponent(text = "Tours Disponibles")
        }
        itemsIndexed(TestTours){ index, tour ->
            UserTourItemComponent(
                tour,
                index,
                onInscriptionTextClicked = onInscriptionButtonClicked,
                modifier = Modifier
                    .padding(8.dp))
        }
    }
}
