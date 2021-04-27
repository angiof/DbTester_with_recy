package com.example.dbtester.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface DaoRicette {
    @Query("SELECT * FROM ricette")
    suspend fun getAll(): List<RicettaEntity>

    @Insert
    suspend fun insertAll(vararg ricetta: RicettaEntity)

    @Delete
    suspend fun delete(vararg ricetta: RicettaEntity)
}