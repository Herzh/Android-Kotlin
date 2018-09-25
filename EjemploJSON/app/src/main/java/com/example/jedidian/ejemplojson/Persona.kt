package com.example.jedidian.ejemplojson

class Persona(nombre:String, pais:String, estado:String, experiencia:String) {

    var nombre:String = ""
    var pais:String = ""
    var estado:String = ""
    var experiencia:String = ""

    init {
        this.nombre = nombre
        this.pais = pais
        this.estado = estado
        this.experiencia = experiencia
    }

}