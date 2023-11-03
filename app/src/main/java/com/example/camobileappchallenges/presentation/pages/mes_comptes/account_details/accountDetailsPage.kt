package com.example.camobileappchallenges.presentation.pages.mes_comptes.account_details

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.camobileappchallenges.presentation.components.OperationItem
import com.example.camobileappchallenges.presentation.pages.mes_comptes.accounts_list.AccountsListViewModel
import com.example.camobileappchallenges.presentation.ui.theme.LocalSpacing
import com.example.camobileappchallenges.presentation.ui.theme.OnTertiary


@Composable
fun AccountDetailsPage(
    viewModel: AccountsListViewModel,
    onNavigateUp: () -> Unit,

    ){
    val spacing = LocalSpacing.current
    val account = viewModel.account

    LaunchedEffect(key1 = account){
        if (account!=null){
            Log.d("AccountDetailsPage",account.label)
            Log.d("AccountDetailsPage",account.id)
        }
    }
    Box(modifier = Modifier
        .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.secondary)
        ) {
            Row(
                Modifier
                    .padding(spacing.spaceSmall)
                    .clickable {
                        onNavigateUp()
                    },
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    Icons.Default.KeyboardArrowLeft,
                    contentDescription = "arrow-left",
                    tint = OnTertiary,
                    modifier = Modifier
                        .size(40.dp)
                )
                Text(
                    "Mes comptes",
                    Modifier
                        .weight(1f)
                        .padding(start = spacing.spaceExtraSmall)
                    ,
                    color = OnTertiary,
                    style = MaterialTheme.typography.h5

                )
            }
            Spacer(modifier = Modifier.height(spacing.spaceMedium))

            Text(
                text = account?.balance.toString() + " €",
                style = MaterialTheme.typography.h3,
                modifier = Modifier.align(
                    Alignment.CenterHorizontally
                ),
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            account?.let {
                Text(
                    text = it.label,
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.align(
                        Alignment.CenterHorizontally
                    ),
                )
            }
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            account?.operations?.forEach { operation ->
                OperationItem(operation)
            }

        }
    }
}