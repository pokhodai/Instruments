package com.decorator1889.instruments.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.decorator1889.instruments.R
import com.decorator1889.instruments.databinding.ViewButtonFavoritesBinding
import com.decorator1889.instruments.databinding.ViewCategoryBinding
import com.decorator1889.instruments.glide
import com.decorator1889.instruments.models.Category

class CategoryAdapter(
    private val callback: ICategoryCallback
) : ListAdapter<Category, RecyclerView.ViewHolder>(CategoryDiffUtilCallback()) {

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).viewType) {
            TYPE_BUTTON -> TYPE_BUTTON.hashCode()
            TYPE_CATEGORY -> TYPE_CATEGORY.hashCode()
            else -> {
                throw Exception("Invalid type category")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_BUTTON.hashCode() -> ButtonFavoritesViewHolder.getViewHolder(parent)
            TYPE_CATEGORY.hashCode() -> CategoryViewHolder.getViewHolder(parent)
            else -> throw Exception("Not found view holder type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItem(position).viewType) {
            TYPE_BUTTON -> (holder as ButtonFavoritesViewHolder).bind(
                getItem(position),
                callback
            )
            TYPE_CATEGORY -> (holder as CategoryViewHolder).bind(
                getItem(position),
                callback
            )
        }
    }

    class CategoryViewHolder(
        private val binding: ViewCategoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Category, callback: ICategoryCallback) {
            binding.apply {
                textViewName.text = item.name
                textViewDescription.text = item.description
                imageViewPicture.glide(item.picture)
                if (item.favorite) {
                    materialButtonLike.icon =
                        ContextCompat.getDrawable(root.context, R.drawable.ic_like_active)
                } else {
                    materialButtonLike.icon =
                        ContextCompat.getDrawable(root.context, R.drawable.ic_like_inactive)
                }
                materialButtonLike.setOnClickListener {
                    callback.onClickLike(item)
                }
            }
        }

        companion object {
            fun getViewHolder(parent: ViewGroup): CategoryViewHolder {
                val binding = ViewCategoryBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return CategoryViewHolder(binding)
            }
        }
    }

    class ButtonFavoritesViewHolder(
        private val binding: ViewButtonFavoritesBinding
    ) : RecyclerView.ViewHolder(binding.root) {


        fun bind(item: Category?, callback: ICategoryCallback) {
            binding.materialButtonFavorites.setOnClickListener {
                callback.onClickTestFavorites(item)
            }
        }

        companion object {
            fun getViewHolder(parent: ViewGroup): ButtonFavoritesViewHolder {
                val binding = ViewButtonFavoritesBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return ButtonFavoritesViewHolder(binding)
            }
        }
    }

    class CategoryDiffUtilCallback : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean =
            oldItem == newItem
    }

    interface ICategoryCallback {
        fun onClickTestFavorites(item: Category?)
        fun onClickLike(item: Category)
    }

    companion object {
        const val TYPE_BUTTON = 1
        const val TYPE_CATEGORY = 2
    }
}