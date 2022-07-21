package com.petron.navegacionjetpackcompose

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.petron.navegacionjetpackcompose.ui.theme.NavegacionJetpackComposeTheme

@Composable
fun AddNotePage(){

    Text(text = "Add Note Page Testing")
}

@Preview
@Composable
fun previewAddNotePage(){
    NavegacionJetpackComposeTheme {
        AddNotePage()
    }
}