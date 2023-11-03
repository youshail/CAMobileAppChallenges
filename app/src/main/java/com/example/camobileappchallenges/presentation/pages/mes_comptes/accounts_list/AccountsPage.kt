package com.example.camobileappchallenges.presentation.pages.mes_comptes.accounts_list

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.example.camobileappchallenges.R
import com.example.camobileappchallenges.presentation.components.AccordionGroup
import com.example.camobileappchallenges.presentation.helper.AccordionModel
import com.example.camobileappchallenges.presentation.navigation.Route
import com.example.camobileappchallenges.presentation.ui.theme.LocalSpacing
import com.example.camobileappchallenges.presentation.ui.theme.Tertiary

@SuppressLint("SuspiciousIndentation")
@Composable
fun AccountsPage(
    navController: NavHostController,
    viewModel: AccountsListViewModel,

    ) {
    val state = viewModel.state.value
    val groupCA = mutableListOf<AccordionModel>()
    val groupAutre = mutableListOf<AccordionModel>()
    val spacing = LocalSpacing.current


    Box(modifier = Modifier.fillMaxSize()) {

        state.listAccounts?.let { listAccount ->

            listAccount.forEach { banks ->
                if (banks.isCA == 1) {
                    groupCA.add(AccordionModel(banks.name, banks.accounts))
                } else {
                    groupAutre.add(AccordionModel(banks.name, banks.accounts))
                }
            }

            Column(
                modifier = Modifier.background(MaterialTheme.colors.secondary)
            ) {
                Spacer(modifier = Modifier.height(spacing.spaceMedium))
                Text(
                    text = stringResource(id = R.string.title),
                    style = MaterialTheme.typography.h3,
                    modifier = Modifier.padding(horizontal = spacing.spaceMedium),
                    fontWeight = FontWeight.Bold
                )

                Row {
                    Text(
                        text = stringResource(id = R.string.Credit_Agricole),
                        style = MaterialTheme.typography.h6,
                        color = Tertiary,
                        modifier = Modifier
                            .weight(1f)
                            .padding(
                                horizontal = spacing.spaceSmall,
                                vertical = spacing.spaceSmall
                            )
                    )
                }

                AccordionGroup(modifier = Modifier.padding(top = spacing.spaceMedium), group = groupCA,onItemClick = { account ->
                    viewModel.updateAccount(account)
                    navController.navigate(Route.ACCOUNTDETAIL)
                })

                Row{
                    Text(
                        text = stringResource(id = R.string.autre),
                        style = MaterialTheme.typography.h6,
                        color = Tertiary,
                        modifier = Modifier
                            .weight(1f)
                            .padding(
                                horizontal = spacing.spaceSmall,
                                vertical = spacing.spaceExtraSmall
                            )
                    )
                }
                AccordionGroup(modifier = Modifier.padding(top = spacing.spaceMedium), group = groupAutre,onItemClick = { account ->
                     viewModel.updateAccount(account)
                    navController.navigate(Route.ACCOUNTDETAIL)
                })
            }
        }

        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = spacing.spaceLarge)
                    .align(Alignment.Center)
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
    }


}