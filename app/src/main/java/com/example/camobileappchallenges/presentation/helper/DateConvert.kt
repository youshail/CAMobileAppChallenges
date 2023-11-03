package com.example.camobileappchallenges.presentation.helper


import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date


@SuppressLint("SimpleDateFormat")
fun getDateTime(s: String): String? {
    return try {
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val netDate = Date(s.toLongOrNull()!! * 1000)
        sdf.format(netDate)
    } catch (e: Exception) {
        e.toString()
    }
}