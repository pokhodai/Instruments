package com.decorator1889.instruments.views

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.decorator1889.instruments.R
import com.decorator1889.instruments.adapters.CatalogAdapter
import com.decorator1889.instruments.databinding.FragmentMainBinding
import com.decorator1889.instruments.models.Catalog
import com.decorator1889.instruments.showToast
import com.decorator1889.instruments.viewModels.MainViewModel


class MainFragment : Fragment(), CatalogAdapter.ICatalogCallback {

    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel by viewModels()

    private val catalogAdapter by lazy {
        CatalogAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentMainBinding.inflate(inflater, container, false).apply {
        binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        loadDataCatalog()
        catalogAdapter.submitList(viewModel.catalogList.value)
    }

    private fun loadDataCatalog() {
        val name = "Ксения"
        binding.textViewWelcome.text = String.format(resources.getString(R.string.mainWelcome), name)
        viewModel.loadDataCatalog()
    }

    private fun initAdapter() {
        binding.recyclerViewCatalog.adapter = catalogAdapter
    }

    override fun onClickCatalog(item: Catalog) {
        showToast(context, "Каталог")
    }
}