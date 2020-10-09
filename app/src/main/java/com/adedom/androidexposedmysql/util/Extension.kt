package com.adedom.androidexposedmysql.util

import android.content.Context
import android.widget.EditText
import android.widget.Toast
import org.joda.time.DateTime
import java.text.SimpleDateFormat
import java.util.*

fun DateTime.toStringDateTime(): String {
    return SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(this.toDate())
}

fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun EditText.getContents(): String = this.text.toString().trim()
