package com.crypto.assessment

import com.crypto.mainmenu.utils.Utility
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
@HiltAndroidTest
class LoginTest {

    companion object {
        private const val STRING = "Klaten"
        private const val SHORT_STRING = "221"
        private const val EMAIL = "saya.email@email.com"
    }

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun init() {
        hiltRule.inject()
    }

    /**
     * User Scenario : As an user I would like to input login form and cannot continue
     * if required field is not inputted properly
     */


    /**
     * Test Case : Validate Email Field is Not Empty and Format is right
     * Type : Normal
     */
    @Test
    fun isEmailValid() {
        (assert(Utility().isEmailValid(EMAIL)))
    }
    /**
     * Test Case : Validate Email Field is Not Empty and format is wrong
     * Type : Negative
     */
    @Test
    fun isEmailNotValid() {
        (Assert.assertFalse(Utility().isEmailValid(STRING)))
    }
    /**
     * Test Case : Validate Password Field is Not Empty
     * Type : Normal
     */
    @Test
    fun isPasswordValid() {
        (assert(Utility().isPasswordValid(STRING)))
    }
    /**
     * Test Case : Validate Password Field is too short
     * Type : Normal
     */
    @Test
    fun isPasswordInValid() {
        (Assert.assertFalse(Utility().isPasswordValid(SHORT_STRING)))
    }

}