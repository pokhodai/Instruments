package com.decorator1889.instruments.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.decorator1889.instruments.models.Catalog
import com.decorator1889.instruments.models.Category
import com.decorator1889.instruments.models.getFakeCategory
import kotlinx.coroutines.launch

class FavoriteViewModel : ViewModel() {

    private val _categoryList = MutableLiveData<List<Category>>()
    val categoryList: LiveData<List<Category>> = _categoryList

    fun loadDataFavorite() {
        viewModelScope.launch {
            try {
                _categoryList.value = getFakeCategory()
            } catch (exc: Exception) {
                Log.e("CategoryException", exc.message ?: "")
            }
        }
    }
}