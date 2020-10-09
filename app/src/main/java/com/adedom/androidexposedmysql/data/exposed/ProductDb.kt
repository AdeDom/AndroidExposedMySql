package com.adedom.androidexposedmysql.data.exposed

import org.joda.time.DateTime

data class ProductDb(
    val productId: Int? = null,
    val name: String? = null,
    val price: Double? = null,
    val dateTime: DateTime? = null,
)
