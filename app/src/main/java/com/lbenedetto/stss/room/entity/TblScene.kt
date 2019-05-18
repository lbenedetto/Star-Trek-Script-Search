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
        ),
        ForeignKey(
            entity = TblEpisode::class,
            parentColumns = ["id"],
            childColumns = ["episodeId"]
        ),
        ForeignKey(
            entity = TblLocation::class,
            parentColumns = ["id"],
            childColumns = ["locationId"]
        )
    ]
)
class TblScene(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo val seriesId: Int,
    @ColumnInfo val seasonId: Int,
    @ColumnInfo val episodeId: Int,
    @ColumnInfo val locationId: Int
)