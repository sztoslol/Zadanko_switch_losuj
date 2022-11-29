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

        findViewById<Button>(R.id.button_sortuj).setOnClickListener {
            var liczby = arrayListOf<Int>()
            for (i in buttons.indices)
                if (buttons[i].isChecked)
                    liczby.add(buttons[i].text.toString().toInt())
            val ans = bubbleSort(liczby)
            var textans = ""
            for (k in ans) textans += "$k "
            findViewById<TextView>(R.id.textView_wynik).text = textans
        }
    }
}

fun bubbleSort(arr:ArrayList<Int>):ArrayList<Int>{
    var swap = true
    while(swap){
        swap = false
        for(i in 0 until arr.size-1){
            if(arr[i] > arr[i+1]){
                val temp = arr[i]
                arr[i] = arr[i+1]
                arr[i + 1] = temp
                swap = true
            }
        }
    }
    return arr
}

fun losuj() : List<Int> {
    val kolejnosc = generateSequence {
        Random.nextInt(1..9)
    }.distinct().take(9).toList()
    return kolejnosc
}