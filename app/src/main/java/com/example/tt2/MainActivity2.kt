package com.example.tt2

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp


class MainActivity2 : ComponentActivity() {
    val logger = Logger()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val counter = intent.getIntExtra("number", 0)
        val square = counter*counter

        setContent {
            Column(
                modifier =
                Modifier
                    .fillMaxSize()
                    .background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Text(
                    text = square.toString(),
                    fontSize = 52.sp
                )
                Button(
                    onClick ={
                        val intent = Intent(this@MainActivity2, MainActivity::class.java)
                        startActivity(intent)
                    }
                ) {
                    Text(
                        text = "<=",
                        fontSize = 69.sp,
                    )
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        logger.log("MA2 onStart")
    }

    override fun onResume() {
        super.onResume()
        logger.log("MA2 onResume")
    }

    override fun onPause() {
        super.onPause()
        logger.log("MA2 onPause")
    }

    override fun onStop() {
        super.onStop()
        logger.log("MA2 onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        logger.log("MA2 onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        logger.log("MA2 onRestart")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        logger.log("MA2 onConfigurationChanged")
    }
}
