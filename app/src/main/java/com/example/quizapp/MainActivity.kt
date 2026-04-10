package com.example.quizapp

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private  lateinit var  binding: ActivityMainBinding
    private  var rightAnswer: String?=null
    private  var rightAnswerCount=0
    private  var quizCount=1

    private val quizData = mutableListOf(
        mutableListOf("北海道", "札幌市", "長崎市", "福島市", "前橋市"),
        mutableListOf("青森県", "青森市", "広島市", "甲府市", "岡山市"),
        mutableListOf("岩手県", "盛岡市", "大分市", "秋田市", "福岡市"),
        mutableListOf("宮城県", "仙台市", "水戸市", "岐阜市", "福井市"),
        mutableListOf("秋田県", "秋田市", "横浜市", "鳥取市", "仙台市"),
        mutableListOf("山形県", "山形市", "青森市", "山口市", "奈良市"),
        mutableListOf("福島県", "福島市", "盛岡市", "新宿区", "京都市"),
        mutableListOf("茨城県", "水戸市", "金沢市", "名古屋市", "奈良市"),
        mutableListOf("栃木県", "宇都宮市", "札幌市", "岡山市", "奈良市"),
        mutableListOf("群馬県", "前橋市", "福岡市", "松江市", "福井市")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate((layoutInflater))
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.answerBtn1.setOnClickListener { checkAnswer(it) }
        binding.answerBtn2.setOnClickListener { checkAnswer(it) }
        binding.answerBtn3.setOnClickListener { checkAnswer(it) }
        binding.answerBtn4.setOnClickListener { checkAnswer(it) }

        quizData.shuffle()

        showNextQuiz()
    }

    //クイズを出題する
    private  fun showNextQuiz(){
        //クイズを1問取り出す
        val quiz=quizData[0]

        //問題をセット
        binding.questionLabel.text=quiz[0]

        //正解をセット
        rightAnswer=quiz[1]

        //都道府県名を削除
        quiz.removeAt(0)

        //正解と選択肢3つをシャッフル
        quiz.shuffle()

        //選択ををセット
        binding.answerBtn1.text=quiz[1]
        binding.answerBtn2.text=quiz[2]
        binding.answerBtn3.text=quiz[3]
        binding.answerBtn4.text=quiz[4]

        //出題したクイズを削除する
        quizData.removeAt(0)
    }

    //解答ボタンが押されたら呼ばれる
    private  fun checkAnswer(View: View){
    }

    //出題数をチェックする
    private  fun checkQuizCount(){
    }
}