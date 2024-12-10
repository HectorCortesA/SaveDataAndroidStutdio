package com.hectorcortes.savedata1

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MostrarDatosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_datos)

        val sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)

        // Mostrar los datos guardados
        findViewById<TextView>(R.id.nombreText).text = sharedPreferences.getString("nombre", "")
        findViewById<TextView>(R.id.apellidoText).text = sharedPreferences.getString("apellido", "")
        findViewById<TextView>(R.id.matriculaText).text = sharedPreferences.getString("matricula", "")
        findViewById<TextView>(R.id.facultadText).text = sharedPreferences.getString("facultad", "")
        findViewById<TextView>(R.id.semestreText).text = sharedPreferences.getString("semestre", "")
        findViewById<TextView>(R.id.sexoText).text = sharedPreferences.getString("sexo", "")
        findViewById<TextView>(R.id.emailText).text = sharedPreferences.getString("email", "")

        // Botón para cerrar sesión y borrar datos
        findViewById<Button>(R.id.btnLogout).setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.clear() // Borrar todos los datos guardados
            editor.apply()

            // Redirigir al Activity de registro
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
