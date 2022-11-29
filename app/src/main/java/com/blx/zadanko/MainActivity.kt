package com.blx.zadanko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import org.w3c.dom.Text
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var buttons = arrayListOf<Switch>(findViewById(R.id.switch_1),findViewById(R.id.switch_2),findViewById(R.id.switch_3),findViewById(R.id.switch_4),
            findViewById(R.id.switch_5), findViewById(R.id.switch_6),findViewById(R.id.switch_7),findViewById(R.id.switch_8),findViewById(R.id.switch_9))

        findViewById<Button>(R.id.button_losuj).setOnClickListener {
            var kolejnosc = losuj()
            for (i in buttons.indices)
                buttons[i].text = kolejnosc[i].toString()
        }
    }
}

private fun losuj() : List<Int> {
    val kolejnosc = generateSequence {
        Random.nextInt(1..9)
    }.distinct().take(9).toList()
    return kolejnosc
}