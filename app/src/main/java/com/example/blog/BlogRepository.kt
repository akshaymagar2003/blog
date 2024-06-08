package com.example.blog

import android.util.Log
import com.example.blog.models.Blog

class BlogRepository(private val apiService: ApiService) {
    suspend fun fetchPosts(page: Int, perPage: Int): List<Blog> {
        Log.d("result","${apiService.getPosts(perPage, page)[0].id}")
        return apiService.getPosts(perPage, page)
    }
}