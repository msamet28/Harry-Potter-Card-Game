package com.example.yazlab3

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class zorluk_ekrani1 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var kolaybuton1:Button
        lateinit var ortabuton1:Button
        lateinit var zorbuton1:Button
        var click: MediaPlayer?=null

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zorluk_ekrani1)

        kolaybuton1=findViewById(R.id.kolaybuton1)
        ortabuton1=findViewById(R.id.ortabuton1)
        zorbuton1=findViewById(R.id.zorbuton1)
        click=MediaPlayer.create(this,R.raw.click)

        kolaybuton1.setOnClickListener {
            click?.start()
            val intent=Intent(this,kolay1oyun_ekrani::class.java)
            startActivity(intent)
        }

        ortabuton1.setOnClickListener {
            click?.start()
            val intent=Intent(this,orta1oyun_ekrani::class.java)
            startActivity(intent)
        }
        zorbuton1.setOnClickListener {
            click?.start()
            val intent=Intent(this, zor1oyun_ekrani::class.java)
            startActivity(intent)
        }

    }
}