package com.android.movie.ui.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.model.category.Category
import com.android.movie.R
import com.android.movie.databinding.CategoryCardItemBinding

class CategoryAdapter(private val categories: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(private val binding: CategoryCardItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(categoryData: Category) {
            binding.category = categoryData.name
        }
    }

    /**
     * Inflates the item view and creates a ViewHolder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: CategoryCardItemBinding =
            DataBindingUtil.inflate(inflater, R.layout.category_card_item, parent, false)
        return CategoryViewHolder(view)
    }

    /**
     * Returns the total number of items in the list.
     */
    override fun getItemCount(): Int = categories.size

    /**
     * Binds the data to the ViewHolder at the specified position.
     */
    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categoryData = categories[position])
    }
}