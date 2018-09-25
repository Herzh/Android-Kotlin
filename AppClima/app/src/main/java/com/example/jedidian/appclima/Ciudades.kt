package com.example.jedidian.appclima

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Ciudades : AppCompatActivity() {

    val TAG = "com.example.jedidian.appclima.ciudades.CIUDAD"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)

        val btn_mexico = findViewById<Button>(R.id.btn_mexico)
        val btn_berlin = findViewById<Button>(R.id.btn_berlin)

        btn_mexico.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG, "ciudad_mexico")
            startActivity(intent)
        }

        btn_berlin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG, "ciudad_berlin")
            startActivity(intent)
        }
    }
}
