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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp


/**
 * У меня эмулятор жестко чет лагает после обновы, надеюсь все что ниже вообще работает...
 */
class MainActivity : ComponentActivity() {

    val logger = Logger()
    private var configurationChangesCounter = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column(
                modifier =
                Modifier
                    .fillMaxSize()
                    .background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                val counter = remember{ mutableIntStateOf(configurationChangesCounter) }

                Text(
                    text = counter.value.toString(),
                    fontSize = 42.sp
                )

                Button(
                    onClick ={
                        val intent = Intent(this@MainActivity, MainActivity2::class.java)
                        intent.putExtra("number", configurationChangesCounter)
                        startActivity(intent)
                    }
                ) {
                    Text(
                        text = "=>",
                        fontSize = 69.sp,
                    )
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        logger.log("MA onStart")
    }

    override fun onResume() {
        super.onResume()
        logger.log("MA onResume")
    }

    override fun onPause() {
        super.onPause()
        logger.log("MA onPause")
    }

    override fun onStop() {
        super.onStop()
        logger.log("MA onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        logger.log("MA onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        logger.log("MA onRestart")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        configurationChangesCounter++;
        logger.log("MA onConfigurationChanged")
    }
}
