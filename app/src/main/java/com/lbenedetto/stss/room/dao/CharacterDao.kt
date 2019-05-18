package com.lbenedetto.stss.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.lbenedetto.stss.room.entity.TblCharacter

@Dao
interface CharacterDao {
    @Query("SELECT * FROM TblCharacter")
    fun getAll(): List<TblCharacter>

    @Query("SELECT * FROM TblCharacter WHERE id IN (:seriesIds)")
    fun loadAllByIds(seriesIds: IntArray): List<TblCharacter>

    @Query("SELECT * FROM TblCharacter WHERE scriptName LIKE :search OR actualName LIKE :search")
    fun searchByName(search: String): List<TblCharacter>

    @Query("SELECT * FROM TblCharacter WHERE scriptName = :scriptName")
    fun findByScriptName(scriptName: String): List<TblCharacter>

    @Query("SELECT * FROM TblCharacter WHERE actualName = :actualName")
    fun findByActualName(actualName: String): List<TblCharacter>

    @Insert
    fun insertAll(vararg TblCharacter: TblCharacter)

    @Delete
    fun delete(TblCharacter: TblCharacter)
}