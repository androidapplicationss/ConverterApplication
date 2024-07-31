package com.sample.converterapp.repository

import com.sample.converterapp.model.ConversionResult
import com.sample.converterapp.model.ConverterDAO
import kotlinx.coroutines.flow.Flow

class ConverterRepositoryImpl(private val dao:ConverterDAO):ConverterRepository {
    override suspend fun insertResult(result: ConversionResult) {
        dao.InsertResult(result)
    }

    override suspend fun deleteResult(result: ConversionResult) {
        dao.deleteResult(result)
    }

    override suspend fun deleteAllResult() {
     dao.deleteAll()
    }

    override fun getResults(): Flow<List<ConversionResult>> {
     return dao.getResults()
    }
}