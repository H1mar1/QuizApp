package com.example.quizapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.databinding.ActivityResultBinding
import  android.content.Intent

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.resultLabel)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //正解数を取得
        val score = intent.getIntExtra("RIGHT_ANSWER_COUNT", 0)

        //トータルスコアの読み出し
        val prefs = getPreferences(MODE_PRIVATE)
        var totalScore = prefs.getInt("TOTAL_SCORE", 0)

        //トータルスコアに今回のスコアを加算
        totalScore += score


//TextViewに表示する
        binding.resultLabel.text = getString(R.string.result_score, score)
        binding.totalScoreLabel.text = getString(R.string.result_total_score, totalScore)

        //トータルスコアを保存
        val editor = prefs.edit()
        editor.putInt("TOTAL_SCORE", totalScore)
        editor.apply()

//もどるボタン
        binding.returnBtn.setOnClickListener {
            startActivity(Intent(this@ResultActivity, MainActivity::class.java))

        }
    }
}