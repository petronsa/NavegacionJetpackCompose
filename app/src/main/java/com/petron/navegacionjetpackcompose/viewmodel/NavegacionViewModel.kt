package com.petron.navegacionjetpackcompose.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.petron.navegacionjetpackcompose.data.Note

//Esto es una clase
class NavegacionViewModel: ViewModel() {

    val notes = mutableStateListOf<Note>()

}