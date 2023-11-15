package com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.pages.agency

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.model.Tour
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.components.AgencyTourItemComponent
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.components.HeaderComponent
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.utils.tourList

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListOfMyTours(
    onNewTourClicked: () -> Unit,
) { //items: List<Tour>
    val TestTours = tourList(context = LocalContext.current);
    Log.d("ToString", TestTours.toString())
    LazyColumn {
        stickyHeader {
            HeaderComponent(
                text = "Mis Tours",
                buttonText = "+Tour",
                onNewTourClicked = onNewTourClicked
            )
        }
        itemsIndexed(TestTours){ index, tour ->
            AgencyTourItemComponent(
                tour,
                index,
                modifier = Modifier
                    .padding(8.dp))
        }
    }
}

