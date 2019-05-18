package com.lbenedetto.stss.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TblSeries(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo val seriesName: String,
    @ColumnInfo val seasons: Int
)