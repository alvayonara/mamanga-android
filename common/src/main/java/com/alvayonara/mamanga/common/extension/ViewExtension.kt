package com.alvayonara.mamanga.common.extension

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import java.text.ParseException
import java.text.SimpleDateFormat


fun View.gone() {
    this.visibility = View.GONE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun SwipeRefreshLayout.showLoading() {
    this.isRefreshing = true
}

fun SwipeRefreshLayout.hideLoading() {
    this.isRefreshing = false
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

/**
 * @param inputFormat format dateTime that will be convert
 * @param outputFormat format dateTIme for result
 * @return return new date time format based on outputFormat
 *
 * @see DateFormat for supported DateFormat
 */
@SuppressLint("SimpleDateFormat")
fun String?.dateTimeConvert(inputFormat: String, outputFormat: String): String {
    return try {
        val sdf = SimpleDateFormat(inputFormat)
        val convertDate = sdf.parse(this.orEmpty())
        SimpleDateFormat(outputFormat).format(convertDate!!)
    } catch (e: ParseException) {
        ""
    }
}