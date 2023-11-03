package com.example.camobileappchallenges.presentation.pages.mes_comptes.accounts_list

import com.example.camobileappchallenges.data.remote.dto.ListAccountsDto


/*
   data class for state list Account
 */

data class AccountsListState(
    val isLoading : Boolean = false,
    val listAccounts: ListAccountsDto? = null,
    val error : String =""
)