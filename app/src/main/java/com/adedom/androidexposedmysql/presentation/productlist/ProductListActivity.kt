package com.adedom.androidexposedmysql.presentation.productlist

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.adedom.androidexposedmysql.R
import com.adedom.androidexposedmysql.base.BaseActivity
import kotlinx.android.synthetic.main.activity_product_list.*

class ProductListActivity : BaseActivity() {

    private lateinit var viewModel: ProductListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        viewModel = ViewModelProvider(this).get(ProductListViewModel::class.java)

        viewModel.productList.observe {
            it.forEach {
                val text = "${it.name} ${it.price} ${it.dateTime}\n"
                tvProduct.append(text)
            }
        }

        viewModel.fetchProductList()
    }

}
