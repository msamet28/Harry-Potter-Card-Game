package com.example.yazlab3

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.widget.ImageView
import com.google.firebase.firestore.FirebaseFirestore
import android.util.Base64
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random


class kolay1oyun_ekrani : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        fun img (base64img: String): Bitmap {
            val imageBytes = Base64.decode(base64img, Base64.DEFAULT)
            val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
            return decodedImage
        }

        lateinit var timer:CountDownTimer
        lateinit var kolay1basla:Button
        lateinit var image1:ImageView
        lateinit var image2:ImageView
        lateinit var image3:ImageView
        lateinit var image4:ImageView
        lateinit var kolay1sure:TextView
        lateinit var kolay1puan:TextView
        lateinit var kolay1karttakisim:TextView
        var click:MediaPlayer?=null

        var açılmışadet:Int=0
        val bulunanfotolar=ArrayList<ImageView>()
        var sayac:Int=0
        val rastgele=(0..11).shuffled().last()
        lateinit var tutucu1:ImageView
        lateinit var tutucu2:ImageView
        var image_tut1:String=""
        var image_tut2:String=""
        var isim_tut1:String=""
        var isim_tut2:String=""
        var aile_tut1:String=""
        var aile_tut2:String=""
        var puan_tut1:Int=0
        var puan_tut2:Int=0
        var homepoint_tut1:Int=0
        var homepoint_tut2:Int=0
        var puan_son:Double=0.0
        var puan_sure:Double=0.0
        var toplam_eslesme_sayisi=0

        var eslesme_müzik: MediaPlayer?=null
        var süre_müzik: MediaPlayer?=null
        var kazanma_müzik: MediaPlayer?=null

        var gindex:Int=0
        var ghome:String="Gryffindor"
        var ghomepoint:Int=2
        val gname=Array<String>(11){""}
        val gimage=Array<String>(11){""}
        val gpoint=Array<String>(11){""}
        var sindex:Int=0
        var shome:String="Slytherin"
        var shomepoint:Int=2
        val sname=Array<String>(11){""}
        val simage=Array<String>(11){""}
        val spoint=Array<String>(11){""}


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kolay1oyun_ekrani)

        kolay1basla=findViewById(R.id.kolay1basla)
        image1=findViewById(R.id.kolay1foto1)
        image2=findViewById(R.id.kolay1foto2)
        image3=findViewById(R.id.kolay1foto3)
        image4=findViewById(R.id.kolay1foto4)
        val fotolar=Array<ImageView>(4){image1}
        fotolar[1]=image2
        fotolar[2]=image3
        fotolar[3]=image4
        fotolar.shuffle()

        kolay1sure=findViewById(R.id.kolay1süre)
        kolay1puan=findViewById(R.id.kolay1puan)
        kolay1karttakisim=findViewById(R.id.kolay1karttakiisim)
        click=MediaPlayer.create(this,R.raw.click)


        süre_müzik= MediaPlayer.create(this,R.raw.sure_bit)
        kazanma_müzik= MediaPlayer.create(this,R.raw.kazanma)

        for(i in fotolar){
            i.isEnabled=false
        }
        kolay1sure.text="45"

        kolay1basla.setOnClickListener {
            click?.start()
            kolay1basla.isEnabled=false
            kolay1basla.isVisible=false
            for(i in fotolar){
                i.isEnabled=true
            }

            timer=object :CountDownTimer(/* millisInFuture = */ 46000,/* countDownInterval = */ 1000){
                override fun onTick(saniye: Long) {
                    puan_sure=(saniye/1000).toDouble()
                    kolay1sure.text=(saniye/1000).toString()
                    if(toplam_eslesme_sayisi==2){
                        for (i in fotolar) {
                            i.isEnabled = false
                        }
                        timer.cancel()
                    }

                }
                override fun onFinish() {
                    for (i in fotolar) {
                        i.isEnabled = false
                    }
                    süre_müzik?.start()
                }
            }.start()
        }


        //Veri okuma-yazma için referans oluşturulmalı
        val db= FirebaseFirestore.getInstance()

        //Gryffindor Veri Çekme
        db.collection("Gryffindor")
            .get()
            .addOnCompleteListener{
                for(document in it.result!!){
                    gname[gindex]=document.data.getValue("name").toString()
                    gimage[gindex]= document.data.getValue("image").toString()
                    gpoint[gindex]= document.data.getValue("point").toString()
                    gindex++
                }
            }

        //Slytherin Veri Çekme
        db.collection("Slytherin")
            .get()
            .addOnCompleteListener {
                for (document in it.result!!){
                    sname[sindex]=document.data.getValue("name").toString()
                    simage[sindex]= document.data.getValue("image").toString()
                    spoint[sindex]= document.data.getValue("point").toString()
                    sindex++
                }
            }


        for(i in 0..1){

            fotolar[i].setOnClickListener{
                fotolar[i].isEnabled=false
                fotolar[i].setImageBitmap(img(gimage[rastgele]))
                sayac++
                if(sayac==1){
                    tutucu1=fotolar[i]
                    image_tut1=gimage[rastgele]
                    puan_tut1=gpoint[rastgele].toInt()
                    isim_tut1=gname[rastgele]
                    aile_tut1=ghome
                    homepoint_tut1=ghomepoint
                    kolay1karttakisim.text=isim_tut1
                }
                else if(sayac==2){
                    açılmışadet++
                    if(açılmışadet==1){
                        açılmışadet=0
                        for(i in fotolar){
                            i.isEnabled=false
                        }
                    }
                    tutucu2=fotolar[i]
                    image_tut2=gimage[rastgele]
                    puan_tut2=gpoint[rastgele].toInt()
                    isim_tut2=gname[rastgele]
                    aile_tut2=ghome
                    homepoint_tut2=ghomepoint
                    kolay1karttakisim.text=isim_tut2
                    sayac=0

                    if(image_tut1!=image_tut2){
                        Handler().postDelayed({
                            tutucu1.setImageResource(R.drawable.img)
                            tutucu2.setImageResource(R.drawable.img)
                            for(i in fotolar){
                                i.isEnabled=true
                            }
                            if(bulunanfotolar.count()!=0){
                                for(i in bulunanfotolar){
                                    i.isEnabled=false
                                }
                            }
                        }, 550)
                        if(aile_tut1==aile_tut2){
                            puan_son=puan_son-((puan_tut1+puan_tut2)/homepoint_tut2)*((45-puan_sure)/10)
                            kolay1puan.text=(puan_son.toInt()).toString()
                        }
                        else{
                            puan_son=puan_son-((puan_tut1+puan_tut2)/2)*homepoint_tut1*homepoint_tut2*((45-puan_sure)/10)
                            kolay1puan.text=(puan_son.toInt()).toString()
                        }
                    }
                    else{
                        for(i in fotolar){
                            i.isEnabled=true
                        }
                        bulunanfotolar.add(tutucu1)
                        bulunanfotolar.add(tutucu2)
                        if(bulunanfotolar.count()!=0){
                            for(i in bulunanfotolar){
                                i.isEnabled=false
                            }
                        }
                        eslesme_müzik= MediaPlayer.create(this,R.raw.eslesme)
                        eslesme_müzik?.start()
                        tutucu1.isEnabled=false
                        tutucu2.isEnabled=false
                        puan_son=puan_son+(2*puan_tut2*homepoint_tut2)*(puan_sure/10)
                        kolay1puan.text=(puan_son.toInt()).toString()
                        toplam_eslesme_sayisi++
                        if(toplam_eslesme_sayisi==2){
                            kazanma_müzik?.start()
                        }
                    }
                }
            }

        }


        for(i in 2..3){

            fotolar[i].setOnClickListener{
                fotolar[i].isEnabled=false
                fotolar[i].setImageBitmap(img(simage[rastgele]))
                sayac++
                if(sayac==1){
                    tutucu1=fotolar[i]
                    image_tut1=simage[rastgele]
                    puan_tut1=spoint[rastgele].toInt()
                    isim_tut1=sname[rastgele]
                    aile_tut1=shome
                    homepoint_tut1=shomepoint
                    kolay1karttakisim.text=isim_tut1
                }
                else if(sayac==2){
                    açılmışadet++
                    if(açılmışadet==1){
                        açılmışadet=0
                        for(i in fotolar){
                            i.isEnabled=false
                        }
                    }
                    tutucu2=fotolar[i]
                    image_tut2=simage[rastgele]
                    puan_tut2=spoint[rastgele].toInt()
                    isim_tut2=sname[rastgele]
                    aile_tut2=shome
                    homepoint_tut2=shomepoint
                    kolay1karttakisim.text=isim_tut2
                    sayac=0

                    if(image_tut1!=image_tut2){
                        Handler().postDelayed({
                            tutucu1.setImageResource(R.drawable.img)
                            tutucu2.setImageResource(R.drawable.img)
                            for(i in fotolar){
                                i.isEnabled=true
                            }
                            if(bulunanfotolar.count()!=0){
                                for(i in bulunanfotolar){
                                    i.isEnabled=false
                                }
                            }
                        }, 550)
                        if(aile_tut1==aile_tut2){
                            puan_son=puan_son-((puan_tut1+puan_tut2)/homepoint_tut2)*((45-puan_sure)/10)
                            kolay1puan.text=(puan_son.toInt()).toString()
                        }
                        else{
                            puan_son=puan_son-((puan_tut1+puan_tut2)/2)*homepoint_tut1*homepoint_tut2*((45-puan_sure)/10)
                            kolay1puan.text=(puan_son.toInt()).toString()
                        }
                    }
                    else{
                        for(i in fotolar){
                            i.isEnabled=true
                        }
                        bulunanfotolar.add(tutucu1)
                        bulunanfotolar.add(tutucu2)
                        if(bulunanfotolar.count()!=0){
                            for(i in bulunanfotolar){
                                i.isEnabled=false
                            }
                        }
                        eslesme_müzik= MediaPlayer.create(this,R.raw.eslesme)
                        eslesme_müzik?.start()
                        tutucu1.isEnabled=false
                        tutucu2.isEnabled=false
                        puan_son=puan_son+(2*puan_tut2*homepoint_tut2)*(puan_sure/10)
                        kolay1puan.text=(puan_son.toInt()).toString()
                        toplam_eslesme_sayisi++
                        if(toplam_eslesme_sayisi==2){
                            kazanma_müzik?.start()
                        }
                    }
                }
            }

        }










    }
}





