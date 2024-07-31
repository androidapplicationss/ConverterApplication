package com.sample.converterapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sample.converterapp.model.ConversionResult

@Composable
fun HistoryScreen(
    historyList: State<List<ConversionResult>>,
    onClose: (ConversionResult) -> Unit,
    onClearAllTask: () -> Unit,
    modifier: Modifier = Modifier
) {

    Column {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "History", color = Color.Red)
            OutlinedButton(onClick = { onClearAllTask() }) {
                Text(text = "Clear All", color = Color.Blue)
            }
        }
        HistoryList(list = historyList, onCloseTask = { item -> onClose(item) })

    }

}