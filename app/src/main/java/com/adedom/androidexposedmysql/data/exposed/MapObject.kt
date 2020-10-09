package com.adedom.androidexposedmysql.data.exposed

import org.jetbrains.exposed.sql.ResultRow

object MapObject {

    fun toProductList(row: ResultRow) = ProductDb(
        productId = row[Products.productId],
        name = row[Products.name],
        price = row[Products.price],
        dateTime = row[Products.dateTime],
    )

}
