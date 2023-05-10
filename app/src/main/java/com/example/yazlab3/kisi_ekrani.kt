package com.example.yazlab3

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView


class kisi_ekrani : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var tekoyuncubuton:Button
        lateinit var cokoyuncubuton:Button
        lateinit var sesbuton:ImageView
        var click:MediaPlayer?=null

        var ses:MediaPlayer?=null
        var control=false

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kisi_ekrani)

        tekoyuncubuton=findViewById(R.id.tekoyuncubuton)
        cokoyuncubuton=findViewById(R.id.cokoyuncubuton)
        sesbuton=findViewById(R.id.sesbuton)
        click= MediaPlayer.create(this,R.raw.click)

        ses=MediaPlayer.create(this,R.raw.prologue)
        ses?.start()
        control=true

        tekoyuncubuton.setOnClickListener{
            click?.start()
            var intent=Intent(this,zorluk_ekrani1::class.java)
            startActivity(intent)
        }
        cokoyuncubuton.setOnClickListener {
            click?.start()
            var intent=Intent(this,zorluk_ekrani2::class.java)
            startActivity(intent)
        }
        sesbuton.setOnClickListener{
            if(control){
                ses!!.pause()
                sesbuton.setImageResource(R.drawable.icons8_mute_100px)
                control=false
            }
            else{
                ses?.start()
                sesbuton.setImageResource(R.drawable.icons8_sound_100px_1)
                control=true
            }
        }

    }
}