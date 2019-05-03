package com.vytran.catchgudetama

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var score: Int = 0
    var imageArray = ArrayList<ImageView>()
    var handler : Handler = Handler()
    var runnable : Runnable = Runnable{ }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        score = 0

        imageArray = arrayListOf(imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7,
                                 imageView8, imageView9, imageView10, imageView11, imageView12);

        hideImages()

        val sharedPreferences = this.getSharedPreferences("com.vytran.catchgudetama", android.content.Context.MODE_PRIVATE)


        object : CountDownTimer(60000, 1000) {
            override fun onFinish() {
                timeText.text = "Time's OFF!"
                handler.removeCallbacks(runnable)
                for (image in imageArray) {
                    image.visibility = View.INVISIBLE
                }

                val intent = Intent(applicationContext, GameOverActivity::class.java)
                intent.putExtra("input", scoreText.text.toString())
                startActivity(intent)

            }

            override fun onTick(p0: Long) {
                timeText.text = "Time: " + p0/1000

            }
        }.start()
    }

    fun increaseScore(view: View) {
        score++
        scoreText.text = "Score: " + score
    }

    fun hideImages() {

        runnable = object : Runnable {
            override fun run() {
                //make image invisible
                for (image in imageArray) {
                    image.visibility = View.INVISIBLE
                }

                val random = Random()
                val index = random.nextInt(11-0)
                imageArray[index].visibility = View.VISIBLE

                handler.postDelayed(runnable, 300)
            }
        }
        handler.post(runnable)

    }


}
