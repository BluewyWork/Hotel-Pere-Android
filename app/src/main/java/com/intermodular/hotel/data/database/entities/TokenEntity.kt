package com.intermodular.hotel.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "token_table")
data class TokenEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "token") val token: String
)

fun TokenEntity.toDatabase() = TokenEntity(
    token = token
)