package com.decorator1889.instruments.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.decorator1889.instruments.adapters.CategoryAdapter
import com.decorator1889.instruments.databinding.FragmentFavoriteBinding
import com.decorator1889.instruments.models.Category
import com.decorator1889.instruments.showToast
import com.decorator1889.instruments.viewModels.FavoriteViewModel

class FavoriteFragment : Fragment(), CategoryAdapter.ICategoryCallback {

    private lateinit var binding: FragmentFavoriteBinding

    private val viewModel: FavoriteViewModel by viewModels()

    private val categoryAdapter by lazy {
        CategoryAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentFavoriteBinding.inflate(inflater, container, false).apply {
        binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        loadDataFavorite()
        categoryAdapter.submitList(viewModel.categoryList.value)
    }

    private fun loadDataFavorite() {
        viewModel.loadDataFavorite()
    }

    private fun initAdapter() {
        binding.recyclerViewFavorite.adapter = categoryAdapter
    }

    override fun onClickTestFavorites(item: Category?) {
        showToast(context, "11")
    }

    override fun onClickLike(item: Category) {
        showToast(context, "11")
    }
}