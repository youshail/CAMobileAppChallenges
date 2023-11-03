package com.example.camobileappchallenges.data.remote

import com.example.camobileappchallenges.data.remote.dto.ListAccountsDto
import retrofit2.http.GET

interface GetListAccountsApi {

    @GET("/banks.json")
    suspend fun getListAccount():ListAccountsDto
}