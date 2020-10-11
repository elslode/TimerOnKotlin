package slode.elsloude.timerTool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.TextView
import androidx.core.os.HandlerCompat.postDelayed
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var seconds = 0
    var isRunning: Boolean = false
    private lateinit var textViewTimer: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewTimer = findViewById(R.id.textViewTimer)
        runTimer()
    }

    fun startTimeCounter(view: View) {
        isRunning = true
    }

    fun stopTimerCounter(view: View) {
        isRunning = false
    }

    fun restartOnClickCounter(view: View) {
        isRunning = false
        seconds = 0
    }

    fun runTimer() {
        Handler().apply {
            val runnable = object : Runnable {
                override fun run() {
                    val hours: Int = seconds / 3600
                    val minutes: Int = (seconds % 3600) / 60
                    var secs: Int = seconds % 60
                    val time: String =
                        String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs)
                    textViewTimer.text = time
                    if (isRunning) {
                        seconds++
                    }
                    postDelayed(this, 1000)
                }
            }
            postDelayed(runnable, 1000)
        }
    }
}

