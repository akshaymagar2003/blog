package com.example.blog

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.blog.models.Blog
import kotlin.reflect.KFunction2


class BlogAdapter(private val onItemClick: KFunction2<Context, Blog, Unit>) : RecyclerView.Adapter<BlogAdapter.PostViewHolder>() {

    private val orderList = ArrayList<Blog>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_post,
            parent, false
        )
        return PostViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return orderList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentOrder = orderList[position]
        holder.bind(currentOrder)
    }

    fun updateOrderList(orderList: List<Blog>) {
        this.orderList.clear()
        this.orderList.addAll(orderList)
        notifyDataSetChanged()
    }

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val postTitle: TextView = itemView.findViewById(R.id.postTitle)
        private val postauthor: TextView = itemView.findViewById(R.id.author)

        fun bind(blog: Blog) {
            postTitle.text = blog.title?.rendered ?: "No Title"
            val authorId = blog.author?: "Null"
            postauthor.text = "Author ID - $authorId"
            val context = itemView.context
            itemView.setOnClickListener {
                onItemClick(context,blog)
            }
        }
    }
}

