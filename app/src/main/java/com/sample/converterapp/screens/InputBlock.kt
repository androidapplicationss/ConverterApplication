package com.sample.converterapp.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sample.converterapp.model.Conversion

@Composable
fun InputBlock(
    conversion: Conversion,
    inputText: MutableState<String>,
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current.applicationContext,
    calculate: (String) -> Unit
) {
    Column(modifier = modifier.padding(0.dp, 20.dp, 0.dp, 0.dp)) {
        Row(modifier = modifier.fillMaxWidth()) {
            TextField(
                value = inputText.value, onValueChange = { inputText.value = it },
                modifier = modifier.fillMaxWidth(0.65f),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    keyboardType = KeyboardType.Number
                ),
                textStyle = TextStyle(color = Color.Black, fontSize = 20.sp)
            )
            Text(
                text = conversion.convertFrom, fontSize = 24.sp,
                modifier = modifier
                    .fillMaxWidth(0.45f)
                    .padding(10.dp, 20.dp, 0.dp, 0.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))

        }
        OutlinedButton(onClick = {
            if (!inputText.value.equals("")) {
                calculate(inputText.value)
            } else {
                Toast.makeText(context, "Please check input text can`t be empty", Toast.LENGTH_SHORT).show()
            }
        },
            modifier = modifier.fillMaxWidth(1f).padding(10.dp)) {
            Text(text = "Convert", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }
    }
}