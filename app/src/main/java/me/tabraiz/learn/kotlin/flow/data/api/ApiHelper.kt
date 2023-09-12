package me.tabraiz.learn.kotlin.flow.data.api

import kotlinx.coroutines.flow.Flow
import me.tabraiz.learn.kotlin.flow.data.model.ApiUser

interface ApiHelper {

    fun getUsers(): Flow<List<ApiUser>>

    fun getMoreUsers(): Flow<List<ApiUser>>

    fun getUsersWithError(): Flow<List<ApiUser>>

}