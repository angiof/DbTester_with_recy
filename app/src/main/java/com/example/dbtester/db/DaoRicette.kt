package com.example.dbtester.db

import androidx.room.*


@Dao
interface DaoRicette {
    @Query("SELECT * FROM ricette")
    suspend fun getAll(): Array<RicettaEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg ricetta: RicettaEntity)

    @Delete
    suspend fun delete(vararg ricetta: RicettaEntity)
}