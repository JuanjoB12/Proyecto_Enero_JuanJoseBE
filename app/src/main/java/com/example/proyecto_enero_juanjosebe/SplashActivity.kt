package com.example.proyecto_enero_juanjosebe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.proyecto_enero_juanjosebe.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

     lateinit var binding: ActivitySplashBinding

        override fun onCreate(savedInstanceState: Bundle?) {
        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        screenSplash.setKeepOnScreenCondition{true}
            // Tiempo de espera del spash
        Thread.sleep(4000)
            // Donde queremos que se ejecute lel splash
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
            // Finalización del spash
        finish()

    }
}