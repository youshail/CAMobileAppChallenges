package com.example.camobileappchallenges.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import com.example.camobileappchallenges.data.remote.dto.Account
import com.example.camobileappchallenges.presentation.helper.AccordionModel
import com.example.camobileappchallenges.presentation.ui.theme.Tertiary

@Composable
fun AccordionGroup(modifier: Modifier = Modifier, group: List<AccordionModel>, onItemClick: (Account) -> Unit) {
    Column(modifier = modifier) {
        group.forEach {
            Accordion(model = it, onItemClick = onItemClick)
        }
    }
}

@Composable
fun Accordion(modifier: Modifier = Modifier, model: AccordionModel, onItemClick: (Account) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val balance = String.format("%.2f", model.rows.sumOf { it.balance })
    Column {
        AccordionHeader(title = model.header, balance = balance, isExpanded = expanded) {
            expanded = !expanded
        }
        //Divider(color = Tertiary, thickness = 1.dp)
        AnimatedVisibility(
            visible = expanded,
            modifier = modifier) {
                LazyColumn {
                    items(model.rows) { row ->
                        AccordionRow(row, onItemClick = onItemClick)
                    }
                }

        }
    }
}