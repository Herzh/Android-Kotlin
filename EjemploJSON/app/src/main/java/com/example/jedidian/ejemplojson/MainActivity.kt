package com.example.jedidian.ejemplojson

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    var listaPersonas:ArrayList<Persona>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var respuesta = "{ \"personas\" : [ " +
                            "{" +
                                "\"nombre\"      :       \"Marcos\"  ,"  +
                                "\"pais\"        :       \"Mexico\"  ,"  +
                                "\"estado\"      :       \"soltero\" ,"  +
                                "\"experiencia\" :        5},"  +

                            "{" +
                                "\"nombre\"      :      \"Agustin\"  ,"  +
                                "\"pais\"        :      \"España\"   ,"  +
                                "\"estado\"      :      \"casado\"   ,"  +
                                "\"experiencia\" :       16}" +
                                "]" +
                            " }"
        val json = JSONObject(respuesta)
        val personas = json.getJSONArray("personas")
        listaPersonas = ArrayList()

        for(i in 0..personas.length() -1){
            val nombre = personas.getJSONObject(i).getString("nombre")
            val pais = personas.getJSONObject(i).getString("pais")
            val estado = personas.getJSONObject(i).getString("estado")
            val experiencia = personas.getJSONObject(i).getString("experiencia")

            //val persona = Persona(nombre, pais, estado, experiencia)
            listaPersonas?.add(Persona(nombre, pais, estado, experiencia))
            //Log.d("Persona", persona.nombre)
        }

        Log.d("OnCreate", listaPersonas?.count().toString())
    }
}
