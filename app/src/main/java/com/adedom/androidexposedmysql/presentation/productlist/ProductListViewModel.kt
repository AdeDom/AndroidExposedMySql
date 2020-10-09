package com.adedom.androidexposedmysql.presentation.productlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adedom.androidexposedmysql.data.DefaultRepository
import com.adedom.androidexposedmysql.data.model.ProductModel
import com.adedom.androidexposedmysql.util.toStringDateTime

class ProductListViewModel : ViewModel() {

    private val repository = DefaultRepository()

    private val _productList = MutableLiveData<List<ProductModel>>()
    val productList: LiveData<List<ProductModel>>
        get() = _productList

    fun fetchProductList() {
        _productList.value = repository.fetchProductList().map {
            ProductModel(
                productId = it.productId,
                name = it.name,
                price = it.price,
                dateTime = it.dateTime?.toStringDateTime(),
            )
        }
    }

}
