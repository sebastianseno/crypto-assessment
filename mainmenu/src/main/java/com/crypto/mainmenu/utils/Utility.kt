package com.crypto.mainmenu.utils

import java.util.regex.Matcher
import java.util.regex.Pattern

class Utility {

    val VALID_EMAIL_ADDRESS_REGEX =
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE)

    fun isEmailValid(email: String): Boolean {
        val matcher: Matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email)
        return email.isNotEmpty() && matcher.find()
    }

    open fun isPasswordValid(password: String): Boolean {
        return password.length >= 4
    }

}