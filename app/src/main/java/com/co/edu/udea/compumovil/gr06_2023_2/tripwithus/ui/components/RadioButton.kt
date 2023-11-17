package com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.components

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.R
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.theme.TripWithUsTheme

@Composable
fun RadioButtonComponent(
    selectedUserOption: MutableState<String>,
    context: Context
) {
    val agencyString = context.getString(R.string.agency)
    val userString = context.getString(R.string.user)
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            UsersRadioButton(selectedUserOption, userString)
            UsersRadioButton(selectedUserOption, agencyString)
        }
    }
}

@Composable
fun UsersRadioButton(selectedUserOption: MutableState<String>, userOption: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selectedUserOption.value == userOption,
            onClick = { selectedUserOption.value = userOption },
            colors = RadioButtonDefaults.colors(TripWithUsTheme.colors.buttonDarkColor)
        )
        Text(userOption)
    }
}
