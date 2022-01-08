package com.decorator1889.instruments.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.decorator1889.instruments.adapters.CatalogAdapter
import com.decorator1889.instruments.adapters.LevelsAdapter
import com.decorator1889.instruments.databinding.FragmentMainBinding
import com.decorator1889.instruments.databinding.FragmentTestBinding
import com.decorator1889.instruments.showToast
import com.decorator1889.instruments.viewModels.MainViewModel
import com.decorator1889.instruments.viewModels.TestViewModel

class TestFragment : Fragment(), LevelsAdapter.ILevelsCallback {

    private lateinit var binding: FragmentTestBinding

    private val viewModel: TestViewModel by viewModels()

    private val levelsAdapter by lazy {
        LevelsAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentTestBinding.inflate(inflater, container, false).apply {
        binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        loadDataTest()
        levelsAdapter.submitList(viewModel.testList.value)
    }

    private fun loadDataTest() {
        viewModel.loadDataTest()
    }

    private fun initAdapter() {
        binding.recyclerViewTest.adapter = levelsAdapter
    }

    override fun onClickLevel(type: String) {
        showToast(context, type)
    }
}