package com.decorator1889.instruments.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.decorator1889.instruments.R
import com.decorator1889.instruments.databinding.ViewLevelsBinding
import com.decorator1889.instruments.models.Level

class LevelsAdapter(
    private val callback: ILevelsCallback
): ListAdapter<Level, LevelsAdapter.LevelsViewHolder>(LevelsDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LevelsViewHolder {
        return LevelsViewHolder.getViewHolder(parent)
    }

    override fun onBindViewHolder(holder: LevelsViewHolder, position: Int) {
        holder.bind(getItem(position), callback)
    }

    class LevelsViewHolder(
        private val binding: ViewLevelsBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Level, callback: ILevelsCallback) {
            binding.apply {
                textViewName.text = item.name
                textViewNumbers.text = root.context.getString(
                    R.string.testNumbers,
                    item.numbersQuestion
                )
                when (item.type) {
                    "easy" -> {
                        imageViewArrow.setImageResource(R.drawable.ic_arrow_easy)
                        imageViewIcon.setImageResource(R.drawable.ic_easy)
                        imageViewBgr.setImageResource(R.drawable.bgr_easy)
                        textViewChangeCategory.setTextColor(ContextCompat.getColor(root.context, R.color.blue_5B67CA))
                    }
                    "middle" -> {
                        imageViewArrow.setImageResource(R.drawable.ic_arrow_middle)
                        imageViewIcon.setImageResource(R.drawable.ic_middle)
                        imageViewBgr.setImageResource(R.drawable.bgr_middle)
                        textViewChangeCategory.setTextColor(ContextCompat.getColor(root.context, R.color.blue_7EC3DF))
                    }
                    "hard" -> {
                        imageViewArrow.setImageResource(R.drawable.ic_arrow_hard)
                        imageViewIcon.setImageResource(R.drawable.ic_hard)
                        imageViewBgr.setImageResource(R.drawable.bgr_hard)
                        textViewChangeCategory.setTextColor(ContextCompat.getColor(root.context, R.color.red_E77D7D))
                    }
                }
                materialCardViewRoot.setOnClickListener {
                    callback.onClickLevel(item.type)
                }
            }
        }

        companion object {
            fun getViewHolder(parent: ViewGroup): LevelsViewHolder {
                val binding = ViewLevelsBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return LevelsViewHolder(binding)
            }
        }
    }

    class LevelsDiffUtilCallback : DiffUtil.ItemCallback<Level>() {
        override fun areItemsTheSame(oldItem: Level, newItem: Level): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Level, newItem: Level): Boolean = oldItem == newItem
    }

    interface ILevelsCallback {
        fun onClickLevel(type: String)
    }
}