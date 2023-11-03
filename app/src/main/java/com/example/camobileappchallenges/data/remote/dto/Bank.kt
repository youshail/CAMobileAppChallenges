package com.example.camobileappchallenges.data.remote.dto

data class Bank(
    val accounts: List<Account>,
    val isCA: Int,
    val name: String
)

