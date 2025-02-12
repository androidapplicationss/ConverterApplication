package com.sample.converterapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sample.converterapp.viewModel.ConverterViewModel
import com.sample.converterapp.viewModel.ConverterViewModelFactory

//BaseScreen
@Composable
fun BaseScreen(
    factory: ConverterViewModelFactory,
    modifier: Modifier = Modifier,
    converterViewModel: ConverterViewModel = viewModel(factory= factory)
){
val list = converterViewModel.getConversions()
    val historyResult = converterViewModel.finalResult.collectAsState(initial = emptyList())
    Column(modifier = modifier .padding(30.dp)) {
    TopScreen(list){
        message1,message2 -> converterViewModel.addResult(message1,message2)
    }
        Spacer(modifier = Modifier.height(20.dp))

        HistoryScreen(historyResult,{item->
          converterViewModel.deleteItem(item)
        },{
            converterViewModel.deleteALlItem()
        })
    }
}
