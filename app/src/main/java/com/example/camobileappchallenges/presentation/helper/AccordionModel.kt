package com.example.camobileappchallenges.presentation.helper

import com.example.camobileappchallenges.data.remote.dto.Account

data class AccordionModel(
    val header: String,
    val rows: List<Account>
)
