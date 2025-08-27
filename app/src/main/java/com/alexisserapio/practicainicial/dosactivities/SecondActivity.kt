package com.alexisserapio.practicainicial.dosactivities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alexisserapio.android14.practicas.explicitintent.Person
import com.alexisserapio.practicainicial.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val labelInfo = findViewById<TextView>(R.id.labelInfo)
        var infoReceived = "Name: "

        intent.extras?.let { info ->
            if (info.containsKey("EXTRA_NAME_KEY")) {
                //               infoReceived = infoReceived + info.getString("EXTRA_NAME_KEY", "")
                infoReceived += info.getString("EXTRA_NAME_KEY", "")
                infoReceived += " | "
            }
            if (info.containsKey("EXTRA_BUNDLE_KEY")) {
                val bundle = info.getBundle("EXTRA_BUNDLE_KEY")

                bundle?.let {
                    infoReceived += "Last Name: "
                    infoReceived += bundle.getString("EXTRA_SURNAME_KEY", "")
                    infoReceived += " | "
                    infoReceived += "Gender: "
                    infoReceived += bundle.getChar("EXTRA_GENDER_KEY", 'N')
                    infoReceived += " | "
                    infoReceived += "Married: "
                    infoReceived += bundle.getBoolean("EXTRA_MARRIED_KEY", false)
                    infoReceived += " | "
                    infoReceived += "Discount Code: "
                    infoReceived += bundle.getByte("EXTRA_CLIENTCODE_KEY", 0)
                }
            }
            if (info.containsKey("EXTRA_AGE_KEY")) {
                infoReceived += " | "
                infoReceived += "Age: "
                infoReceived += info.getInt("EXTRA_AGE_KEY", 0)
                infoReceived += " | "
                infoReceived += "Price: "
                infoReceived += info.getDouble("EXTRA_PRICE_KEY")
            }
        }

        //Second
       /* val name = intent.getStringExtra("EXTRA_NAME_KEY")
        val age = intent.getIntExtra("EXTRA_AGE_KEY", 0)

        name?.let {
            //infoReceived += "," + it
            infoReceived += ", $it"
        }
        infoReceived += ", $age"

        //infoReceived += ", ${if(name!= null) name else ""}, $age"
        infoReceived += ", ${name ?: ""}, $age"*/

        labelInfo.text = infoReceived

        val btnBackResult = findViewById<Button>(R.id.buttonBackToFirst)

        btnBackResult.setOnClickListener {
            val person1 = Person("Alexis", "Serapio", 23, false, 'M', 100)
            val resultIntent = Intent().apply {
                putExtra("EXTRA_DOUBLE_KEY",0)
                putExtra("EXTRA_BOOLEAN_KEY", true)
                putExtra("EXTRA_PERSON_KEY", person1)
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}