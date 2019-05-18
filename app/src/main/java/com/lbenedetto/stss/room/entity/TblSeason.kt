package com.lbenedetto.stss.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
@ForeignKey(
    entity = TblSeries::class,
    parentColumns = ["id"],
    childColumns = ["seriesId"]
)
data class TblSeason(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo val seriesId: Int,
    @ColumnInfo val seasonNumber: Int,
    @ColumnInfo val episodes: Int
)