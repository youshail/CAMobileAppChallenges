package com.example.camobileappchallenges.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.camobileappchallenges.data.remote.dto.Operation
import com.example.camobileappchallenges.presentation.ui.theme.LocalSpacing
import com.example.camobileappchallenges.presentation.ui.theme.Tertiary

@Preview
@Composable
fun OperationItem(
    model: Operation = Operation(
        amount = "-1,99",
        category = "costs",
        date = "1644870724",
        id = "1",
        title = "Tenue de compte"
    )
) {
    val spacing = LocalSpacing.current
    Surface(
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = spacing.spaceMedium)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = spacing.spaceSmall),
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f),
                ) {
                    Text(
                        model.title,
                        style = MaterialTheme.typography.body1,
                        color = Tertiary
                    )

                    Text(
                        model.date!!,
                        modifier = Modifier
                            .padding(
                                horizontal = spacing.spaceMedium,
                                vertical = spacing.spaceSmall
                            ),
                        style = MaterialTheme.typography.body1,
                        color = Tertiary
                    )
                }

                Text(
                    text = model.amount.removePrefix("-") + " €",
                    modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
                    style = MaterialTheme.typography.body2,
                    color = Tertiary
                )


            }
            Divider(color = Tertiary, thickness = 1.dp)
        }
    }
}