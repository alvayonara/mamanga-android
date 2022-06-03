package com.alvayonara.mamanga.common.extension

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
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

inline fun <reified T : AppCompatActivity> Fragment.moveActivity(clearTop: Boolean = false) {
    if (!clearTop) {
        Intent(requireContext(), T::class.java).also { intent ->
            startActivity(intent)
        }
    } else {
        Intent(requireContext(), T::class.java).also { intent ->
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }

}

inline fun <reified T : AppCompatActivity> Fragment.moveActivity(bundle: Bundle) {
    Intent(requireContext(), T::class.java).also { intent ->
        intent.putExtras(bundle)
        startActivity(intent)
    }
}

inline fun <reified T : AppCompatActivity> Context.moveActivity() {
    Intent(this, T::class.java).also { intent ->
        startActivity(intent)
    }
}

inline fun <reified T : AppCompatActivity> Context.moveActivity(bundle: Bundle, clearTop: Boolean) {
    if (!clearTop) {
        Intent(this, T::class.java).also { intent ->
            intent.putExtras(bundle)
            startActivity(intent)
        }
    } else {
        Intent(this, T::class.java).also { intent ->
            intent.putExtras(bundle)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }
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

fun Fragment.onBackPressedFragment(action: () -> Unit) {
    val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            action()
        }
    }
    requireActivity().onBackPressedDispatcher.addCallback(this, callback)
}