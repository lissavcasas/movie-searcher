/**/package com.activityexample.activitycycle

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("LIFECYCLE", "este es el onCreate")
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "este es OnStart! :D", Toast.LENGTH_SHORT).show()
        Log.e("LIFECYCLE", "este es el onStart")
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "este es OnResume! :D", Toast.LENGTH_SHORT).show()
        Log.e("LIFECYCLE", "este es el onResume")

    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "este es OnPause! :D", Toast.LENGTH_SHORT).show()
        Log.e("LIFECYCLE", "este es el onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "este es OnDestroy! :D", Toast.LENGTH_SHORT).show()
        Log.e("LIFECYCLE", "este es el onDestroy")
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "este es OnStop! :D", Toast.LENGTH_SHORT).show()
        Log.e("LIFECYCLE", "este es el onStop")
    }
}
