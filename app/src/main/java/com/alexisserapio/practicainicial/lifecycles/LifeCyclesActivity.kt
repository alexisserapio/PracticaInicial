package com.alexisserapio.practicainicial.lifecycles

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alexisserapio.practicainicial.R

class LifeCyclesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_life_cycles)
        Log.e("LifeCycle", "onCreate")
        Toast.makeText(this, "Entré al metodo onCreate()", Toast.LENGTH_SHORT).show()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("LifeCycle", "onStart")
        Toast.makeText(this, "Entré al metodo onStart()", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.e("LifeCycle", "onResume")
        Toast.makeText(this, "Entré al metodo onResume()", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.e("LifeCycle", "onPause")
        Toast.makeText(this, "Entré al metodo onPause()", Toast.LENGTH_SHORT).show()
    }

    override fun onStop(){
        super.onStop()
        Log.e("LifeCycle", "onStop")
        Toast.makeText(this, "Entré al metodo onStop()", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("LifeCycle", "onDestroy")
        Toast.makeText(this, "Entré al metodo onDestroy()", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("LifeCycle", "onRestart")
        Toast.makeText(this, "Entré al metodo onRestart()", Toast.LENGTH_SHORT).show()
    }
}