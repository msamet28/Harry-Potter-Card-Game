package com.example.yazlab3

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.util.Base64
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import com.google.firebase.firestore.FirebaseFirestore
import kotlin.random.Random

class zor1oyun_ekrani : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        fun img (base64img: String): Bitmap {
            val imageBytes = Base64.decode(base64img, Base64.DEFAULT)
            val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
            return decodedImage
        }

        lateinit var zor1basla: Button
        lateinit var timer: CountDownTimer
        lateinit var image1: ImageView
        lateinit var image2: ImageView
        lateinit var image3: ImageView
        lateinit var image4: ImageView
        lateinit var image5: ImageView
        lateinit var image6: ImageView
        lateinit var image7: ImageView
        lateinit var image8: ImageView
        lateinit var image9: ImageView
        lateinit var image10: ImageView
        lateinit var image11: ImageView
        lateinit var image12: ImageView
        lateinit var image13: ImageView
        lateinit var image14: ImageView
        lateinit var image15: ImageView
        lateinit var image16: ImageView
        lateinit var image17: ImageView
        lateinit var image18: ImageView
        lateinit var image19: ImageView
        lateinit var image20: ImageView
        lateinit var image21:ImageView
        lateinit var image22:ImageView
        lateinit var image23:ImageView
        lateinit var image24:ImageView
        lateinit var image25:ImageView
        lateinit var image26:ImageView
        lateinit var image27:ImageView
        lateinit var image28:ImageView
        lateinit var image29:ImageView
        lateinit var image30:ImageView
        lateinit var image31:ImageView
        lateinit var image32:ImageView
        lateinit var image33:ImageView
        lateinit var image34:ImageView
        lateinit var image35:ImageView
        lateinit var image36:ImageView
        lateinit var zor1sure: TextView
        lateinit var zor1puan: TextView
        lateinit var zor1karttakiisim:TextView
        var click:MediaPlayer?=null

        var açılmışadet:Int=0
        val bulunanfotolar=ArrayList<ImageView>()
        var sayac:Int=0
        val rastgele1=(0..2).shuffled().last()
        val rastgele2=(3..5).shuffled().last()
        val rastgele3=(6..7).shuffled().last()
        val rastgele4=(8..9).shuffled().last()
        val rastgele5=(10..11).shuffled().last()
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
        var hindex:Int=0
        var hhome:String="Hufflepuff"
        var hhomepoint:Int=1
        val hname=Array<String>(11){""}
        val himage=Array<String>(11){""}
        val hpoint=Array<String>(11){""}
        var rindex:Int=0
        var rhome:String="Ravenclaw"
        var rhomepoint:Int=1
        val rname=Array<String>(11){""}
        val rimage=Array<String>(11){""}
        val rpoint=Array<String>(11){""}

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zor1oyun_ekrani)

        zor1basla=findViewById(R.id.zor1basla)
        image1=findViewById(R.id.zor1foto1)
        image2=findViewById(R.id.zor1foto2)
        image3=findViewById(R.id.zor1foto3)
        image4=findViewById(R.id.zor1foto4)
        image5=findViewById(R.id.zor1foto5)
        image6=findViewById(R.id.zor1foto6)
        image7=findViewById(R.id.zor1foto7)
        image8=findViewById(R.id.zor1foto8)
        image9=findViewById(R.id.zor1foto9)
        image10=findViewById(R.id.zor1foto10)
        image11=findViewById(R.id.zor1foto11)
        image12=findViewById(R.id.zor1foto12)
        image13=findViewById(R.id.zor1foto13)
        image14=findViewById(R.id.zor1foto14)
        image15=findViewById(R.id.zor1foto15)
        image16=findViewById(R.id.zor1foto16)
        image17=findViewById(R.id.zor1foto17)
        image18=findViewById(R.id.zor1foto18)
        image19=findViewById(R.id.zor1foto19)
        image20=findViewById(R.id.zor1foto20)
        image21=findViewById(R.id.zor1foto21)
        image22=findViewById(R.id.zor1foto22)
        image23=findViewById(R.id.zor1foto23)
        image24=findViewById(R.id.zor1foto24)
        image25=findViewById(R.id.zor1foto25)
        image26=findViewById(R.id.zor1foto26)
        image27=findViewById(R.id.zor1foto27)
        image28=findViewById(R.id.zor1foto28)
        image29=findViewById(R.id.zor1foto29)
        image30=findViewById(R.id.zor1foto30)
        image31=findViewById(R.id.zor1foto31)
        image32=findViewById(R.id.zor1foto32)
        image33=findViewById(R.id.zor1foto33)
        image34=findViewById(R.id.zor1foto34)
        image35=findViewById(R.id.zor1foto35)
        image36=findViewById(R.id.zor1foto36)
        val fotolar=Array<ImageView>(36){image1}
        fotolar[1]=image2
        fotolar[2]=image3
        fotolar[3]=image4
        fotolar[4]=image5
        fotolar[5]=image6
        fotolar[6]=image7
        fotolar[7]=image8
        fotolar[8]=image9
        fotolar[9]=image10
        fotolar[10]=image11
        fotolar[11]=image12
        fotolar[12]=image13
        fotolar[13]=image14
        fotolar[14]=image15
        fotolar[15]=image16
        fotolar[16]=image17
        fotolar[17]=image18
        fotolar[18]=image19
        fotolar[19]=image20
        fotolar[20]=image21
        fotolar[21]=image22
        fotolar[22]=image23
        fotolar[23]=image24
        fotolar[24]=image25
        fotolar[25]=image26
        fotolar[26]=image27
        fotolar[27]=image28
        fotolar[28]=image29
        fotolar[29]=image30
        fotolar[30]=image31
        fotolar[31]=image32
        fotolar[32]=image33
        fotolar[33]=image34
        fotolar[34]=image35
        fotolar[35]=image36
        fotolar.shuffle()

        zor1sure=findViewById(R.id.zor1süre)
        zor1puan=findViewById(R.id.zor1puan)
        zor1karttakiisim=findViewById(R.id.zor1karttakiisim)
        click=MediaPlayer.create(this,R.raw.click)

        süre_müzik= MediaPlayer.create(this,R.raw.sure_bit)
        kazanma_müzik= MediaPlayer.create(this,R.raw.kazanma)

        for(i in fotolar){
            i.isEnabled=false
        }
        zor1sure.text="45"

        zor1basla.setOnClickListener {
            click?.start()
            zor1basla.isEnabled=false
            zor1basla.isVisible=false
            for(i in fotolar){
                i.isEnabled=true
            }

            timer=object : CountDownTimer(/* millisInFuture = */ 46000,/* countDownInterval = */ 1000){
                override fun onTick(saniye: Long) {
                    puan_sure=(saniye/1000).toDouble()
                    zor1sure.text=(saniye/1000).toString()
                    if(toplam_eslesme_sayisi==16){
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

        //Hufflepuff Veri Çekme
        db.collection("Hufflepuff")
            .get()
            .addOnCompleteListener {
                for (document in it.result!!){
                    hname[hindex]=document.data.getValue("name").toString()
                    himage[hindex]= document.data.getValue("image").toString()
                    hpoint[hindex]= document.data.getValue("point").toString()
                    hindex++
                }
            }

        //Ravenclaw Veri Çekme
        db.collection("Ravenclaw")
            .get()
            .addOnCompleteListener {
                for (document in it.result!!){
                    rname[rindex]=document.data.getValue("name").toString()
                    rimage[rindex]= document.data.getValue("image").toString()
                    rpoint[rindex]= document.data.getValue("point").toString()
                    rindex++
                }
            }

        for(i in 0..9){

            if(i==0 || i==1){
                fotolar[i].setOnClickListener{
                    fotolar[i].isEnabled=false
                    fotolar[i].setImageBitmap(img(gimage[rastgele1]))
                    sayac++
                    if(sayac==1){
                        tutucu1=fotolar[i]
                        image_tut1=gimage[rastgele1]
                        puan_tut1=gpoint[rastgele1].toInt()
                        isim_tut1=gname[rastgele1]
                        aile_tut1=ghome
                        homepoint_tut1=ghomepoint
                        zor1karttakiisim.text=isim_tut1
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
                        image_tut2=gimage[rastgele1]
                        puan_tut2=gpoint[rastgele1].toInt()
                        isim_tut2=gname[rastgele1]
                        aile_tut2=ghome
                        homepoint_tut2=ghomepoint
                        zor1karttakiisim.text=isim_tut2
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
                                zor1puan.text=(puan_son.toInt()).toString()
                            }
                            else{
                                puan_son=puan_son-((puan_tut1+puan_tut2)/2)*homepoint_tut1*homepoint_tut2*((45-puan_sure)/10)
                                zor1puan.text=(puan_son.toInt()).toString()
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
                            zor1puan.text=(puan_son.toInt()).toString()
                            toplam_eslesme_sayisi++
                            if(toplam_eslesme_sayisi==16){
                                kazanma_müzik?.start()
                            }
                        }
                    }
                }
            }

            if(i==2 || i==3){
                fotolar[i].setOnClickListener{
                    fotolar[i].isEnabled=false
                    fotolar[i].setImageBitmap(img(gimage[rastgele2]))
                    sayac++
                    if(sayac==1){
                        tutucu1=fotolar[i]
                        image_tut1=gimage[rastgele2]
                        puan_tut1=gpoint[rastgele2].toInt()
                        isim_tut1=gname[rastgele2]
                        aile_tut1=ghome
                        homepoint_tut1=ghomepoint
                        zor1karttakiisim.text=isim_tut1
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
                        image_tut2=gimage[rastgele2]
                        puan_tut2=gpoint[rastgele2].toInt()
                        isim_tut2=gname[rastgele2]
                        aile_tut2=ghome
                        homepoint_tut2=ghomepoint
                        zor1karttakiisim.text=isim_tut2
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
                                zor1puan.text=(puan_son.toInt()).toString()
                            }
                            else{
                                puan_son=puan_son-((puan_tut1+puan_tut2)/2)*homepoint_tut1*homepoint_tut2*((45-puan_sure)/10)
                                zor1puan.text=(puan_son.toInt()).toString()
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
                            zor1puan.text=(puan_son.toInt()).toString()
                            toplam_eslesme_sayisi++
                            if(toplam_eslesme_sayisi==16){
                                kazanma_müzik?.start()
                            }
                        }
                    }
                }
            }
            if(i==4 || i==5){
                fotolar[i].setOnClickListener{
                    fotolar[i].isEnabled=false
                    fotolar[i].setImageBitmap(img(gimage[rastgele3]))
                    sayac++
                    if(sayac==1){
                        tutucu1=fotolar[i]
                        image_tut1=gimage[rastgele3]
                        puan_tut1=gpoint[rastgele3].toInt()
                        isim_tut1=gname[rastgele3]
                        aile_tut1=ghome
                        homepoint_tut1=ghomepoint
                        zor1karttakiisim.text=isim_tut1
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
                        image_tut2=gimage[rastgele3]
                        puan_tut2=gpoint[rastgele3].toInt()
                        isim_tut2=gname[rastgele3]
                        aile_tut2=ghome
                        homepoint_tut2=ghomepoint
                        zor1karttakiisim.text=isim_tut2
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
                                zor1puan.text=(puan_son.toInt()).toString()
                            }
                            else{
                                puan_son=puan_son-((puan_tut1+puan_tut2)/2)*homepoint_tut1*homepoint_tut2*((45-puan_sure)/10)
                                zor1puan.text=(puan_son.toInt()).toString()
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
                            zor1puan.text=(puan_son.toInt()).toString()
                            toplam_eslesme_sayisi++
                            if(toplam_eslesme_sayisi==16){
                                kazanma_müzik?.start()
                            }
                        }
                    }
                }
            }
            if(i==6 || i==7){
                fotolar[i].setOnClickListener{
                    fotolar[i].isEnabled=false
                    fotolar[i].setImageBitmap(img(gimage[rastgele4]))
                    sayac++
                    if(sayac==1){
                        tutucu1=fotolar[i]
                        image_tut1=gimage[rastgele4]
                        puan_tut1=gpoint[rastgele4].toInt()
                        isim_tut1=gname[rastgele4]
                        aile_tut1=ghome
                        homepoint_tut1=ghomepoint
                        zor1karttakiisim.text=isim_tut1
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
                        image_tut2=gimage[rastgele4]
                        puan_tut2=gpoint[rastgele4].toInt()
                        isim_tut2=gname[rastgele4]
                        aile_tut2=ghome
                        homepoint_tut2=ghomepoint
                        zor1karttakiisim.text=isim_tut2
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
                                zor1puan.text=(puan_son.toInt()).toString()
                            }
                            else{
                                puan_son=puan_son-((puan_tut1+puan_tut2)/2)*homepoint_tut1*homepoint_tut2*((45-puan_sure)/10)
                                zor1puan.text=(puan_son.toInt()).toString()
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
                            zor1puan.text=(puan_son.toInt()).toString()
                            toplam_eslesme_sayisi++
                            if(toplam_eslesme_sayisi==16){
                                kazanma_müzik?.start()
                            }
                        }
                    }
                }
            }
            if(i==8 || i==9){
                fotolar[i].setOnClickListener{
                    fotolar[i].isEnabled=false
                    fotolar[i].setImageBitmap(img(gimage[rastgele5]))
                    sayac++
                    if(sayac==1){
                        tutucu1=fotolar[i]
                        image_tut1=gimage[rastgele5]
                        puan_tut1=gpoint[rastgele5].toInt()
                        isim_tut1=gname[rastgele5]
                        aile_tut1=ghome
                        homepoint_tut1=ghomepoint
                        zor1karttakiisim.text=isim_tut1
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
                        image_tut2=gimage[rastgele5]
                        puan_tut2=gpoint[rastgele5].toInt()
                        isim_tut2=gname[rastgele5]
                        aile_tut2=ghome
                        homepoint_tut2=ghomepoint
                        zor1karttakiisim.text=isim_tut2
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
                                zor1puan.text=(puan_son.toInt()).toString()
                            }
                            else{
                                puan_son=puan_son-((puan_tut1+puan_tut2)/2)*homepoint_tut1*homepoint_tut2*((45-puan_sure)/10)
                                zor1puan.text=(puan_son.toInt()).toString()
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
                            zor1puan.text=(puan_son.toInt()).toString()
                            toplam_eslesme_sayisi++
                            if(toplam_eslesme_sayisi==16){
                                kazanma_müzik?.start()
                            }
                        }
                    }
                }
            }

        }


        for (i in 10..19){

            if(i==10 || i==11){
                fotolar[i].setOnClickListener{
                    fotolar[i].isEnabled=false
                    fotolar[i].setImageBitmap(img(simage[rastgele1]))
                    sayac++
                    if(sayac==1){
                        tutucu1=fotolar[i]
                        image_tut1=simage[rastgele1]
                        puan_tut1=spoint[rastgele1].toInt()
                        isim_tut1=sname[rastgele1]
                        aile_tut1=shome
                        homepoint_tut1=shomepoint
                        zor1karttakiisim.text=isim_tut1
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
                        image_tut2=simage[rastgele1]
                        puan_tut2=spoint[rastgele1].toInt()
                        isim_tut2=sname[rastgele1]
                        aile_tut2=shome
                        homepoint_tut2=shomepoint
                        zor1karttakiisim.text=isim_tut2
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
                                zor1puan.text=(puan_son.toInt()).toString()
                            }
                            else{
                                puan_son=puan_son-((puan_tut1+puan_tut2)/2)*homepoint_tut1*homepoint_tut2*((45-puan_sure)/10)
                                zor1puan.text=(puan_son.toInt()).toString()
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
                            zor1puan.text=(puan_son.toInt()).toString()
                            toplam_eslesme_sayisi++
                            if(toplam_eslesme_sayisi==16){
                                kazanma_müzik?.start()
                            }
                        }
                    }
                }
            }
            if(i==12 || i==13){
                fotolar[i].setOnClickListener{
                    fotolar[i].isEnabled=false
                    fotolar[i].setImageBitmap(img(simage[rastgele2]))
                    sayac++
                    if(sayac==1){
                        tutucu1=fotolar[i]
                        image_tut1=simage[rastgele2]
                        puan_tut1=spoint[rastgele2].toInt()
                        isim_tut1=sname[rastgele2]
                        aile_tut1=shome
                        homepoint_tut1=shomepoint
                        zor1karttakiisim.text=isim_tut1
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
                        image_tut2=simage[rastgele2]
                        puan_tut2=spoint[rastgele2].toInt()
                        isim_tut2=sname[rastgele2]
                        aile_tut2=shome
                        homepoint_tut2=shomepoint
                        zor1karttakiisim.text=isim_tut2
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
                                zor1puan.text=(puan_son.toInt()).toString()
                            }
                            else{
                                puan_son=puan_son-((puan_tut1+puan_tut2)/2)*homepoint_tut1*homepoint_tut2*((45-puan_sure)/10)
                                zor1puan.text=(puan_son.toInt()).toString()
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
                            zor1puan.text=(puan_son.toInt()).toString()
                            toplam_eslesme_sayisi++
                            if(toplam_eslesme_sayisi==16){
                                kazanma_müzik?.start()
                            }
                        }
                    }
                }
            }
            if(i==14 || i==15){
                fotolar[i].setOnClickListener{
                    fotolar[i].isEnabled=false
                    fotolar[i].setImageBitmap(img(simage[rastgele3]))
                    sayac++
                    if(sayac==1){
                        tutucu1=fotolar[i]
                        image_tut1=simage[rastgele3]
                        puan_tut1=spoint[rastgele3].toInt()
                        isim_tut1=sname[rastgele3]
                        aile_tut1=shome
                        homepoint_tut1=shomepoint
                        zor1karttakiisim.text=isim_tut1
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
                        image_tut2=simage[rastgele3]
                        puan_tut2=spoint[rastgele3].toInt()
                        isim_tut2=sname[rastgele3]
                        aile_tut2=shome
                        homepoint_tut2=shomepoint
                        zor1karttakiisim.text=isim_tut2
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
                                zor1puan.text=(puan_son.toInt()).toString()
                            }
                            else{
                                puan_son=puan_son-((puan_tut1+puan_tut2)/2)*homepoint_tut1*homepoint_tut2*((45-puan_sure)/10)
                                zor1puan.text=(puan_son.toInt()).toString()
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
                            zor1puan.text=(puan_son.toInt()).toString()
                            toplam_eslesme_sayisi++
                            if(toplam_eslesme_sayisi==16){
                                kazanma_müzik?.start()
                            }
                        }
                    }
                }
            }
            if(i==16 || i==17){
                fotolar[i].setOnClickListener{
                    fotolar[i].isEnabled=false
                    fotolar[i].setImageBitmap(img(simage[rastgele4]))
                    sayac++
                    if(sayac==1){
                        tutucu1=fotolar[i]
                        image_tut1=simage[rastgele4]
                        puan_tut1=spoint[rastgele4].toInt()
                        isim_tut1=sname[rastgele4]
                        aile_tut1=shome
                        homepoint_tut1=shomepoint
                        zor1karttakiisim.text=isim_tut1
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
                        image_tut2=simage[rastgele4]
                        puan_tut2=spoint[rastgele4].toInt()
                        isim_tut2=sname[rastgele4]
                        aile_tut2=shome
                        homepoint_tut2=shomepoint
                        zor1karttakiisim.text=isim_tut2
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
                                zor1puan.text=(puan_son.toInt()).toString()
                            }
                            else{
                                puan_son=puan_son-((puan_tut1+puan_tut2)/2)*homepoint_tut1*homepoint_tut2*((45-puan_sure)/10)
                                zor1puan.text=(puan_son.toInt()).toString()
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
                            zor1puan.text=(puan_son.toInt()).toString()
                            toplam_eslesme_sayisi++
                            if(toplam_eslesme_sayisi==16){
                                kazanma_müzik?.start()
                            }
                        }
                    }
                }
            }
            if(i==18 || i==19){
                fotolar[i].setOnClickListener{
                    fotolar[i].isEnabled=false
                    fotolar[i].setImageBitmap(img(simage[rastgele5]))
                    sayac++
                    if(sayac==1){
                        tutucu1=fotolar[i]
                        image_tut1=simage[rastgele5]
                        puan_tut1=spoint[rastgele5].toInt()
                        isim_tut1=sname[rastgele5]
                        aile_tut1=shome
                        homepoint_tut1=shomepoint
                        zor1karttakiisim.text=isim_tut1
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
                        image_tut2=simage[rastgele5]
                        puan_tut2=spoint[rastgele5].toInt()
                        isim_tut2=sname[rastgele5]
                        aile_tut2=shome
                        homepoint_tut2=shomepoint
                        zor1karttakiisim.text=isim_tut2
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
                                zor1puan.text=(puan_son.toInt()).toString()
                            }
                            else{
                                puan_son=puan_son-((puan_tut1+puan_tut2)/2)*homepoint_tut1*homepoint_tut2*((45-puan_sure)/10)
                                zor1puan.text=(puan_son.toInt()).toString()
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
                            zor1puan.text=(puan_son.toInt()).toString()
                            toplam_eslesme_sayisi++
                            if(toplam_eslesme_sayisi==16){
                                kazanma_müzik?.start()
                            }
                        }
                    }
                }
            }

        }


        for(i in 20..27){

            if(i==20 ||i==21){
                fotolar[i].setOnClickListener{
                    fotolar[i].isEnabled=false
                    fotolar[i].setImageBitmap(img(himage[rastgele1]))
                    sayac++
                    if(sayac==1){
                        tutucu1=fotolar[i]
                        image_tut1=himage[rastgele1]
                        puan_tut1=hpoint[rastgele1].toInt()
                        isim_tut1=hname[rastgele1]
                        aile_tut1=hhome
                        homepoint_tut1=hhomepoint
                        zor1karttakiisim.text=isim_tut1
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
                        image_tut2=himage[rastgele1]
                        puan_tut2=hpoint[rastgele1].toInt()
                        isim_tut2=hname[rastgele1]
                        aile_tut2=hhome
                        homepoint_tut2=hhomepoint
                        zor1karttakiisim.text=isim_tut2
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
                                zor1puan.text=(puan_son.toInt()).toString()
                            }
                            else{
                                puan_son=puan_son-((puan_tut1+puan_tut2)/2)*homepoint_tut1*homepoint_tut2*((45-puan_sure)/10)
                                zor1puan.text=(puan_son.toInt()).toString()
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
                            zor1puan.text=(puan_son.toInt()).toString()
                            toplam_eslesme_sayisi++
                            if(toplam_eslesme_sayisi==16){
                                kazanma_müzik?.start()
                            }
                        }
                    }
                }
            }
            if(i==22 ||i==23){
                fotolar[i].setOnClickListener{
                    fotolar[i].isEnabled=false
                    fotolar[i].setImageBitmap(img(himage[rastgele2]))
                    sayac++
                    if(sayac==1){
                        tutucu1=fotolar[i]
                        image_tut1=himage[rastgele2]
                        puan_tut1=hpoint[rastgele2].toInt()
                        isim_tut1=hname[rastgele2]
                        aile_tut1=hhome
                        homepoint_tut1=hhomepoint
                        zor1karttakiisim.text=isim_tut1
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
                        image_tut2=himage[rastgele2]
                        puan_tut2=hpoint[rastgele2].toInt()
                        isim_tut2=hname[rastgele2]
                        aile_tut2=hhome
                        homepoint_tut2=hhomepoint
                        zor1karttakiisim.text=isim_tut2
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
                                zor1puan.text=(puan_son.toInt()).toString()
                            }
                            else{
                                puan_son=puan_son-((puan_tut1+puan_tut2)/2)*homepoint_tut1*homepoint_tut2*((45-puan_sure)/10)
                                zor1puan.text=(puan_son.toInt()).toString()
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
                            zor1puan.text=(puan_son.toInt()).toString()
                            toplam_eslesme_sayisi++
                            if(toplam_eslesme_sayisi==16){
                                kazanma_müzik?.start()
                            }
                        }
                    }
                }
            }
            if(i==24 ||i==25){
                fotolar[i].setOnClickListener{
                    fotolar[i].isEnabled=false
                    fotolar[i].setImageBitmap(img(himage[rastgele3]))
                    sayac++
                    if(sayac==1){
                        tutucu1=fotolar[i]
                        image_tut1=himage[rastgele3]
                        puan_tut1=hpoint[rastgele3].toInt()
                        isim_tut1=hname[rastgele3]
                        aile_tut1=hhome
                        homepoint_tut1=hhomepoint
                        zor1karttakiisim.text=isim_tut1
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
                        image_tut2=himage[rastgele3]
                        puan_tut2=hpoint[rastgele3].toInt()
                        isim_tut2=hname[rastgele3]
                        aile_tut2=hhome
                        homepoint_tut2=hhomepoint
                        zor1karttakiisim.text=isim_tut2
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
                                zor1puan.text=(puan_son.toInt()).toString()
                            }
                            else{
                                puan_son=puan_son-((puan_tut1+puan_tut2)/2)*homepoint_tut1*homepoint_tut2*((45-puan_sure)/10)
                                zor1puan.text=(puan_son.toInt()).toString()
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
                            zor1puan.text=(puan_son.toInt()).toString()
                            toplam_eslesme_sayisi++
                            if(toplam_eslesme_sayisi==16){
                                kazanma_müzik?.start()
                            }
                        }
                    }
                }
            }
            if(i==26 ||i==27){
                fotolar[i].setOnClickListener{
                    fotolar[i].isEnabled=false
                    fotolar[i].setImageBitmap(img(himage[rastgele4]))
                    sayac++
                    if(sayac==1){
                        tutucu1=fotolar[i]
                        image_tut1=himage[rastgele4]
                        puan_tut1=hpoint[rastgele4].toInt()
                        isim_tut1=hname[rastgele4]
                        aile_tut1=hhome
                        homepoint_tut1=hhomepoint
                        zor1karttakiisim.text=isim_tut1
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
                        image_tut2=himage[rastgele4]
                        puan_tut2=hpoint[rastgele4].toInt()
                        isim_tut2=hname[rastgele4]
                        aile_tut2=hhome
                        homepoint_tut2=hhomepoint
                        zor1karttakiisim.text=isim_tut2
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
                                zor1puan.text=(puan_son.toInt()).toString()
                            }
                            else{
                                puan_son=puan_son-((puan_tut1+puan_tut2)/2)*homepoint_tut1*homepoint_tut2*((45-puan_sure)/10)
                                zor1puan.text=(puan_son.toInt()).toString()
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
                            zor1puan.text=(puan_son.toInt()).toString()
                            toplam_eslesme_sayisi++
                            if(toplam_eslesme_sayisi==16){
                                kazanma_müzik?.start()
                            }
                        }
                    }
                }
            }

        }



        for(i in 28..35){

            if(i==28 || i==29){
                fotolar[i].setOnClickListener{
                    fotolar[i].isEnabled=false
                    fotolar[i].setImageBitmap(img(rimage[rastgele1]))
                    sayac++
                    if(sayac==1){
                        tutucu1=fotolar[i]
                        image_tut1=rimage[rastgele1]
                        puan_tut1=rpoint[rastgele1].toInt()
                        isim_tut1=rname[rastgele1]
                        aile_tut1=rhome
                        homepoint_tut1=rhomepoint
                        zor1karttakiisim.text=isim_tut1
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
                        image_tut2=rimage[rastgele1]
                        puan_tut2=rpoint[rastgele1].toInt()
                        isim_tut2=rname[rastgele1]
                        aile_tut2=rhome
                        homepoint_tut2=rhomepoint
                        zor1karttakiisim.text=isim_tut2
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
                                zor1puan.text=(puan_son.toInt()).toString()
                            }
                            else{
                                puan_son=puan_son-((puan_tut1+puan_tut2)/2)*homepoint_tut1*homepoint_tut2*((45-puan_sure)/10)
                                zor1puan.text=(puan_son.toInt()).toString()
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
                            zor1puan.text=(puan_son.toInt()).toString()
                            toplam_eslesme_sayisi++
                            if(toplam_eslesme_sayisi==16){
                                kazanma_müzik?.start()
                            }
                        }
                    }
                }
            }
            if(i==30 || i==31){
                fotolar[i].setOnClickListener{
                    fotolar[i].isEnabled=false
                    fotolar[i].setImageBitmap(img(rimage[rastgele2]))
                    sayac++
                    if(sayac==1){
                        tutucu1=fotolar[i]
                        image_tut1=rimage[rastgele2]
                        puan_tut1=rpoint[rastgele2].toInt()
                        isim_tut1=rname[rastgele2]
                        aile_tut1=rhome
                        homepoint_tut1=rhomepoint
                        zor1karttakiisim.text=isim_tut1
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
                        image_tut2=rimage[rastgele2]
                        puan_tut2=rpoint[rastgele2].toInt()
                        isim_tut2=rname[rastgele2]
                        aile_tut2=rhome
                        homepoint_tut2=rhomepoint
                        zor1karttakiisim.text=isim_tut2
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
                                zor1puan.text=(puan_son.toInt()).toString()
                            }
                            else{
                                puan_son=puan_son-((puan_tut1+puan_tut2)/2)*homepoint_tut1*homepoint_tut2*((45-puan_sure)/10)
                                zor1puan.text=(puan_son.toInt()).toString()
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
                            zor1puan.text=(puan_son.toInt()).toString()
                            toplam_eslesme_sayisi++
                            if(toplam_eslesme_sayisi==16){
                                kazanma_müzik?.start()
                            }
                        }
                    }
                }
            }
            if(i==32 || i==33){
                fotolar[i].setOnClickListener{
                    fotolar[i].isEnabled=false
                    fotolar[i].setImageBitmap(img(rimage[rastgele3]))
                    sayac++
                    if(sayac==1){
                        tutucu1=fotolar[i]
                        image_tut1=rimage[rastgele3]
                        puan_tut1=rpoint[rastgele3].toInt()
                        isim_tut1=rname[rastgele3]
                        aile_tut1=rhome
                        homepoint_tut1=rhomepoint
                        zor1karttakiisim.text=isim_tut1
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
                        image_tut2=rimage[rastgele3]
                        puan_tut2=rpoint[rastgele3].toInt()
                        isim_tut2=rname[rastgele3]
                        aile_tut2=rhome
                        homepoint_tut2=rhomepoint
                        zor1karttakiisim.text=isim_tut2
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
                                zor1puan.text=(puan_son.toInt()).toString()
                            }
                            else{
                                puan_son=puan_son-((puan_tut1+puan_tut2)/2)*homepoint_tut1*homepoint_tut2*((45-puan_sure)/10)
                                zor1puan.text=(puan_son.toInt()).toString()
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
                            zor1puan.text=(puan_son.toInt()).toString()
                            toplam_eslesme_sayisi++
                            if(toplam_eslesme_sayisi==16){
                                kazanma_müzik?.start()
                            }
                        }
                    }
                }
            }
            if(i==34 || i==35){
                fotolar[i].setOnClickListener{
                    fotolar[i].isEnabled=false
                    fotolar[i].setImageBitmap(img(rimage[rastgele4]))
                    sayac++
                    if(sayac==1){
                        tutucu1=fotolar[i]
                        image_tut1=rimage[rastgele4]
                        puan_tut1=rpoint[rastgele4].toInt()
                        isim_tut1=rname[rastgele4]
                        aile_tut1=rhome
                        homepoint_tut1=rhomepoint
                        zor1karttakiisim.text=isim_tut1
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
                        image_tut2=rimage[rastgele4]
                        puan_tut2=rpoint[rastgele4].toInt()
                        isim_tut2=rname[rastgele4]
                        aile_tut2=rhome
                        homepoint_tut2=rhomepoint
                        zor1karttakiisim.text=isim_tut2
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
                                zor1puan.text=(puan_son.toInt()).toString()
                            }
                            else{
                                puan_son=puan_son-((puan_tut1+puan_tut2)/2)*homepoint_tut1*homepoint_tut2*((puan_sure)/10)
                                zor1puan.text=(puan_son.toInt()).toString()
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
                            zor1puan.text=(puan_son.toInt()).toString()
                            toplam_eslesme_sayisi++
                            if(toplam_eslesme_sayisi==16){
                                kazanma_müzik?.start()
                            }
                        }
                    }
                }
            }

        }











    }
}