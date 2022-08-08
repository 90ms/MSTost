package com.a90ms.mstost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.a90ms.mstoast.MsToast.Companion.toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toast("lib module test")
    }
}