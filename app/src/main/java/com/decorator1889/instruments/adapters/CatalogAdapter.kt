package com.decorator1889.instruments.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.decorator1889.instruments.R
import com.decorator1889.instruments.databinding.ViewCatalogBinding
import com.decorator1889.instruments.models.Catalog

class CatalogAdapter(
    private val callback: ICatalogCallback
): ListAdapter<Catalog, CatalogAdapter.CatalogViewHolder>(CatalogDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        return CatalogViewHolder.getViewHolder(parent)
    }

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        holder.bind(getItem(position), callback)
    }

    class CatalogViewHolder(
        private val binding: ViewCatalogBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Catalog, callback: ICatalogCallback) {
            binding.apply {
                textViewName.text = item.name
                textViewNumbers.text = root.context.getString(
                    R.string.mainNumbers,
                    item.numbers
                )
                when (item.type) {
                    1 -> {
                        imageViewBgr.setImageResource(R.drawable.bgr_surgery)
                        imageViewIcon.setImageResource(R.drawable.ic_surgery)
                    }
                    2 -> {
                        imageViewBgr.setImageResource(R.drawable.bgr_dentistry)
                        imageViewIcon.setImageResource(R.drawable.ic_dentistry)
                    }
                    3 -> {
                        imageViewBgr.setImageResource(R.drawable.bgr_obstetrics)
                        imageViewIcon.setImageResource(R.drawable.ic_obstetrics)
                    }
                    4 -> {
                        imageViewBgr.setImageResource(R.drawable.bgr_neurosurgery)
                        imageViewIcon.setImageResource(R.drawable.ic_neurosurgery)
                    }
                    5 -> {
                        imageViewBgr.setImageResource(R.drawable.bgr_ophthalmology)
                        imageViewIcon.setImageResource(R.drawable.ic_ophthalmology)
                    }
                    6 -> {
                        imageViewBgr.setImageResource(R.drawable.bgr_otorhinolaryngology)
                        imageViewIcon.setImageResource(R.drawable.ic_otorhinolaryngology)
                    }
                }
                if (item.lock){
                    imageViewArrow.setImageResource(R.drawable.ic_arrow_mini)
                } else {
                    imageViewArrow.setImageResource(R.drawable.ic_lock_dark)
                }
                if (!item.lock) {
                    return
                } else {
                    materialCardViewRoot.setOnClickListener {

                        callback.onClickCatalog(item)
                    }
                }
            }
        }

        companion object {
            fun getViewHolder(parent: ViewGroup): CatalogViewHolder {
                val binding = ViewCatalogBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return CatalogViewHolder(binding)
            }
        }
    }

    class CatalogDiffUtilCallback : DiffUtil.ItemCallback<Catalog>() {
        override fun areItemsTheSame(oldItem: Catalog, newItem: Catalog): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Catalog, newItem: Catalog): Boolean = oldItem == newItem
    }

    interface ICatalogCallback {
        fun onClickCatalog(item: Catalog)
    }
}