package com.example.jedidian.solicitudeshttp

import android.app.VoiceInteractor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity(), CompletadoListener {

    override fun descargaCompleta(resultado: String) {
        Log.d("descargaCompleta", resultado)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_validarRed = findViewById<Button>(R.id.Btn_validarRed)
        val btn_solicitudHttp = findViewById<Button>(R.id.Btn_solicitudHttp)
        val btn_volley = findViewById<Button>(R.id.Btn_volley)

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

                //Log.d( "bSolicitudOnclick", descargarDatos("http://www.google.com"))
                DescargaURL(this).execute("http://www.google.com")
            }else {

                Toast.makeText(this, "Verifica tu conexion a internet", Toast.LENGTH_LONG).show()
            }
        }

        btn_volley.setOnClickListener{

            //Codigo para verificar conexion a internet
            if(Network.hayRed( this)){
                solicitudHTtpVolley("http://www.google.com")
            }else {
                Toast.makeText(this, "Verifica tu conexion a internet", Toast.LENGTH_LONG).show()
            }
        }

    }

    //Metodo Volley
    private fun solicitudHTtpVolley(url:String){

        val queue = Volley.newRequestQueue(this)

        val solicitud = StringRequest(Request.Method.GET, url, Response.Listener<String>{
            response ->
            try {
                Log.d("SolicitudHttpVolley", response)
            }catch (e: Exception){

            }
        }, Response.ErrorListener {  })

        queue.add(solicitud)
    }

}