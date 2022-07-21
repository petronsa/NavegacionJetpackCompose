package com.petron.navegacionjetpackcompose.data

import android.icu.text.CaseMap
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
// Esto es una data Class
@Parcelize
data class Note(var noteIndex: Int, var title: String, var description: String)
    : Parcelable
