package by.softteco.nmisko.testforsoftteco.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.softteco.nmisko.domain.model.Post
import by.softteco.nmisko.testforsoftteco.databinding.FragmentItemBinding


class MyItemRecyclerViewAdapter(private val onPostItemClickListener: OnPostItemClickListener) :
    RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    private lateinit var postList: ArrayList<Post>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = postList[position]
        holder.id.text = item.id.toString()
        holder.title.text = item.title

        holder.itemView.setOnClickListener {
            onPostItemClickListener.onItemClick(item.id, item.userId)
        }
    }

    override fun getItemCount(): Int = postList.size

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val id: TextView = binding.itemNumber
        val title: TextView = binding.itemTitle

    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: ArrayList<Post>) {
        postList = list
        notifyDataSetChanged()
    }

}

interface OnPostItemClickListener {
    fun onItemClick(postId: Int, userId: Int)
}

