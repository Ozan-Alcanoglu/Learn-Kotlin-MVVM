package com.ozan.kotlinclass.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondPage(){

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ana Sayfa") },
                navigationIcon = {
                    IconButton(onClick = { /* geri butonu tıklama */ }) {

                    }
                },
                actions = {
                    IconButton(onClick = { /* sağ aksiyon */ }) {

                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White
                )
            )
        }
    ) { padding->
        Column(modifier = Modifier.fillMaxSize().padding(padding)) {

            var alan by remember { mutableStateOf("") }
            var kıdem by remember { mutableStateOf("") }

            OutlinedTextField(
                value = alan,
                onValueChange ={ newText -> alan = newText },
                label = { Text("Yazılım alanı") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp, horizontal = 16.dp).border( width = 2.dp,
                    color = Color.Blue,
                    shape = RoundedCornerShape(
                        topEnd = 8.dp,
                    )
                )

            )
            OutlinedTextField(
                value = kıdem,
                onValueChange ={ newText -> kıdem = newText },
                label = { Text("Kıdem(junior,mid,senior) alanı") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp, horizontal = 16.dp).border( width = 2.dp,
                    color = Color.Blue,
                    shape = RoundedCornerShape(
                        topEnd = 8.dp,
                    )
                )

            )

            Spacer(modifier = Modifier.weight(1f))

            Button(onClick = {},
                modifier = Modifier.fillMaxWidth().padding(start = 16.dp, top = 16.dp, end = 16.dp,bottom=16.dp),
                shape = RoundedCornerShape(
                        topEnd = 24.dp,
                        bottomStart = 24.dp
                    )
                )
            {
                Text("Kaydet")
            }

        }

    }


}

@Preview(showBackground = true)
@Composable
fun Test2(){
    SecondPage()
}
