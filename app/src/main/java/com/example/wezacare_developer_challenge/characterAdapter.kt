package com.example.wezacare_developer_challenge

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.wezacare_developer_challenge.databinding.CharacterBinding
import com.example.wezacare_developer_challenge.network_data.Character_

class CharacterAdapter: RecyclerView.Adapter<CharacterAdapter.PostViewHolder>() {
    inner class PostViewHolder(val binding:CharacterBinding): RecyclerView.ViewHolder(binding.root)
    private val differCallback = object:DiffUtil.ItemCallback<Character_>(){
        override fun areItemsTheSame(oldItem: Character_, newItem:Character_): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: Character_, newItem: Character_): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(CharacterBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        ))
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentPost = differ.currentList[position]
        holder.binding.apply {
            itemImage.setImageURI(currentPost.image)
            itemTitle.text = currentPost.name
        }
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, detail_activity::class.java)
            intent.putExtra("my_data", currentPost)
            holder.itemView.context.startActivity(intent)

        }
    }
}