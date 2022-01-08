package com.decorator1889.instruments.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.decorator1889.instruments.models.Catalog
import com.decorator1889.instruments.models.getFakeCatalog

class MainViewModel: ViewModel() {

    private val _catalogList = MutableLiveData<List<Catalog>>()
    val catalogList: LiveData<List<Catalog>> = _catalogList

    fun loadDataCatalog() {
        try {
            _catalogList.value = getFakeCatalog()
        } catch (exc: Exception) {
            Log.e("StocksException", exc.message ?: "")
        }
    }
}