package com.hectorcortes.savedata1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)

        // Verificar si ya existen datos guardados
        if (sharedPreferences.contains("email")) {
            // Si ya hay un correo guardado, redirigir al login
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        } else {
            setContentView(R.layout.activity_main) // El layout con los campos para registro
            val btnGuardar = findViewById<Button>(R.id.btnGuardar)

            btnGuardar.setOnClickListener {
                val nombre = findViewById<EditText>(R.id.nombre).text.toString()
                val apellido = findViewById<EditText>(R.id.apellido).text.toString()
                val matricula = findViewById<EditText>(R.id.matricula).text.toString()
                val facultad = findViewById<EditText>(R.id.facultad).text.toString()
                val semestre = findViewById<EditText>(R.id.semestre).text.toString()
                val sexo = findViewById<EditText>(R.id.sexo).text.toString()
                val email = findViewById<EditText>(R.id.email).text.toString()
                val password = findViewById<EditText>(R.id.password).text.toString()

                // Guardar los datos en SharedPreferences
                val editor = sharedPreferences.edit()
                editor.putString("nombre", nombre)
                editor.putString("apellido", apellido)
                editor.putString("matricula", matricula)
                editor.putString("facultad", facultad)
                editor.putString("semestre", semestre)
                editor.putString("sexo", sexo)
                editor.putString("email", email)
                editor.putString("password", password)
                editor.apply()

                // Redirigir al Activity de mostrar datos
                startActivity(Intent(this, MostrarDatosActivity::class.java))
                finish()
            }
        }
    }
}
