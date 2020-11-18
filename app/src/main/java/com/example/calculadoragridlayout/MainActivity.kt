package com.example.calculadoragridlayout

import android.media.VolumeShaper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*


class MainActivity : AppCompatActivity() {
    lateinit var  txtResult: TextView
    var  operacionPendiente= false
    var  suma = false
     var resta = false
    var numAnterior=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtResult= findViewById<TextView>(R.id.txt_result)
    }
    fun presionoBoton(v: View) {
        val btnPresiono = v as TextView
        if (txtResult.text.equals("0") || operacionPendiente){
            txtResult.text = btnPresiono.text
            operacionPendiente= false
    }
        else
        txtResult.text= "${txtResult.text}${btnPresiono.text}"
    }
    fun ejecutarOperacion(){
        var numeroActual= txtResult.text.toString().toInt()
        var result =0
        if(suma)
            result = numeroActual + numAnterior
        else if(resta)
            result = numAnterior - numeroActual
                    txtResult.text= result.toString()

    }
    fun presionoOperacion(v: View){
        val btnPresiono= v as TextView
        if(suma||resta)
            ejecutarOperacion()
         operacionPendiente = true
       when (btnPresiono.text){
           "+"->{
               suma= true
               resta= false
               numAnterior = txtResult.text.toString().toInt()
           }
           "-"->{
               suma=false
               resta= true
               numAnterior = txtResult.text.toString().toInt()
           }
           "="->{
               suma= false
               resta= false
               numAnterior =0

           }
           "C"->{
               suma= false
               resta= false
               txtResult.text="0"
               numAnterior=0
           }
       }
    }
}