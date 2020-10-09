package com.adedom.androidexposedmysql.presentation.insertproduct

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.adedom.androidexposedmysql.R
import com.adedom.androidexposedmysql.base.BaseActivity
import com.adedom.androidexposedmysql.util.getContents
import com.adedom.androidexposedmysql.util.toast
import kotlinx.android.synthetic.main.activity_insert_product.*

class InsertProductActivity : BaseActivity() {

    private lateinit var viewModel: InsertProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_product)

        viewModel = ViewModelProvider(this).get(InsertProductViewModel::class.java)

        viewModel.insertProduct.observe {
            if (it) {
                etName.text.clear()
                etPrice.text.clear()
                toast("Completed")
            } else {
                toast("Failed")
            }
        }

        viewModel.toast.observe {
            toast(it)
        }

        btInsertProduct.setOnClickListener {
            val name = etName.getContents()
            val price = etPrice.getContents()

            viewModel.insertProduct(name, price)
        }

    }

}
