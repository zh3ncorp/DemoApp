package com.example.testapp

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import java.io.IOException

class MapActivity : AppCompatActivity() {
    val client = OkHttpClient()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val urlOn = "http://192.168.0.114:8087/set/0_userdata.0.Люстра_Зал?value=1"
        val urlOff = "http://192.168.0.114:8087/set/0_userdata.0.Люстра_Зал?value=0"
        val flag = object {
            var kitchen = true
            var bathroom = true
            var balcony = true
        }

        val lightbulbKitchen: ImageButton = findViewById(R.id.lightbulb_kitchen)
        lightbulbKitchen.setOnClickListener {
            if(flag.kitchen){
                lightbulbKitchen.setImageResource(R.drawable.ic_lightbulb_on)
                flag.kitchen = !flag.kitchen
                val request = Request.Builder().url(urlOn).build()
                client.newCall(request).enqueue(object : Callback {
                    override fun onFailure(call: Call, e: IOException) {}
                    override fun onResponse(call: Call, response: Response) {}
                })
            }
            else{
                lightbulbKitchen.setImageResource(R.drawable.ic_lightbulb_off)
                flag.kitchen = !flag.kitchen
                val request = Request.Builder().url(urlOff).build()
                client.newCall(request).enqueue(object : Callback {
                    override fun onFailure(call: Call, e: IOException) {}
                    override fun onResponse(call: Call, response: Response) {}
                })
            }
        }

        val lightbulbBathroom: ImageButton = findViewById(R.id.lightbulb_bathroom)
        lightbulbBathroom.setOnClickListener {
            if(flag.bathroom){
                lightbulbBathroom.setImageResource(R.drawable.ic_lightbulb_on)
                flag.bathroom = !flag.bathroom
            }
            else{
                lightbulbBathroom.setImageResource(R.drawable.ic_lightbulb_off)
                flag.bathroom = !flag.bathroom
            }
        }

        val lightbulbBalcony: ImageButton = findViewById(R.id.lightbulb_balcony)
        lightbulbBalcony.setOnClickListener {
            if(flag.balcony){
                lightbulbBalcony.setImageResource(R.drawable.ic_lightbulb_on)
                flag.balcony = !flag.balcony
            }
            else{
                lightbulbBalcony.setImageResource(R.drawable.ic_lightbulb_off)
                flag.balcony = !flag.balcony
            }
        }
        val backBtn: ImageButton = findViewById(R.id.back_btn)

        backBtn.setOnClickListener {
            finish()
        }
    }
}
