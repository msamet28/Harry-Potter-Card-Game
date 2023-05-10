package com.example.yazlab3

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {


        lateinit var girisbuton: Button

        lateinit var kayitolbuton:TextView
        lateinit var şifreyenilebuton:TextView
        lateinit var kullaniciadigiris:TextView
        lateinit var sifregiris:TextView
        var kullanicivesifre=HashMap<String,String>()
        var kullanici:Boolean=false
        var sifre:String=""
        var click:MediaPlayer?=null

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        girisbuton=findViewById(R.id.girisbuton)
        kayitolbuton=findViewById(R.id.kayitolbuton)
        şifreyenilebuton=findViewById(R.id.şifreyenilebuton)
        kullaniciadigiris=findViewById(R.id.kullaniciadigiris)
        sifregiris=findViewById(R.id.sifregiris)
        click=MediaPlayer.create(this,R.raw.click)

        //Veri okuma-yazma için referans oluşturulmalı
        var database= FirebaseDatabase.getInstance().reference

        kayitolbuton.setOnClickListener{
            click?.start()
            val intent = Intent(this,kayit_ekrani::class.java)
            startActivity(intent)
        }

        girisbuton.setOnClickListener{
            click?.start()
            for(i in kullanicivesifre){
                if(i.key==kullaniciadigiris.text.toString()){
                    kullanici=true
                    sifre=i.value
                    break
                }
                else{
                    kullanici=false
                }
            }

            if(kullanici==true && sifregiris.text.toString()==sifre){
                val intent= Intent(this,kisi_ekrani::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Kullanıcı Bilgileri Eksik Veya Hatalı...",Toast.LENGTH_LONG).show()
            }
        }

        şifreyenilebuton.setOnClickListener{
            click?.start()
            val intent=Intent(this,sifredegistirme_ekrani::class.java)
            startActivity(intent)
        }

        //Veri Çekme
        var getdata=object:ValueEventListener{
            override fun onDataChange(sayi: DataSnapshot) {
                for(i in sayi.children){
                    kullanicivesifre.put(i.child("kullaniciadi").getValue().toString(),i.child("sifre").getValue().toString())
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        }
        database.addListenerForSingleValueEvent(getdata)


    }
}



