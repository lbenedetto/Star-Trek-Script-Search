package com.lbenedetto.stss.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.lbenedetto.stss.room.entity.TblDialog

@Dao
interface DialogDao {
    @Query("SELECT * FROM TblDialog")
    fun getAll(): List<TblDialog>

    @Query("SELECT * FROM TblDialog WHERE id IN (:dialogIds)")
    fun loadAllByIds(dialogIds: IntArray): List<TblDialog>

    @Query("SELECT * FROM TblDialog WHERE seriesId IN (:seriesIds)")
    fun loadAllBySeries(seriesIds: IntArray): List<TblDialog>

    @Query("SELECT * FROM TblDialog WHERE seasonId IN (:seasonIds)")
    fun loadAllBySeasons(seasonIds: IntArray): List<TblDialog>

    @Query("SELECT * FROM TblDialog WHERE episodeId IN (:episodeIds)")
    fun loadAllByEpisodes(episodeIds: IntArray): List<TblDialog>

    @Query("SELECT * FROM TblDialog WHERE locationId IN (:locationIds)")
    fun loadAllByLocations(locationIds: IntArray): List<TblDialog>

    @Query("SELECT * FROM TblDialog WHERE sceneId IN (:sceneIds)")
    fun loadAllByScenes(sceneIds: IntArray): List<TblDialog>

    @Insert
    fun insertAll(vararg tblDialog: TblDialog)

    @Delete
    fun delete(tblDialog: TblDialog)
}