package com.example.blog

import android.util.Log
import androidx.lifecycle.*
import com.example.blog.models.Blog
import kotlinx.coroutines.launch

class PostViewModel(private val repository: PostRepository) : ViewModel() {
    private val _posts = MutableLiveData<List<Blog>>()
    val posts: LiveData<List<Blog>> get() = _posts

    private var currentPage = 1
    private val perPage = 10

    fun loadPosts() {
        viewModelScope.launch {
            try {
                val newPosts = repository.fetchPosts(currentPage, perPage)
                val currentPosts = _posts.value ?: emptyList()
                _posts.value = currentPosts + newPosts
                currentPage++
            } catch (e: Exception) {
                Log.d("result567","swah")

            }
        }
    }
}
class PostViewModelFactory(private val repository: PostRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PostViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}