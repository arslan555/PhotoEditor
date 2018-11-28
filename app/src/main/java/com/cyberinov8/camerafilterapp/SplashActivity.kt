package com.cyberinov8.camerafilterapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.view.View
import android.support.v4.util.Pair
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast



class SplashActivity : AppCompatActivity(), Runnable {

    var imageView:ImageView?=null
    var textView:TextView?=null
    var context:Context ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        context = this@SplashActivity

        imageView = findViewById(R.id.imageView)
        textView = findViewById(R.id.textView)
        val timer = Thread(this)
        timer.start()
    }

    override fun run() {
        try {
            Thread.sleep(3000)
        } catch (e: Exception) {
        } finally {

            runOnUiThread(Runnable {
                val startingPoint = Intent(this, LoginActivity::class.java)
                startingPoint.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                val pair1: Pair<View, String> = Pair.create(imageView, "image")
                val pair2: Pair<View, String> = Pair.create(textView, "text")
                val options: ActivityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(context as Activity, pair1, pair2)
                startActivity(startingPoint,options.toBundle())
                this.finish()
            })
        }
    }
}