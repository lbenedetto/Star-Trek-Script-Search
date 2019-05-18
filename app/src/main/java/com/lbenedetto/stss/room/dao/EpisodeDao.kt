package com.lbenedetto.stss.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.lbenedetto.stss.room.entity.TblDialog
import com.lbenedetto.stss.room.entity.TblEpisode
import com.lbenedetto.stss.room.entity.TblScene

@Dao
interface EpisodeDao {
    @Query("SELECT * FROM TblEpisode")
    fun getAll(): List<TblEpisode>

    @Query("SELECT * FROM TblEpisode WHERE id IN (:episodeIds)")
    fun loadAllByIds(episodeIds: IntArray): List<TblEpisode>

    @Query("SELECT * FROM TblEpisode WHERE seriesId IN (:seriesIds)")
    fun loadAllBySeries(seriesIds: IntArray): List<TblEpisode>

    @Query("SELECT * FROM TblEpisode WHERE seasonId IN (:seasonIds)")
    fun loadAllBySeasons(seasonIds: IntArray): List<TblEpisode>

    @Insert
    fun insertAll(vararg tblEpisode: TblEpisode)

    @Delete
    fun delete(tblEpisode: TblEpisode)
}