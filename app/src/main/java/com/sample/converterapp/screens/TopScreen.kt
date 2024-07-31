package com.sample.converterapp.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.sample.converterapp.model.Conversion
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun TopScreen(list: List<Conversion>,saveValue:(String,String)->Unit) {
   val selectConversion: MutableState<Conversion?> = remember { mutableStateOf(null) }
   val inputText : MutableState<String> = remember { mutableStateOf("") }
   val typedValue = remember { mutableStateOf("0.0") }
   ConversionMenu(list = list){
      selectConversion.value = it
       typedValue.value = "0.0"
   }

    // if selectedCoversion value is not null
   selectConversion.value?.let {
    InputBlock(conversion = it, inputText = inputText ){input ->
        typedValue.value = input
    }
   }

    if (typedValue.value != "0.0"){
        val input = typedValue.value.toDouble()
        val multiply = selectConversion.value!!.multiplyBy
        val result = input*multiply

        val df = DecimalFormat("#.####")
        df.roundingMode = RoundingMode.DOWN
        val roundedResult = df.format(result)

        val message1 = "${typedValue.value} \t ${selectConversion.value!!.convertFrom} is equals to "
        val message2 = "${roundedResult} ${selectConversion.value!!.convertTo}"
        saveValue(message1,message2)
        ResultBlock(message1 = message1, message2 = message2 )

    }
}