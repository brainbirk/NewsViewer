package dk.shantech.newsviewer.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dk.shantech.newsviewer.data.model.Article
import dk.shantech.newsviewer.databinding.ItemMainBinding

class MainRecyclerViewAdaptor() : ListAdapter<Article, MainRecyclerViewAdaptor.MainViewHolder> (ArticleDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMainBinding.inflate(inflater)
        return MainViewHolder(binding)
    }

    inner class MainViewHolder(private val binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(viewModel: MainItemViewModel) {
            binding.viewModel = viewModel
        }
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = getItem(position)
//        holder.bind(item)
    }

    class ArticleDiffCallback : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

}