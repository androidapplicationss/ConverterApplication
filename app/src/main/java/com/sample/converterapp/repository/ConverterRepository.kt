package com.sample.converterapp.repository

import com.sample.converterapp.model.ConversionResult
import kotlinx.coroutines.flow.Flow

interface ConverterRepository {
    suspend fun insertResult(result: ConversionResult)
    suspend fun deleteResult(result: ConversionResult)
    suspend fun deleteAllResult ()
    fun getResults(): Flow<List<ConversionResult>>
}