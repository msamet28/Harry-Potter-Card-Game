package com.example.yazlab3

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class zorluk_ekrani2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var kolaybuton2: Button
        lateinit var ortabuton2:Button
        lateinit var zorbuton2:Button
        var click: MediaPlayer?=null

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zorluk_ekrani2)

        kolaybuton2=findViewById(R.id.kolaybuton2)
        ortabuton2=findViewById(R.id.ortabuton2)
        zorbuton2=findViewById(R.id.zorbuton2)
        click=MediaPlayer.create(this,R.raw.click)

        kolaybuton2.setOnClickListener {
            click?.start()
            val intent=Intent(this,kolay2oyun_ekrani::class.java)
            startActivity(intent)
        }

        ortabuton2.setOnClickListener {
            click?.start()
            val intent= Intent(this,orta2oyun_ekrani::class.java)
            startActivity(intent)
        }

        zorbuton2.setOnClickListener {
            click?.start()
            val intent=Intent(this,zor2oyun_ekrani::class.java)
            startActivity(intent)
        }
    }
}