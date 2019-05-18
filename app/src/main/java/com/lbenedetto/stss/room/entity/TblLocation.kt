package com.lbenedetto.stss.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TblLocation(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "locationName") val locationName: String
)