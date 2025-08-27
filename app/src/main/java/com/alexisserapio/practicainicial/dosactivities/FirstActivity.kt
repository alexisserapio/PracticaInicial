package com.alexisserapio.practicainicial.dosactivities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alexisserapio.android14.practicas.explicitintent.Person
import com.alexisserapio.practicainicial.R
import java.util.ArrayList

class FirstActivity : AppCompatActivity() {

    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if (result.resultCode == RESULT_OK){
            val doubleResult = result.data?.getDoubleExtra("EXTRA_DOUBLE_KEY", 0.0)
            val booleanResult = result.data?.getBooleanExtra("EXTRA_BOOLEAN_KEY", false)
            val person1 = result.data?.getSerializableExtra("EXTRA_PERSON_KEY") as Person
            Toast.makeText(this, "RESULT_OK $booleanResult,$doubleResult, $person1", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "RESULT_CANCELLED", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_first)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonToSecondActivity = findViewById<Button>(R.id.buttonToSecondAct)

        buttonToSecondActivity.setOnClickListener{
            val extraBundle = Bundle().apply {
                putBoolean("EXTRA_MARRIED_KEY", false)
                putString("EXTRA_SURNAME_KEY", "Serapio")
                putChar("EXTRA_GENDER_KEY", 'M')
                putByte("EXTRA_CLIENTCODE_KEY", 101)
            }
            val secondIntent = Intent(this, SecondActivity::class.java).apply {
                putExtra("EXTRA_NAME_KEY", "Alexis")
                putExtra("EXTRA_AGE_KEY", 23)
                putExtra("EXTRA_PRICE_KEY", 99.99)
                putExtra("EXTRA_BUNDLE_KEY", extraBundle)
            }

            register.launch(secondIntent)
        }

    }
}