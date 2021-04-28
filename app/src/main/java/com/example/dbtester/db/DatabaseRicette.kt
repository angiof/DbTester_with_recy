package com.example.dbtester.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [RicettaEntity::class], version = 1)
abstract class DatabaseRicette : RoomDatabase() {
    abstract fun DaoRicette(): DaoRicette

    companion object {
        @Volatile
        private var instance: DatabaseRicette? = null
        private val LOCK =Any()

        operator fun invoke(context: Context)=instance?: synchronized(LOCK){
            instance ?: buildDatabase(context).also{instance =it}
        }

        private fun buildDatabase(context: Context)= Room.databaseBuilder(context,DatabaseRicette::class.java,"persons").build()
    }
}

