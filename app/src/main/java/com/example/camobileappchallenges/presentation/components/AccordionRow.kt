package com.example.camobileappchallenges.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.camobileappchallenges.data.remote.dto.Account
import com.example.camobileappchallenges.presentation.ui.theme.LocalSpacing
import com.example.camobileappchallenges.presentation.ui.theme.Tertiary



@Composable
fun AccordionRow(
    model: Account,
    onItemClick: (Account) -> Unit
) {
    val spacing = LocalSpacing.current
    Surface(
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .padding(start = spacing.spaceExtraLarge)
                .clickable {
                    onItemClick(model)
                    println("Done!!")
                }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = spacing.spaceSmall),
            ) {
                Text(
                    model.label,
                    Modifier
                        .weight(1f),
                    style = MaterialTheme.typography.body1,
                    color = Tertiary
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(2.dp)
                ) {
                    Text(
                        text = model.balance.toString() + " €",
                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
                        style = MaterialTheme.typography.body2,
                        color = Tertiary
                    )
                    Icon(
                        Icons.Default.KeyboardArrowRight,
                        contentDescription = "arrow-down",
                        tint = Color.Gray
                    )
                }

            }
            Divider(color = Tertiary, thickness = 1.dp)
        }
    }
}