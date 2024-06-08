package com.example.blog

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.blog.models.Blog
import kotlin.reflect.KFunction2

//class BlogAdapter : ListAdapter<Blog, BlogAdapter.PostViewHolder>(DiffCallback()) {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
//
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
//        return PostViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
//        val post = getItem(position)
//        holder.bind(post)
//
//    }
//
//    private fun onItemClick(post: Blog?) {
//
//    }
//
//    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        private val postTitle: TextView = itemView.findViewById(R.id.postTitle)
//        private val postauthor: TextView = itemView.findViewById(R.id.author)
//        private var currentPost: Blog? = null
//
//        fun bind(post: Blog) {
//            postTitle.text = post.title?.rendered ?: "No Title"
//            val authorId = post.author?: "Null"
//            postauthor.text = "Author ID - $authorId"
//        }
//
//        override fun onClick(v: View?) {
//            currentPost?.let { post ->
//                val context = itemView.context
//                val intent = Intent(context, BlogDetailActivity::class.java).apply {
//                    putExtra("POST_URL", post.link)  // Assuming your Blog model has a `link` field
//                }
//                context.startActivity(intent)
//            }
//        }}
//    class DiffCallback : DiffUtil.ItemCallback<Blog>() {
//        override fun areItemsTheSame(oldItem: Blog, newItem: Blog): Boolean {
//            return oldItem.id == newItem.id
//        }
//
//        override fun areContentsTheSame(oldItem: Blog, newItem: Blog): Boolean {
//            return oldItem.equals(newItem)
//        }
//    }
//}
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

