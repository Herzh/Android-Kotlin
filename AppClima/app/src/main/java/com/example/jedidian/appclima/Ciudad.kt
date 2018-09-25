package com.example.jedidian.appclima

import java.io.StringBufferInputStream

class Ciudad (nombre:String, grados:Int, status:String){

    var nombre:String = ""
    var grados:Int = 0
    var status:String = ""

    init {
        this.nombre = nombre
        this.grados = grados
        this.status = status
    }
}