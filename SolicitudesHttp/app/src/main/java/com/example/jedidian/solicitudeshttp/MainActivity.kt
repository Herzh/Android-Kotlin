package com.example.jedidian.solicitudeshttp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_validarRed = findViewById<Button>(R.id.Btn_validarRed)

        btn_validarRed.setOnClickListener{

            //Codigo para verificar conexion a internet
            if(Network.hayRed( this)){
                Toast.makeText(this, " si hay red! ", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Verifica tu conexion a internet", Toast.LENGTH_LONG).show()
            }
        }
    }
}
