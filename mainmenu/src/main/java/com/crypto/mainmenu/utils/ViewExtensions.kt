package com.crypto.mainmenu.utils

import android.view.View
import android.view.ViewGroup

fun View.slideFromBottom() {
    if (translationY > 0f) animate().translationY(0f)
}

fun View.slideToBottom() {
    if (translationY == 0f) {
        val bottomMargin = (layoutParams as ViewGroup.MarginLayoutParams).bottomMargin
        animate().translationY(height.toFloat() + bottomMargin)
    }
}