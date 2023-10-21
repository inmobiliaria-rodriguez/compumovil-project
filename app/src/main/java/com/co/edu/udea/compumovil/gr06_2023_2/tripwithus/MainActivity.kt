package com.co.edu.udea.compumovil.gr06_2023_2.tripwithus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.model.Tour
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.pages.agency.ListOfMyTours
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.pages.newtour.NewTourPage
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.pages.user.ListOfTours
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.pages.user.MapsRoute
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.theme.TripWithUsTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripWithUsTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = TripWithUsTheme.colors.uiBackground) {
                    //NewTourPage()
                    //RegisterPage()
                    //LoginPage()
                    ListOfMyTours()
                    //ListOfTours()
                    //MapsRoute()
                }
            }
        }
    }
}
