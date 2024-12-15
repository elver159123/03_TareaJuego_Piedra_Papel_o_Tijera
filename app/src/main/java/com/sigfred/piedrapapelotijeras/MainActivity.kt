package com.sigfred.piedrapapelotijeras

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencia al botón
        val startButton = findViewById<Button>(R.id.startButton)

        // Configurar el evento onClick para cambiar de pantalla
        startButton.setOnClickListener {
            // Crear un Intent para iniciar la GameActivity
            val intent = Intent(this, Juego::class.java)
            startActivity(intent) // Navegar a la nueva pantalla
        }
    }
}
