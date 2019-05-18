package com.lbenedetto.stss.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lbenedetto.stss.room.dao.SeasonDao
import com.lbenedetto.stss.room.dao.SeriesDao
import com.lbenedetto.stss.room.entity.TblSeason
import com.lbenedetto.stss.room.entity.TblSeries

//https://stackoverflow.com/questions/49824822/how-do-i-pull-a-room-db-from-my-device
@Database(entities = [TblSeason::class, TblSeries::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun seriesDao(): SeriesDao
    abstract fun seasonDao(): SeasonDao
}