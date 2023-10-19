package com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.pages.register

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.R
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.components.ButtonItem
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.components.HeaderComponent
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.components.RadioButtonComponent
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.components.TextFieldItem

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RegisterPage() {
    val backgroundImage = painterResource(id = R.drawable.back_ground)
    val context = LocalContext.current
    var selectedUserOption = mutableStateOf("")
    var userName by remember { mutableStateOf("") }
    var document by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var userPassword by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = backgroundImage,
            contentDescription = "Background Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        LazyColumn {
            stickyHeader {
                HeaderComponent(text = "¡Regístrate!")
            }
            item {
                Column(
                    modifier = Modifier.fillMaxWidth(), // Opcional: llena el ancho disponible
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    RadioButtonComponent(
                        selectedUserOption = selectedUserOption, context = context
                    )
                    TextFieldItem(text = R.string.name,
                        value = userName,
                        onValueChange = { newUserName ->
                            userName = newUserName
                        })
                    TextFieldItem(text = R.string.document,
                        value = document,
                        onValueChange = { newDocument ->
                            document = newDocument
                        })
                    TextFieldItem(text = R.string.email,
                        value = email,
                        onValueChange = { newEmail ->
                            email = newEmail
                        })
                    TextFieldItem(text = R.string.password,
                        value = userPassword,
                        onValueChange = { newUserPassword ->
                            userPassword = newUserPassword
                        })
                    ButtonItem(text = "Registrate") {
                        // Acción para el botón Registrate
                    }
                    Spacer(modifier = Modifier.height(40.dp)) // Espacio vertical de 32 píxeles
                    ButtonItem(text = "Volver") {
                        // Acción para el botón Volver
                    }
                }


            }
        }
    }
}