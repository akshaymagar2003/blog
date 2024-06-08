package com.example.blog

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.blog.databinding.ActivityMainBinding
import com.example.blog.models.Blog

class MainActivity : AppCompatActivity() {
    private lateinit var postViewModel: PostViewModel
    private lateinit var blogAdapter: BlogAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        blogAdapter = BlogAdapter(::onItemClicked)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.recyclerView.adapter = blogAdapter
        try {
            val apiService = retrofit.create(ApiService::class.java)
            val repository = BlogRepository(apiService)
            val viewModelFactory = PostViewModelFactory(repository)

            postViewModel = ViewModelProvider(this, viewModelFactory).get(PostViewModel::class.java)
        } catch (e: Exception) {
        }


        postViewModel.posts.observe(this, Observer { posts ->
            blogAdapter.updateOrderList(posts)

        })

        postViewModel.loadPosts()

        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1)) {
                    postViewModel.loadPosts()
                }
            }
        })

    }
    private fun onItemClicked(context: Context, item:Blog){
        val intent = Intent(context, BlogDetailActivity::class.java).apply {
                    putExtra("POST_URL", item.link)
                }
                context.startActivity(intent)
    }

}
