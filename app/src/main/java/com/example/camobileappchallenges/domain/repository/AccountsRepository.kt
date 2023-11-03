package com.example.camobileappchallenges.domain.repository

import com.example.camobileappchallenges.data.remote.dto.ListAccountsDto


/*
  this is our repository
 */


interface AccountsRepository {

    suspend fun getAccounts():ListAccountsDto
}