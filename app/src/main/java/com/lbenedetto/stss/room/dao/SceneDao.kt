package com.lbenedetto.stss.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.lbenedetto.stss.room.entity.TblScene

@Dao
interface SceneDao {
    @Query("SELECT * FROM TblScene")
    fun getAll(): List<TblScene>

    @Query("SELECT * FROM TblScene WHERE id IN (:seasonIds)")
    fun loadAllByIds(seasonIds: IntArray): List<TblScene>

    @Query("SELECT * FROM TblScene WHERE seriesId IN (:seriesIds)")
    fun loadAllBySeries(seriesIds: IntArray): List<TblScene>

    @Query("SELECT * FROM TblScene WHERE seasonId IN (:seasonIds)")
    fun loadAllBySeasons(seasonIds: IntArray): List<TblScene>

    @Query("SELECT * FROM TblScene WHERE episodeId IN (:episodeIds)")
    fun loadAllByEpisodes(episodeIds: IntArray): List<TblScene>

    @Query("SELECT * FROM TblScene WHERE locationId IN (:locationIds)")
    fun loadAllByLocations(locationIds: IntArray): List<TblScene>

    @Insert
    fun insertAll(vararg tblScene: TblScene)

    @Delete
    fun delete(tblScene: TblScene)
}