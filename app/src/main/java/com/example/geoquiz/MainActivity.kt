package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

private lateinit var true_button:Button
private lateinit var false_button:Button
private lateinit var next_button:ImageButton
private lateinit var previous_button:ImageButton
private lateinit var questionTextView:TextView

private val questionBank = listOf(Question(R.string.question_australia,true),
    Question(R.string.question_australia,true),
    Question(R.string.question_oceans,true),
    Question(R.string.question_Russia,true),
    Question(R.string.question_africa,false),
    Question(R.string.question_americas,true),
    Question(R.string.question_asia,true)
)

private var currentindex = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        true_button = findViewById(R.id.true_button)
        false_button = findViewById(R.id.false_button)
        next_button = findViewById(R.id.next_button)
        previous_button = findViewById(R.id.previous_button)
        questionTextView = findViewById(R.id.questionTextView)

        true_button.setOnClickListener{
            if (questionBank[currentindex].answer){
            val toast = Toast.makeText(this, R.string.correct, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.show();
            }
        }

        false_button.setOnClickListener{
            if (!questionBank[currentindex].answer) {
                val message2 = Toast.makeText(this, R.string.incorrect, Toast.LENGTH_SHORT);
                message2.setGravity(Gravity.TOP, 0, 0);
                message2.show();
            }
        }

        val questionTextResId = questionBank[currentindex].textResId
        questionTextView.setText(questionTextResId)

        next_button.setOnClickListener{
            currentindex=(currentindex+1) % questionBank.size
            val questionTextResId = questionBank[currentindex].textResId
            questionTextView.setText(questionTextResId)
        }

        previous_button.setOnClickListener{
            if (currentindex==0) {
                val questionTextResId = questionBank[0].textResId
                questionTextView.setText(questionTextResId)
            }
            else {
                currentindex = ((currentindex - 1) % questionBank.size)
                val questionTextResId = questionBank[currentindex].textResId
                questionTextView.setText(questionTextResId)
            }
        }
    }
}