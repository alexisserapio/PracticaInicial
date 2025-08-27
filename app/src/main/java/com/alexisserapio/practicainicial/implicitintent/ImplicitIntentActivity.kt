package com.alexisserapio.practicainicial.implicitintent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alexisserapio.practicainicial.R

class ImplicitIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_implicit_intent)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonImpIntent = findViewById<Button>(R.id.buttonImpIntent)

        buttonImpIntent.setOnClickListener {
            val urlImpIntent =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.nvidia.com/es-la/"))
            startActivity(Intent.createChooser(urlImpIntent, "Abrir Usando:"))
        }

    }
}