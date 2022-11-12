package com.example.paginationjetpack

import com.example.paginationjetpack.model.ListItem
import kotlinx.coroutines.delay

class Repository {

    private val remoteDataSource = (1..200).map {
        ListItem(title = "Item $it", description = "description $it")
    }


    suspend fun getItems(page: Int, pageSize: Int): Result<List<ListItem>> {
        delay(2000L)
        val startingIndex = page * pageSize
        return if (startingIndex + pageSize <= remoteDataSource.size) {
            Result.success(remoteDataSource.slice(startingIndex until startingIndex + pageSize))
        } else {
            Result.success(emptyList())
        }
    }
}