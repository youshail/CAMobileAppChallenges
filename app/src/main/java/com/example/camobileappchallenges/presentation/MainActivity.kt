package com.example.camobileappchallenges.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.camobileappchallenges.presentation.components.BottomNavigationBar
import com.example.camobileappchallenges.presentation.helper.BottomNavItem
import com.example.camobileappchallenges.presentation.navigation.getNavigation
import com.example.camobileappchallenges.presentation.pages.a_vous_jouer.AvousJouerPage
import com.example.camobileappchallenges.presentation.pages.mes_comptes.account_details.AccountDetailsPage
import com.example.camobileappchallenges.presentation.pages.mes_comptes.accounts_list.AccountsListViewModel
import com.example.camobileappchallenges.presentation.pages.mes_comptes.accounts_list.AccountsPage
import com.example.camobileappchallenges.presentation.pages.simulation.SimulationPage
import com.example.camobileappchallenges.presentation.ui.theme.CAMobileAppChallengesTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CAMobileAppChallengesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar(
                                items = listOf(
                                    BottomNavItem(
                                        name = "Mes comptes",
                                        route = "mes_comptes",
                                        icon = Icons.Default.Star
                                    ),
                                    BottomNavItem(
                                        name = "Simulation",
                                        route = "simulation",
                                        icon = Icons.Default.Star,
                                        badgeCount = 0
                                    ),
                                    BottomNavItem(
                                        name = "À vous de jouer",
                                        route = "avous",
                                        icon = Icons.Default.Star,
                                        badgeCount = 0
                                    ),
                                ),
                                navController = navController,
                                onItemClick = {
                                    navController.navigate(it.route)
                                }
                            )
                        }
                    ) {
                        getNavigation(navController = navController)
                    }
                }
            }
        }
    }
}

