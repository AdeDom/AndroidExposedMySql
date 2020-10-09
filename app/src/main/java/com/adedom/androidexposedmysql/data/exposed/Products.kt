package com.adedom.androidexposedmysql.data.exposed

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.jodatime.datetime

object Products : Table(name = "product") {

    val productId = integer(name = "product_id").autoIncrement()
    val name = varchar(name = "name", length = 50)
    val price = double(name = "price")
    val dateTime = datetime(name = "date_time")

    override val primaryKey: PrimaryKey?
        get() = PrimaryKey(productId, name = "PK_Product_ID")

}
