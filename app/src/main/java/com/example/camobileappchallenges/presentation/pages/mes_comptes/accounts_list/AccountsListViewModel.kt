package com.example.camobileappchallenges.presentation.pages.mes_comptes.accounts_list

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.camobileappchallenges.common.Resource
import com.example.camobileappchallenges.data.remote.dto.Account
import com.example.camobileappchallenges.data.remote.dto.Operation
import com.example.camobileappchallenges.domain.use_case.GetAccountsUseCase
import com.example.camobileappchallenges.presentation.helper.getDateTime
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/*
   we create view model called Accounts List View Model and we inject the dependency
   in this case we inject our use case
 */

@HiltViewModel
class AccountsListViewModel @Inject constructor(
    private val getAccountsUseCase: GetAccountsUseCase
): ViewModel(){

    private val _state = mutableStateOf(AccountsListState())
    val state : State<AccountsListState> = _state

    var account by mutableStateOf<Account?>(null)
    private set

    init {
        getUsers()
    }

    fun updateAccount(newAccount: Account){

        val accountFormattedDate = newAccount.copy(operations = newAccount.operations.map { it.copy(
            date = getDateTime(it.date!!)
        )})
        account = accountFormattedDate.copy(operations = accountFormattedDate.
        operations.sortedWith(
            compareByDescending<Operation> { it.date }.thenBy { it.title }
        ))

    }

    private fun getUsers(){
        getAccountsUseCase().onEach {result ->

            when(result){
                is Resource.Success ->{
                    _state.value = AccountsListState(
                        listAccounts = result.data
                    )
                }
                is Resource.Error -> {
                    _state.value = AccountsListState(
                        error = result.message ?: " An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = AccountsListState(isLoading = true)

                }
            }
        }.launchIn(viewModelScope)
    }

}