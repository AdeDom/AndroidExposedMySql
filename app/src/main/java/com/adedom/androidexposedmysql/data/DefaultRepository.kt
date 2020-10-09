package com.adedom.androidexposedmysql.data

import com.adedom.androidexposedmysql.data.exposed.MapObject
import com.adedom.androidexposedmysql.data.exposed.ProductDb
import com.adedom.androidexposedmysql.data.exposed.Products
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime

class DefaultRepository {

    fun fetchProductList(): List<ProductDb> {
        return transaction {
            Products.selectAll()
                .map { MapObject.toProductList(it) }
        }
    }

    fun insertProduct(name: String, price: Double): Boolean {
        val statement = transaction {
            Products.insert {
                it[Products.name] = name
                it[Products.price] = price
                it[dateTime] = DateTime.now()
            }
        }

        return statement.resultedValues?.size == 1
    }

    fun isValidateProductName(name: String): Boolean {
        val count = transaction {
            Products.select { Products.name eq name }
                .count()
                .toInt()
        }

        return count >= 1
    }

}
