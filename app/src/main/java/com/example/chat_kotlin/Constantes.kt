package com.example.chat_kotlin


import android.icu.util.Calendar
import android.text.format.DateFormat
import java.util.Locale
import java.text.SimpleDateFormat
import java.util.Date

object Constantes {

    fun obtenerTiempo() : Long{
        return System.currentTimeMillis()
    }


    fun formatoFecha(tiempo: Long): String {
        val formato = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return formato.format(Date(tiempo))
    }
}
