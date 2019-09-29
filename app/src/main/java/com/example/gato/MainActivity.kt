package com.example.gato

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // variables y se inicializa el tablero
    var playeractual ="X"
    var board = "---"+
            "---"+
            "---"
    var Over:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        refresh(board)
    }

    // Botones
    fun button_pressed(view:View){
        if (Over){
            return
        }
        var index = resources.getResourceName(view.id).last().toString().toInt()

        if(board[index] != '-'){
            return
        }

        var char_A = board.toCharArray()
        char_A[index] = playeractual.first().toChar()
        board = String(char_A)

        // Cuando alguien gana
     when(winner(board)){
            "X" -> {
                Over = true
                Toast.makeText(this, "Ganó X", Toast.LENGTH_SHORT).show()


                "Gano x"
            }
            "O" -> {
                Over = true
                Toast.makeText(this, "Ganó O", Toast.LENGTH_SHORT).show()

            }
            "D" -> {
                Over = true
                Toast.makeText(this, "Empate", Toast.LENGTH_SHORT).show()

            }
            "C" -> ""
            else -> ""
        }




        if(playeractual == "X"){
            playeractual = "O"
        }else{
            playeractual = "X"
        }

        refresh(board)

    }

    fun refresh(b: String){
        for( i in b.indices ){
            var id = resources.getIdentifier("cell_"+ i,"id", this.getPackageName())
            var cell = findViewById<Button>(id)
            if(b[i].toString() == "-"){
                cell.text = ""
            }else{
                cell.text = b[i].toString()
            }
        }
    }


    fun winner(b:String): String {
        if ((b[0] == b[1] && b[1] == b[2] && b[1] != '-')||
            (b[3] == b[4] && b[4] == b[5] && b[2] != '-')||
            (b[6] == b[7] && b[7] == b[8] && b[3] != '-')||
            (b[0] == b[3] && b[3] == b[6] && b[4] != '-')||
            (b[1] == b[4] && b[4] == b[7] && b[5] != '-')||
            (b[2] == b[5] && b[5] == b[8] && b[6] != '-')||
            (b[0] == b[4] && b[4] == b[8] && b[7] != '-')||
            (b[2] == b[4] && b[4] == b[4] && b[8] != '-')){
            return playeractual
        }
        if(b.contains("-")){
            return "C"
        }
            return "D"
    }

    fun reset(view: View){
        board ="---------"
        Over = false

        if(playeractual == "X"){
            playeractual = "O"
        }else{
            playeractual = "X"
        }

        refresh(board)
    }


}
