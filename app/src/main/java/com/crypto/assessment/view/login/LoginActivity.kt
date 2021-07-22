package com.crypto.assessment.view.login

import android.content.Intent
import android.os.Bundle
import android.text.Html
import androidx.appcompat.app.AppCompatActivity
import com.crypto.assessment.databinding.ActivityMainBinding
import com.crypto.assessment.view.menu.MenuActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val text =
            "<font color=#00000>Belum punya akun ?</font> <font color=#00AB6B>Daftar Sekarang</font>"
        binding.register.text = Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY)

        binding.loginButton.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }
    }

}