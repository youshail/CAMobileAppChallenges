package com.example.camobileappchallenges.domain.use_case

import com.example.camobileappchallenges.common.Resource
import com.example.camobileappchallenges.data.remote.dto.ListAccountsDto
import com.example.camobileappchallenges.domain.repository.AccountsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/*
  This use case well use repository to access our Api
  for that we inject the repository in the constructor

  We override the invoke operator function to get flow from coroutines
  because we want to emit multiple values over period of time
  - Success
  - Loading
  - Error
 */

class GetAccountsUseCase @Inject constructor(
    private val repository: AccountsRepository
) {

    operator fun invoke(): Flow<Resource<ListAccountsDto>> = flow {
        try {
            emit(Resource.Loading())
            val listAccounts = repository.getAccounts()

            listAccounts.sortBy { it.name }
            emit(Resource.Success(listAccounts))

        } catch (e: HttpException) {

            emit(Resource.Error(e.localizedMessage ?: "An unexpected error eccured"))
        } catch (e: IOException) {

            emit(Resource.Error("Check your internet connexion"))
        }
    }


}