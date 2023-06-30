package com.example.summerpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowInsets.Side.all
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val but :Button = findViewById<Button>(R.id.button)
        val arg1:EditText = findViewById<EditText>(R.id.editTextText)
        val arg2:EditText = findViewById<EditText>(R.id.editTextNumber)
        val arg3:EditText = findViewById<EditText>(R.id.editTextNumber2)
        val arg4:EditText = findViewById<EditText>(R.id.editTextNumber3)
        val arg5:RadioGroup = findViewById(R.id.radioGroup)
        val rezult:TextView =findViewById(R.id.textView3)
        var gender:Boolean = false
        but.setOnClickListener {
            Log.e("Test", "Click")
            if(correct(arg1, arg2, arg3,arg4)){
                arg5.setOnCheckedChangeListener { group, checkedId ->
                    val selectedRadioButton = findViewById<RadioButton>(checkedId)
                    selectedRadioButton?.let {
                        if(correctGender(it)) {
                            if (it.text.toString().equals("Female")) {
                                gender = true
                            }
                        }else{
                            rezult.text = "Mistake"
                        }
                    }
                }
                if(gender) {
                    if(arg1.text.toString() == "yourDeveloper"){
                        rezult.text = "you are the best woman in the world"
                    }else {
                        rezult.text = "you are very cool baby "+
                        (coolnessPercentage(
                            arg1.text.toString(),
                            arg2.text.toString().toDouble(),
                            arg3.text.toString().toInt(),
                            arg4.text.toString().toInt()
                        ) + 1000000).toString() + "%"
                    }
                }else{
                    if(arg1.text.toString().equals( "Timur")){
                        rezult.text = "MURMURMUR"
                    }else{
                        if(arg4.text.toString().toInt() >= 30){
                            if(arg2.text.toString().toDouble() >= 105){
                                rezult.text = "you are MASIK, thanks for your for logging into tha app(1000000000%)"
                            }else{
                                rezult.text = "oh, you look like Serkan Bolat(1000%)"
                            }
                        }else{
                            rezult.text = "TYBIK, close the app (" + (coolnessPercentage(
                                arg1.text.toString(),
                                arg2.text.toString().toDouble(),
                                arg3.text.toString().toInt(),
                                arg4.text.toString().toInt()
                            )- 1000000).toString() + "%)"
                        }
                    }
                }
            }else{
                rezult.text = "Mistakes"
            }
        }
    }
    fun correct(arg1:EditText, arg2: EditText, arg3:EditText, arg4: EditText):Boolean{
        if(correctArg1(arg1) && correctArg2(arg2) && correctArg3(arg3) && correctArg4(arg4) ){
            return true
        }
        return false
    }
    fun correctGender(arg1:RadioButton?):Boolean{
        if(arg1 != null && arg1 is RadioButton && arg1.text.toString() != null){
            return true
        }
        return false
    }
    fun correctArg1(arg : EditText):Boolean{
        if(!(arg.text.toString().isEmpty())){
            return true
        }
        return false
    }
    fun correctArg2(arg : EditText):Boolean{
        if(!(arg.text.toString().isEmpty()) != null && arg.text.toString().toDouble() > 0 && arg.text.toString().toDouble()<250){
            return true
        }
        return false
    }
    fun correctArg3(arg : EditText):Boolean{
        if(!(arg.text.toString().isEmpty()) != null && arg.text.toString().toInt()>0 && arg.text.toString().toInt()<250){
            return true
        }
        return false
    }
    fun correctArg4(arg : EditText):Boolean{
        if(!(arg.text.toString().isEmpty()) != null && arg.text.toString().toInt()>0 && arg.text.toString().toInt() < 150 ){
            return true
        }
        return false
    }
    fun coolnessPercentage(arg1 : String , arg2 : Double, arg3 : Int, arg4 : Int) : Int{
        var pers:Int = arg1.length
        if(arg4 <= 28){
            pers *=(arg2 / (arg3/100) * (arg3/100)).toInt()
            return ((pers* 10)).toInt()/100 + 50
        }else{
            pers += (arg2 * (arg3/100)).toInt()
            return ((pers * 20)).toInt()/100 + 50
        }
    }

}