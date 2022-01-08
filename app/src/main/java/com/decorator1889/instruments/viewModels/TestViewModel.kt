package com.decorator1889.instruments.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.decorator1889.instruments.models.Catalog
import com.decorator1889.instruments.models.Level
import com.decorator1889.instruments.models.getFakeCatalog
import com.decorator1889.instruments.models.getFakeLevels

class TestViewModel: ViewModel() {

    private val _testList = MutableLiveData<List<Level>>()
    val testList: LiveData<List<Level>> = _testList

    fun loadDataTest() {
        try {
            _testList.value = getFakeLevels()
        } catch (exc: Exception) {
            Log.e("StocksException", exc.message ?: "")
        }
    }
}