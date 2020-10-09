package com.adedom.androidexposedmysql.presentation.insertproduct

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adedom.androidexposedmysql.data.DefaultRepository

class InsertProductViewModel : ViewModel() {

    private val repository = DefaultRepository()

    private val _insertProduct = MutableLiveData<Boolean>()
    val insertProduct: LiveData<Boolean>
        get() = _insertProduct

    private val _toast = MutableLiveData<String>()
    val toast: LiveData<String>
        get() = _toast

    fun insertProduct(name: String?, price: String?) {
        when {
            // validate isNullOrBlank
            name.isNullOrBlank() -> _toast.value = "Name isNullOrBlank"
            price.isNullOrBlank() -> _toast.value = "Price isNullOrBlank"

            // validate variable
            price.toDoubleOrNull() == null -> _toast.value = "Price incorrect"

            // validate database
            repository.isValidateProductName(name) -> _toast.value = "Name repeat"

            // execute
            else -> _insertProduct.value = repository.insertProduct(name, price.toDouble())
        }
    }

}
