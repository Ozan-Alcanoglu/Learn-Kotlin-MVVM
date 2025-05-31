package com.ozan.kotlinclass.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ozan.kotlinclass.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstPage(onContinueClicked:()->Unit) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ana Sayfa") },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White
                )
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(padding)
        ) {
            var isim by remember { mutableStateOf("") }
            var soyisim by remember { mutableStateOf("") }
            var şifre by remember { mutableStateOf("") }

            OutlinedTextField(
                value = isim,
                onValueChange = { newText -> isim = newText },
                label = { Text("Adınızı girin") },
                singleLine = true,
                shape = RoundedCornerShape(
                    topEnd = 8.dp,
                ),
                modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp, horizontal = 16.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Blue,
                    unfocusedBorderColor = Color.Gray
                )

            )

            OutlinedTextField(
                value = soyisim,
                onValueChange = { newText -> soyisim = newText },
                label = { Text("Soyadınızı girin") },
                singleLine = true,
                shape = RoundedCornerShape(
                    topEnd = 8.dp,
                ),
                modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp, horizontal = 16.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Blue,
                    unfocusedBorderColor = Color.Gray
                )

            )

            OutlinedTextField(
                value = şifre,
                onValueChange = { newText -> şifre = newText },
                label = { Text("Şifrenizi girin") },
                singleLine = true,
                shape = RoundedCornerShape(
                    topEnd = 8.dp,
                ),
                modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp, horizontal = 16.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Blue,
                    unfocusedBorderColor = Color.Gray
                )

            )

            Spacer(modifier = Modifier.weight(1f))

            Button(modifier = Modifier.fillMaxWidth().padding(16.dp), onClick = {onContinueClicked()}) {
                Text("Devam et")
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun Test() {
//    FirstPage()
//}
