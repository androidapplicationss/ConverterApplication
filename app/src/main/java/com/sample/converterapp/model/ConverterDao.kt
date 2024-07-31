package com.sample.converterapp.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ConverterDAO {
    @Insert
    suspend fun InsertResult(conversionResult: ConversionResult)

    @Delete
    suspend fun deleteResult(conversionResult: ConversionResult)

    @Query("Delete from result_table")
    suspend fun deleteAll()

    @Query("Select * from result_table")
    fun getResults(): Flow<List<ConversionResult>>

}