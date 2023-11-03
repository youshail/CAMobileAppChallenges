package com.example.camobileappchallenges.data.repository

import com.example.camobileappchallenges.data.remote.GetListAccountsApi
import com.example.camobileappchallenges.data.remote.dto.ListAccountsDto
import com.example.camobileappchallenges.domain.repository.AccountsRepository
import javax.inject.Inject


/*
   Repository implementation

 */

class AccountRepositoryImp @Inject constructor(
    private val api:GetListAccountsApi
) : AccountsRepository {
    override suspend fun getAccounts(): ListAccountsDto {
        return api.getListAccount()
    }

}