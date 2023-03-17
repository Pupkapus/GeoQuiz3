<p align = "center">МИНИСТЕРСТВО НАУКИ И ВЫСШЕГО ОБРАЗОВАНИЯ
РОССИЙСКОЙ ФЕДЕРАЦИИ
ФЕДЕРАЛЬНОЕ ГОСУДАРСТВЕННОЕ БЮДЖЕТНОЕ
ОБРАЗОВАТЕЛЬНОЕ УЧРЕЖДЕНИЕ ВЫСШЕГО ОБРАЗОВАНИЯ
«САХАЛИНСКИЙ ГОСУДАРСТВЕННЫЙ УНИВЕРСИТЕТ»</p>
<br>
<p align = "center">Институт естественных наук и техносферной безопасности</p>
<p align = "center">Кафедра информатики</p>
<p align = "center">Пак Никита Витальевич</p>
<br>
<p align = "center">Лабораторная работа №3</p>
<p align = "center">«Жизненный цикл activity»</p>
<p align = "center">01.03.02 Прикладная математика и информатика</p>
<br>
<p align = "right" >Научный руководитель</p>
<p align = "right" >Соболев Евгений Игоревич</p>
<p align = "center" >Южно-Сахалинск</p>
<p align = "center" >2023 г.</p>
<p align = "center" ><b>ВВЕДЕНИЕ</b></p>
<p>Kotlin (Ко́тлин) — статически типизированный, объектно-ориентированный язык программирования, работающий поверх Java Virtual Machine и разрабатываемый компанией JetBrains. Также компилируется в JavaScript и в исполняемый код ряда платформ через инфраструктуру LLVM. Язык назван в честь острова Котлин в Финском заливе, на котором расположен город Кронштадт</p>
<p>Авторы ставили целью создать язык более лаконичный и типобезопасный, чем Java, и более простой, чем Scala[4]. Следствием упрощения по сравнению со Scala стали также более быстрая компиляция и лучшая поддержка языка в IDE[5]. Язык полностью совместим с Java, что позволяет Java-разработчикам постепенно перейти к его использованию; в частности, язык также встраивается Android, что позволяет для существующего Android-приложения внедрять новые функции на Kotlin без переписывания приложения целиком.</p>
<p align = "center" >РЕШЕНИЕ ЗАДАЧ</p>

```kotlin
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
    Question(R.string.question_oceans,true),
    Question(R.string.question_Russia,true),
    Question(R.string.question_africa,false),
    Question(R.string.question_americas,false),
    Question(R.string.question_asia,true)
)
private var currentindex = 0
private val answers = IntArray(questionBank.size)
private val check = BooleanArray(questionBank.size)

class MainActivity : AppCompatActivity() {
    private fun checkinganswer(){
        var temp = true
        for (i in answers)
        {
            if (i==0)
            {
                temp = false
            }
        }
        if (temp)
        {
            var trueanswer = 0
            for(i in check) {
                if (i) {
                    trueanswer = trueanswer + 1
                }
            }
            var result = trueanswer * 100 / questionBank.size
            Toast.makeText(this, "$result% правильных ответов", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        true_button = findViewById(R.id.true_button)
        false_button = findViewById(R.id.false_button)
        next_button = findViewById(R.id.next_button)
        previous_button = findViewById(R.id.previous_button)
        questionTextView = findViewById(R.id.questionTextView)



        questionTextView.setOnClickListener{
            if (currentindex<5) {
                currentindex = (currentindex + 1) % questionBank.size
                val questionTextResId = questionBank[currentindex].textResId
                questionTextView.setText(questionTextResId)
                if (answers[currentindex] == 0) {
                    true_button.isEnabled = true
                    false_button.isEnabled = true
                }
                else {
                    true_button.isEnabled = false
                    false_button.isEnabled = false
                }
            }
        }

        true_button.setOnClickListener{
            if (questionBank[currentindex].answer){
                val toast = Toast.makeText(this, R.string.correct, Toast.LENGTH_SHORT);
                toast.show();
                check[currentindex]=true
            }
            else{
                val toast = Toast.makeText(this, R.string.incorrect, Toast.LENGTH_SHORT);
                toast.show();
            }
            true_button.isEnabled=false
            false_button.isEnabled=false
            answers[currentindex]=1
            checkinganswer()
        }

        false_button.setOnClickListener{
            if (!questionBank[currentindex].answer) {
                val message2 = Toast.makeText(this, R.string.correct, Toast.LENGTH_SHORT);
                message2.show()
                check[currentindex]=true
            }
            else{
                val message2 = Toast.makeText(this, R.string.incorrect, Toast.LENGTH_SHORT);
                message2.show();
            }
            answers[currentindex]=1
            true_button.isEnabled=false
            false_button.isEnabled=false
            answers[currentindex] = 1
            checkinganswer()
        }

        val questionTextResId = questionBank[currentindex].textResId
        questionTextView.setText(questionTextResId)

        next_button.setOnClickListener{
            if (currentindex<5) {
                currentindex = (currentindex + 1) % questionBank.size
                val questionTextResId = questionBank[currentindex].textResId
                questionTextView.setText(questionTextResId)
                if (answers[currentindex] == 0) {
                    true_button.isEnabled = true
                    false_button.isEnabled = true
                }
                else {
                    true_button.isEnabled = false
                    false_button.isEnabled = false
                }
            }
        }

        previous_button.setOnClickListener{
            if (currentindex==0) {

            }
            else {
                currentindex = ((currentindex - 1) % questionBank.size)
                val questionTextResId = questionBank[currentindex].textResId
                questionTextView.setText(questionTextResId)
                if (answers[currentindex] == 0) {
                    true_button.isEnabled = true
                    false_button.isEnabled = true
                }
                else {
                    true_button.isEnabled = false
                    false_button.isEnabled = false
                }
            }
        }
    }
}


```
***
<p align = "center" >ВЫВОД</p>
<p>Подводя итог всему сказанному, могу сделать вывод, что, поработав c kotlin, я узнал многое и применил это на практике. Все задачи были выполнены.</p>
