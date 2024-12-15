package com.sigfred.piedrapapelotijeras

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class Juego : AppCompatActivity() {

    private lateinit var playerScoreTextView: TextView
    private lateinit var computerScoreTextView: TextView
    private lateinit var gameResultTextView: TextView
    private lateinit var computerChoiceTextView: TextView

    private var playerScore = 0
    private var computerScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)

        // Inicializar vistas
        playerScoreTextView = findViewById(R.id.playerScore)
        computerScoreTextView = findViewById(R.id.computerScore)
        gameResultTextView = findViewById(R.id.gameResult)
        computerChoiceTextView = findViewById(R.id.computerChoice)

        // Configurar botones
        findViewById<Button>(R.id.buttonRock).setOnClickListener { playGame("Piedra") }
        findViewById<Button>(R.id.buttonPaper).setOnClickListener { playGame("Papel") }
        findViewById<Button>(R.id.buttonScissors).setOnClickListener { playGame("Tijera") }
    }

    private fun playGame(playerChoice: String) {
        val choices = listOf("Piedra", "Papel", "Tijera")
        val computerChoice = choices[Random.nextInt(choices.size)]

        // Mostrar selección de la computadora
        computerChoiceTextView.text = "Computadora elige: $computerChoice"

        // Determinar el resultado
        val result = when {
            playerChoice == computerChoice -> "Empate"
            playerChoice == "Piedra" && computerChoice == "Tijera" -> "Ganaste"
            playerChoice == "Papel" && computerChoice == "Piedra" -> "Ganaste"
            playerChoice == "Tijera" && computerChoice == "Papel" -> "Ganaste"
            else -> "Perdiste"
        }

        // Actualizar resultado y puntuación
        gameResultTextView.text = "Resultado: $result"
        if (result == "Ganaste") {
            playerScore++
        } else if (result == "Perdiste") {
            computerScore++
        }

        // Actualizar puntuaciones
        updateScores()
    }

    private fun updateScores() {
        playerScoreTextView.text = "Jugador: $playerScore"
        computerScoreTextView.text = "Computadora: $computerScore"
    }
}
