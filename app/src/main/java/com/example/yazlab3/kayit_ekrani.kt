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

class kayit_ekrani : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var kayitbuton:Button
        lateinit var kullaniciadikayit:TextView
        lateinit var emailkayit:TextView
        lateinit var sifrekayit:TextView
        var click:MediaPlayer?=null
        var a:String=""
        var vericekme=ArrayList<String>()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kayit_ekrani)

        kayitbuton=findViewById(R.id.kayitbuton)
        kullaniciadikayit=findViewById(R.id.kullaniciadikayit)
        emailkayit=findViewById(R.id.emailkayit)
        sifrekayit=findViewById(R.id.sifrekayit)
        click=MediaPlayer.create(this,R.raw.click)

        //Veri okuma-yazma için referans oluşturulmalı
        var database=FirebaseDatabase.getInstance().reference

        //Veri Ekleme
        kayitbuton.setOnClickListener {
            click?.start()
            var kullaniciadiekle= kullaniciadikayit.text.toString()
            var emailekle= emailkayit.text.toString()
            var sifreekle= sifrekayit.text.toString()

            for(i in vericekme){
                if(i==kullaniciadikayit.text.toString()){
                    a="var"
                    break
                }
                else{
                    a=""
                }
            }

            var id=vericekme.count()

            if(!(kullaniciadiekle.isNotEmpty()) || !(emailekle.isNotEmpty()) || !(sifreekle.isNotEmpty())){
                Toast.makeText(this,"İlgili Alanlardan Herhangi Birini Boş Bırakmayınız...",Toast.LENGTH_LONG).show()
            }
            else{
                if(a=="var"){
                    Toast.makeText(this,"Bu İsim Kullanılmaktadır...",Toast.LENGTH_LONG).show()
                }
                else{
                    database.child(id.toString()).setValue(Kayıt(kullaniciadiekle,emailekle,sifreekle))
                    Toast.makeText(this,"Kaydiniz Başarıyla Oluşturuldu...",Toast.LENGTH_LONG).show()
                    var intent=Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }

        //Veri Çekme
        var getdata=object: ValueEventListener {
            override fun onDataChange(sayi: DataSnapshot) {
                for(i in sayi.children){
                    vericekme.add(i.child("kullaniciadi").getValue().toString())
                }
            }
            override fun onCancelled(error: DatabaseError) {
            }
        }
        database.addListenerForSingleValueEvent(getdata)

    }
}