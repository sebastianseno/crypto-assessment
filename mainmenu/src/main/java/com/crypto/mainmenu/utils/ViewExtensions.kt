package com.crypto.mainmenu.utils

import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar

fun View.slideFromBottom() {
    if (translationY > 0f) animate().translationY(0f)
}

fun View.slideToBottom() {
    if (translationY == 0f) {
        val bottomMargin = (layoutParams as ViewGroup.MarginLayoutParams).bottomMargin
        animate().translationY(height.toFloat() + bottomMargin)
    }
}

val TextView.string: String
    get() = text.toString()

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) {
    liveData.observe(this, Observer(body))
}

fun View.snackBarRed(context: Context, message: String) {
    val snackBar = Snackbar.make(this, message, Snackbar.LENGTH_LONG)
    val view = snackBar.view
    val params = view.layoutParams as FrameLayout.LayoutParams
    params.gravity = Gravity.TOP
    view.layoutParams = params
    snackBar.view.setBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_red_dark))
    snackBar.show()
}