package com.sample.converterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sample.converterapp.model.ConverterDatabase
import com.sample.converterapp.repository.ConverterRepository
import com.sample.converterapp.repository.ConverterRepositoryImpl
import com.sample.converterapp.screens.BaseScreen
import com.sample.converterapp.ui.theme.ConverterAppTheme
import com.sample.converterapp.viewModel.ConverterViewModel
import com.sample.converterapp.viewModel.ConverterViewModelFactory

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dao = ConverterDatabase.getInstance(applicationContext).converterDAO
        val repositoryImpl = ConverterRepositoryImpl(dao)
        val factory = ConverterViewModelFactory(repositoryImpl)
        setContent {
            ConverterAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BaseScreen(factory = factory)
                }
            }
        }
    }
}

