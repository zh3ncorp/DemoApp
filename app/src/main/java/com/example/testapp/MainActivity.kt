package com.example.testapp

import Data.Balcony
import Data.Bathroom
import Data.Kitchen
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import okhttp3.*
import java.io.IOException
@SuppressLint("SetTextI18n")

class MainActivity : AppCompatActivity() {
    val client = OkHttpClient()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainBtn: Button = findViewById(R.id.next_act_btn)
        val kitchenDegrees: TextView = findViewById(R.id.kitchen_deg)
        val bathroomDegrees: TextView = findViewById(R.id.bathroom_deg)
        val balconyDegrees: TextView = findViewById(R.id.balcony_deg)

        val kitchenUrl = "http://62.140.234.197:9087/get/zigbee.0.00158d0001b8d4fd.temperature"
        val bathroomUrl = "http://62.140.234.197:9087/get/zigbee.0.00158d0002273f3b.temperature"
        val balconyUrl = "http://62.140.234.197:9087/get/zigbee.0.00158d00022cba3a.temperature"

        mainBtn.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }

        fun setDeg(room: String){
            when (room) {
                "kitchen" -> {
                    val request = Request.Builder().url(kitchenUrl).build()
                    client.newCall(request).enqueue(object : Callback {
                        override fun onFailure(call: Call, e: IOException) {}
                        override fun onResponse(call: Call, response: Response) {
                            val jsonString = response.body?.string()
                            val data = Json.decodeFromString<Kitchen>(jsonString.toString())
                            kitchenDegrees.text = "Кухня: " + data.valX + data.common.unit
                        }
                    })
                }
                "bathroom" -> {
                    val request = Request.Builder().url(bathroomUrl).build()
                    client.newCall(request).enqueue(object : Callback {
                        override fun onFailure(call: Call, e: IOException) {}
                        override fun onResponse(call: Call, response: Response) {
                            val jsonString = response.body?.string()
                            val data = Json.decodeFromString<Bathroom>(jsonString.toString())
                            bathroomDegrees.text = "Ванная: " + data.valX + data.common.unit
                        }
                    })
                }
                "balcony" -> {
                    val request = Request.Builder().url(balconyUrl).build()
                    client.newCall(request).enqueue(object : Callback {
                        override fun onFailure(call: Call, e: IOException) {}
                        override fun onResponse(call: Call, response: Response) {
                            val jsonString = response.body?.string()
                            val data = Json.decodeFromString<Balcony>(jsonString.toString())
                            balconyDegrees.text = "Балкон: " + data.valX + data.common.unit
                        }
                    })
                }
            }
        }
        setDeg("kitchen")
        setDeg("bathroom")
        setDeg("balcony")
    }
}