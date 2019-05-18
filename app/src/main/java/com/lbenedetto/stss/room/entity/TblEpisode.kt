package com.lbenedetto.stss.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = TblSeries::class,
            parentColumns = ["id"],
            childColumns = ["seriesId"]
        ),
        ForeignKey(
            entity = TblSeason::class,
            parentColumns = ["id"],
            childColumns = ["seasonId"]
        )
    ]
)
class TblEpisode(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo val seriesId: Int,
    @ColumnInfo val seasonId: Int,
    @ColumnInfo val episodeNumber: String,
    @ColumnInfo val episodeName: String
)