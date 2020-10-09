package com.adedom.androidexposedmysql.presentation.main

import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import com.adedom.androidexposedmysql.R
import com.adedom.androidexposedmysql.base.BaseActivity
import com.adedom.androidexposedmysql.presentation.insertproduct.InsertProductActivity
import com.adedom.androidexposedmysql.presentation.productlist.ProductListActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.exposed.sql.Database

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())
        Database.connect(
            url = "jdbc:mysql://192.168.43.22/stock",
            driver = "com.mysql.jdbc.Driver",
            user = "root",
            password = "abc456"
        )

        btProductList.setOnClickListener {
            Intent(baseContext, ProductListActivity::class.java).apply {
                startActivity(this)
            }
        }

        btInsertProduct.setOnClickListener {
            Intent(baseContext, InsertProductActivity::class.java).apply {
                startActivity(this)
            }
        }
    }

}
