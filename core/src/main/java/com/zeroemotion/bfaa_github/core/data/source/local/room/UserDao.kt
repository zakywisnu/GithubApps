package com.zeroemotion.bfaa_github.core.data.source.local.room

import android.database.Cursor
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zeroemotion.bfaa_github.core.data.source.local.entity.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: UserEntity): Long

    @Query("delete from userentity where id = :id")
    fun deleteUser(id: Int): Int

    @Query("select * from userentity order by login ASC")
    fun getAllUsers(): Cursor

    @Query("select * from userentity where id = :id")
    fun getUserById(id: Int): Cursor

}