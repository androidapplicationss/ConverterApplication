package com.sample.converterapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.converterapp.model.Conversion
import com.sample.converterapp.model.ConversionResult
import com.sample.converterapp.repository.ConverterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ConverterViewModel(private val repository: ConverterRepository): ViewModel() {
    fun  getConversions()  = listOf(
        Conversion(1,"Pounds to kilogram", "Lbs","Kg", 0.45343),
        Conversion(2,"Kilogram to Pounds", "Kg","lbs", 2.20462),
        Conversion(3,"Yard to Meter", "yd","m", 0.9144),
        Conversion(4,"Meter to Yard", "m","yd", 1.09361),
        Conversion(5,"Miles to Kilometer", "mi","km", 1.60934),
        Conversion(6,"Kilometer to Miles", "km","mi", 0.621371)
    )

    val finalResult = repository.getResults()

    fun addResult(message1: String,message2: String){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertResult(ConversionResult(0,message1,message2))
        }

    }
    fun deleteItem(item:ConversionResult){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteResult(item)
        }
    }

    fun deleteALlItem(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllResult()
        }
    }
}