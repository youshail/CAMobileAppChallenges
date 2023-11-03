package com.example.camobileappchallenges.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.camobileappchallenges.presentation.helper.AccordionModel
import com.example.camobileappchallenges.presentation.ui.theme.LocalSpacing
import com.example.camobileappchallenges.presentation.ui.theme.Tertiary


@Preview
@Composable
fun AccordionHeader(
    title: String="Header",
    balance: String="",
    isExpanded: Boolean = false,
    onTapped: () -> Unit = {}
) {
    val degrees = if (isExpanded) 180f else 0f
    val spacing = LocalSpacing.current


    Surface(
        color = White,
    ) {
        Row(
            modifier = Modifier
                .clickable { onTapped() }
                .padding(vertical = spacing.spaceSmall, horizontal = spacing.spaceMedium),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(title, Modifier.weight(1f).padding(start = spacing.spaceMedium))
            Text(
                text = "$balance €",
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
                style = MaterialTheme.typography.body2,
                color = Tertiary
            )
            Icon(
                Icons.Default.KeyboardArrowDown,
                contentDescription = "arrow-down",
                modifier = Modifier.rotate(degrees),
                tint = Gray
            )
        }
    }
}