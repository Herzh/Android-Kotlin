package com.example.jedidian.solicitudeshttp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import okhttp3.Call
import okhttp3.OkHttpClient
import java.io.IOException

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
        val btn_okHttp = findViewById<Button>(R.id.Btn_okHttp)

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

        btn_okHttp.setOnClickListener{

            //Codigo para verificar conexion a internet
            if(Network.hayRed( this)){
                solicitudOkHttp("http://www.google.com")
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

    //Metodo para okHttp
    private fun solicitudOkHttp(url:String){
        var cliente = OkHttpClient()
        var solicitud = okhttp3.Request.Builder().url(url).build()

        cliente.newCall(solicitud).enqueue(object:okhttp3.Callback{

            //Si algo falla
            override fun onFailure(call: Call?, e: IOException?) {

            }

            //Si hay respuesta satisfactoria
            override fun onResponse(call: Call?, response: okhttp3.Response) {
                var resultado = response.body().string()

                this@MainActivity.runOnUiThread {
                    try {
                        Log.d("solicitudOkHtpp", resultado)
                    }catch (e: Exception){

                    }
                }
            }
        })
    }

}