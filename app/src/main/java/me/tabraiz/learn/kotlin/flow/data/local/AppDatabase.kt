package me.tabraiz.learn.kotlin.flow.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import me.tabraiz.learn.kotlin.flow.data.local.dao.UserDao
import me.tabraiz.learn.kotlin.flow.data.local.entity.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}