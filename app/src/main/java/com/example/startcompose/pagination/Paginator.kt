package com.example.startcompose.pagination

interface Paginator<Item, Key> {
    suspend fun loadNextItem()
    fun reset()
}