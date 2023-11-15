package com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.pages.newtour

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.R
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.components.ButtonItem
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.components.CustomTextArea
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.components.HeaderComponent
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.components.TextFieldItem

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnrememberedMutableState")
@Composable
fun NewTourPage(
    onCreateButtonClicked: () -> Unit,
    onCancelButtonClicked: () -> Unit,
) {
    val backgroundImage = painterResource(id = R.drawable.back_ground)
    var tourName by remember { mutableStateOf("") }
    var tourGuide by remember { mutableStateOf("") }
    var tourTime by remember { mutableStateOf("") }
    var tourDate by remember { mutableStateOf("") }
    var tourDuration by remember { mutableStateOf("") }
    var tourQuota by remember { mutableStateOf("") }
    var tourDescription by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = backgroundImage,
            contentDescription = "Background Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        LazyColumn {
            stickyHeader {
                HeaderComponent(text = "Nuevo tour")
            }
            item {
                Column(
                    modifier = Modifier.fillMaxWidth(), // Opcional: llena el ancho disponible
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextFieldItem(text = R.string.name,
                        value = tourName,
                        onValueChange = { newTourName ->
                            tourName = newTourName
                        })
                    TextFieldItem(text = R.string.guide,
                        value = tourGuide,
                        onValueChange = { newTourGuide ->
                            tourGuide = newTourGuide
                        })
                    TextFieldItem(text = R.string.time,
                        value = tourTime,
                        onValueChange = { newTourTime ->
                            tourTime = newTourTime
                        })
                    TextFieldItem(text = R.string.date,
                        value = tourDate,
                        onValueChange = { newTourDate ->
                            tourDate = newTourDate
                        })
                    TextFieldItem(text = R.string.duration,
                        value = tourDuration,
                        onValueChange = { newTourDuration ->
                            tourDuration = newTourDuration
                        })
                    TextFieldItem(text = R.string.price,
                        value = tourQuota,
                        onValueChange = { newTourQuota ->
                            tourQuota = newTourQuota
                        })
                    TextFieldItem(text = R.string.quota,
                        value = tourDescription,
                        onValueChange = { newTourQuota ->
                            tourDescription = newTourQuota
                        })
                    CustomTextArea(text = text) {
                        text = it
                    }
                    ButtonItem(
                        text = "Crear",
                        onClickFunction = onCreateButtonClicked
                    )
                    ButtonItem(
                        text = "Cancelar",
                        onClickFunction = onCancelButtonClicked
                    )
                }


            }
        }

    }
}