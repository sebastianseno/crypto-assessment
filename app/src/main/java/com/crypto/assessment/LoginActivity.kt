package com.crypto.assessment

import android.os.Bundle
import android.text.Html
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.crypto.assessment.databinding.ActivityMainBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        showSystemUI()
        val text =
            "<font color=#00000>Belum punya akun ?</font> <font color=#00AB6B>Daftar Sekarang</font>"
        binding.register.text = Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY)

//        binding.button.setOnClickListener {
//            startActivity(Intent(this, MenuActivity::class.java))
//        }
    }

    private fun showSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, true)
        WindowInsetsControllerCompat(
            window,
            binding.root
        ).show(WindowInsetsCompat.Type.systemBars())
    }
}