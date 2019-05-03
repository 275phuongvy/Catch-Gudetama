package com.vytran.catchgudetama

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game_over.*

class GameOverActivity : AppCompatActivity() {

    var storedScore : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)
        val intent = intent
        val received: String = intent.getStringExtra("input")
        textView.text = received
    }

    //CHANGE BETWEEN ACTIVITIES
    fun goBack(view: View) {
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }

}
