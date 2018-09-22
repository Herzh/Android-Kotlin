package com.example.jedidian.solicitudeshttp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.widget.Button
import android.widget.Toast
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_validarRed = findViewById<Button>(R.id.Btn_validarRed)
        val btn_solicitudHttp = findViewById<Button>(R.id.Btn_solicitudHttp)

        btn_validarRed.setOnClickListener{

            //Codigo para verificar conexion a internet
            if(Network.hayRed( this)){
                Toast.makeText(this, " si hay red! ", Toast.LENGTH_LONG).show()
            }else {
                Toast.makeText(this, "Verifica tu conexion a internet", Toast.LENGTH_LONG).show()
            }
        }

        btn_solicitudHttp.setOnClickListener {
            //Codigo para verificar conexion a internet
            if(Network.hayRed( this)){
                Log.d( "bSolicitudOnclick", descargarDatos("http://www.google.com"))
                Toast.makeText(this, " solicitud hecha! ", Toast.LENGTH_LONG).show()
            }else {
                Toast.makeText(this, "Verifica tu conexion a internet", Toast.LENGTH_LONG).show()
            }
        }
    }


    @Throws(IOException::class)
    private fun descargarDatos(url:String):String{

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        var inputStream:InputStream? = null

        try {

            val url = URL(url)
            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "GET"
            conn.connect()

            inputStream = conn.inputStream

            return inputStream.bufferedReader().use {
                it.readText()
            }

        }finally{

            if(inputStream != null){
                inputStream.close()
            }
        }
    }
}
