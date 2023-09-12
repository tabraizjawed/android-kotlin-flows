package me.tabraiz.learn.kotlin.flow.data.local

import kotlinx.coroutines.flow.Flow
import me.tabraiz.learn.kotlin.flow.data.local.entity.User

interface DatabaseHelper {

    fun getUsers(): Flow<List<User>>

    fun insertAll(users: List<User>): Flow<Unit>

}