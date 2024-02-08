package com.intermodular.hotel.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.intermodular.hotel.data.database.entities.TokenEntity

@Dao
interface TokenDao {
    @Query("SELECT * FROM token_table")
    fun getOne(): TokenEntity

    @Query("DELETE FROM token_table")
    fun clearAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOne(tokenEntity: TokenEntity)
}