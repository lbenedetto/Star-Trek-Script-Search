package com.lbenedetto.stss.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.lbenedetto.stss.room.entity.TblSeries

@Dao
interface SeriesDao {
    @Query("SELECT * FROM TblSeries")
    fun getAll(): List<TblSeries>

    @Query("SELECT * FROM TblSeries WHERE id IN (:seriesIds)")
    fun loadAllByIds(seriesIds: IntArray): List<TblSeries>

    @Query("SELECT * FROM TblSeries WHERE seriesName LIKE :first LIMIT 1")
    fun findByName(first: String, last: String): TblSeries

    @Insert
    fun insertAll(vararg tblSeries: TblSeries)

    @Delete
    fun delete(tblSeries: TblSeries)
}