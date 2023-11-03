package com.example.camobileappchallenges.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.camobileappchallenges.presentation.pages.a_vous_jouer.AvousJouerPage
import com.example.camobileappchallenges.presentation.pages.mes_comptes.account_details.AccountDetailsPage
import com.example.camobileappchallenges.presentation.pages.mes_comptes.accounts_list.AccountsListViewModel
import com.example.camobileappchallenges.presentation.pages.mes_comptes.accounts_list.AccountsPage
import com.example.camobileappchallenges.presentation.pages.simulation.SimulationPage

@Composable
fun getNavigation(
    navController: NavHostController,
    viewModel: AccountsListViewModel = hiltViewModel(),
) {
    NavHost(navController = navController, startDestination = "mes_comptes") {
        composable("mes_comptes") {
            AccountsPage(navController, viewModel)
        }
        composable("account_detail") {

            AccountDetailsPage(
                onNavigateUp = {
                    navController.popBackStack()
                },
                viewModel = viewModel
            )
        }
        composable("simulation") {
            SimulationPage()
        }
        composable("avous") {
            AvousJouerPage()
        }
    }
}