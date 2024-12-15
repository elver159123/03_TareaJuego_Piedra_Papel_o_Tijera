package com.sigfred.piedrapapelotijeras

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class Juego : AppCompatActivity() {

    private lateinit var computerChoice: TextView
    private lateinit var gameResult: TextView
    private lateinit var playerScore: TextView
    private lateinit var computerScore: TextView

    private var playerPoints = 0
    private var computerPoints = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)

        // Referencias a las vistas
        computerChoice = findViewById(R.id.computerChoice)
        gameResult = findViewById(R.id.gameResult)
        playerScore = findViewById(R.id.playerScore)
        computerScore = findViewById(R.id.computerScore)

        val buttonPiedra: ImageButton = findViewById(R.id.imageButtonPiedra)
        val buttonPapel: ImageButton = findViewById(R.id.imageButtonPapel)
        val buttonTijeras: ImageButton = findViewById(R.id.imageButtonTijeras)

        // Eventos para los botones
        buttonPiedra.setOnClickListener { playGame("Piedra") }
        buttonPapel.setOnClickListener { playGame("Papel") }
        buttonTijeras.setOnClickListener { playGame("Tijeras") }
    }

    private fun playGame(playerChoice: String) {
        val choices = listOf("Piedra", "Papel", "Tijeras")
        val computerSelection = choices[Random.nextInt(choices.size)]

        // Actualizar la elección de la computadora
        computerChoice.text = "Computadora elige: $computerSelection"

        // Determinar el resultado
        val result = when {
            playerChoice == computerSelection -> "Empate"
            playerChoice == "Piedra" && computerSelection == "Tijeras" ||
                    playerChoice == "Papel" && computerSelection == "Piedra" ||
                    playerChoice == "Tijeras" && computerSelection == "Papel" -> {
                playerPoints++
                "Ganaste"
            }
            else -> {
                computerPoints++
                "Perdiste"
            }
        }

        // Actualizar el marcador y el resultado
        gameResult.text = "Resultado: $result"
        playerScore.text = "Jugador: $playerPoints"
        computerScore.text = "Computadora: $computerPoints"
    }
}

