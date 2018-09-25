package com.example.jedidian.appclima

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var tv_ciudad:TextView? = null
    var tv_grados:TextView? = null
    var tv_status:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_ciudad = findViewById<TextView>(R.id.tv_ciudad)
        tv_grados = findViewById<TextView>(R.id.tv_grados)
        tv_status = findViewById<TextView>(R.id.tv_estatus)

        val ciudad = intent.getStringExtra("com.example.jedidian.appclima.ciudades.CIUDAD")

        val ciudad_mx = Ciudad("Ciudad de Mexico", 15, "Soleado")
        val ciudad_berlin = Ciudad("Ciudad de Berlin", 30, "Cielo Despejado")

        if(ciudad == "ciudad_mexico" ){
            tv_ciudad?.text = ciudad_mx.nombre
            tv_grados?.text = ciudad_mx.grados.toString()
            tv_status?.text = ciudad_mx.status
        }else if(ciudad == "ciudad_berlin"){
            tv_ciudad?.text = ciudad_berlin.nombre
            tv_grados?.text = ciudad_berlin.grados.toString()
            tv_status?.text = ciudad_berlin.status
        }else{
            Toast.makeText(this, "No se encontro la informacion", Toast.LENGTH_SHORT).show()
        }
    }
}
