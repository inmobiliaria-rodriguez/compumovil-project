package com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.pages.login

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.model.User
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.components.ButtonItem
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.components.HeaderComponent
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.components.TextFieldItem
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.utils.DatabaseFunctions
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.utils.LoginFunctions

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LoginPage(
    loggObj: LoginFunctions,
    onSuccessLogin: () -> Unit,
    onRegisterButtonClicked: () -> Unit,
) {
    val context = LocalContext.current
    val backgroundImage = painterResource(id = R.drawable.back_ground)
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = backgroundImage,
            contentDescription = "Background Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        LazyColumn {
            stickyHeader {
                HeaderComponent(text = "Trip With Us")
            }
            item {
                Spacer(modifier = Modifier.height(150.dp)) // Espacio vertical de 32 píxeles

                Column {
                    Row {
                        TextFieldItem(
                            text = R.string.user_email,
                            value = email,
                            onValueChange = { newEmail ->
                                email = newEmail
                            }
                        )
                    }
                    Row {
                        TextFieldItem(
                            text = R.string.user_password,
                            value = password,
                            onValueChange = { newPassword ->
                                password = newPassword
                            }
                        )
                    }
                }
                Spacer(modifier = Modifier.height(60.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        ButtonItem(
                            text = "Ingresar",
                            onClickFunction = {
                                loggObj.logInToTheApp(context, email, password, onSuccessLogin)
                            }
                        )
                    }
                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        ButtonItem(
                            text = "Registrate",
                            onClickFunction = onRegisterButtonClicked
                        )
                    }
                }
            }
        }

    }
}






