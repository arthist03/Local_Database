package com.example.database_arth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.jar.Attributes.Name

class MainActivity : AppCompatActivity() {


    lateinit var editTextName: EditText
    lateinit var editTextPassword: EditText
    lateinit var buttonSave: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        editTextName = findViewById(R.id.etName)
        editTextPassword = findViewById(R.id.etPassword)
        buttonSave = findViewById(R.id.btnSave)


        buttonSave.setOnClickListener{

            val sharedPref = getSharedPreferences("Login data", MODE_PRIVATE)
            val editor = sharedPref.edit()


            val n= editTextName.text.toString()
            editor.putString("Name", n)

            val p= editTextPassword.text.toString()
            editor.putString("Password", p)

            editor.apply()


            val i = Intent(this, HomeScreen::class.java)
            startActivity(i)

        }
    }
}