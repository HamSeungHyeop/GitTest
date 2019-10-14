package com.example.gittest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.act_one.*

class IntentOneAct : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_one)

        if (intent.hasExtra("Edt1"))
            txt1.text = intent.getStringExtra("Edt1")
    }
}