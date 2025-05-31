package com.ozan.kotlinclass.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ozan.kotlinclass.model.Joblvl

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondPage(onBackClicked: () -> Unit){

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ana Sayfa") },
                navigationIcon = {
                    IconButton(onClick = { onBackClicked() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Geri Dön"
                        )
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

            val coroutineScope = rememberCoroutineScope()

            var selectedJobLevel by remember { mutableStateOf<Joblvl?>(null) }
            var expanded by remember { mutableStateOf(false) }

            OutlinedTextField(
                value = alan,
                onValueChange ={ newText -> alan = newText },
                label = { Text("Yazılım alanı") },
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
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(2.dp, Color.Blue, RoundedCornerShape(8.dp))
                        .clickable { expanded = true }
                        .padding(16.dp)
                ) {
                    Text(text = selectedJobLevel?.name ?: "Kıdem Seçin")
                }


                DropdownMenu (
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Joblvl.values().forEach { level ->
                        DropdownMenuItem(
                            text = { Text(level.name) },
                            onClick = {
                                selectedJobLevel = level
                                expanded = false
                            }
                        )
                    }
                }
            }

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

//@Preview(showBackground = true)
//@Composable
//fun Test2(){
//    SecondPage()
//}
