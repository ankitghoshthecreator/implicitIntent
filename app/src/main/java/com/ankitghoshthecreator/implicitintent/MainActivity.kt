package com.ankitghoshthecreator.implicitintent

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val camBtn=findViewById<Button>(R.id.cam)

        val ytBtn=findViewById<Button>(R.id.yt)

        camBtn.setOnClickListener {
            intent= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)


        }

        ytBtn.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW)
            intent.data= Uri.parse("https://www.youtube.com/")
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}