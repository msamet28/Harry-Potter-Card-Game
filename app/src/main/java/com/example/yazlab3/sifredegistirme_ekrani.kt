package com.example.yazlab3

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

class sifredegistirme_ekrani : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var kullaniciadisifre:TextView
        lateinit var sifreyenisifre:TextView
        lateinit var yenisifrebuton:Button
        var click: MediaPlayer?=null
        var idvekullaniciadi=HashMap<String,String>()
        var kullaniciadi:Boolean=false
        var id:String=""

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sifredegistirme_ekrani)
        kullaniciadisifre=findViewById(R.id.kullaniciadiyenisifre)
        sifreyenisifre=findViewById(R.id.sifreyenisifre)
        yenisifrebuton=findViewById(R.id.yenisifrebuton)
        click=MediaPlayer.create(this,R.raw.click)

        //Veri okuma-yazma için referans oluşturulmalı
        var database= FirebaseDatabase.getInstance().reference

        yenisifrebuton.setOnClickListener {
            click?.start()
            for(i in idvekullaniciadi){
                if(i.value==kullaniciadisifre.text.toString()){
                    kullaniciadi=true
                    id=i.key
                    break
                }
                else{
                    kullaniciadi=false
                }
            }

            if(kullaniciadi==true){
                database.child(id).child("sifre").setValue(sifreyenisifre.text.toString())
                Toast.makeText(this,"Şifreniz Başarıyla Değiştirildi...",Toast.LENGTH_LONG).show()
                val intent= Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Böyle Bir Kullanıcı Bulunamadı...",Toast.LENGTH_LONG).show()
            }
        }

        //Veri Çekme
        var getdata=object: ValueEventListener {
            override fun onDataChange(sayi: DataSnapshot) {
                for(i in sayi.children){
                    idvekullaniciadi.put(i.key.toString(),i.child("kullaniciadi").getValue().toString())
                }
            }
            override fun onCancelled(error: DatabaseError) {
            }
        }
        database.addListenerForSingleValueEvent(getdata)

    }
}