package com.lbenedetto.stss.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.lbenedetto.stss.room.entity.TblSeason

@Dao
interface SeasonDao {
    @Query("SELECT * FROM TblSeason")
    fun getAll(): List<TblSeason>

    @Query("SELECT * FROM TblSeason WHERE id IN (:seasonIds)")
    fun loadAllByIds(seasonIds: IntArray): List<TblSeason>

    @Query("SELECT * FROM TblSeason WHERE seriesId LIKE :seriesId")
    fun loadAllBySeries(seriesId: Int): List<TblSeason>

    @Insert
    fun insertAll(vararg tblSeason: TblSeason)

    @Delete
    fun delete(tblSeason: TblSeason)
}