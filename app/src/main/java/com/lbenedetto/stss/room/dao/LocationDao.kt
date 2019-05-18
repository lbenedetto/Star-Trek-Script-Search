package com.lbenedetto.stss.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.lbenedetto.stss.room.entity.TblLocation

@Dao
interface LocationDao {
    @Query("SELECT * FROM TblLocation")
    fun getAll(): List<TblLocation>

    @Query("SELECT * FROM TblLocation WHERE id IN (:seriesIds)")
    fun loadAllByIds(seriesIds: IntArray): List<TblLocation>

    @Query("SELECT * FROM TblLocation WHERE locationName LIKE :search")
    fun searchByName(search: String): List<TblLocation>

    @Query("SELECT * FROM TblLocation WHERE locationName = :locationName")
    fun findByName(locationName: String): List<TblLocation>

    @Insert
    fun insertAll(vararg TblLocation: TblLocation)

    @Delete
    fun delete(TblLocation: TblLocation)
}