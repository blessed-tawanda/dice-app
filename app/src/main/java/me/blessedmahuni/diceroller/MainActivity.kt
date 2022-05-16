package me.blessedmahuni.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * This is an activity which allows simulates a dice roll by generating a random number between 1 and 6
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        rollDice()
    }

    /**
     * This function instantiates the Dice class and calls the function/method roll which will be set to the text of resultTextView
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll the dice
        val myDice = Dice(6)
        val diceRoll = myDice.roll()
        val diceImage : ImageView = findViewById(R.id.imageView)

        /**
         * Selecting the appropriate image to display for a dice roll
         */
        val drawableResource = when(diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }
}

/**
 * The Dice class which simulates a roll by getting a random number between 1 and the maximum number of Dice Sides
 */
class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}