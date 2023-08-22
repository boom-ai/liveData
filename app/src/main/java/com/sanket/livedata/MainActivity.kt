package com.sanket.livedata

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.lifecycle.ViewModelProvider
import com.sanket.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var liveDataClass: LiveDataClass
    var value=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        liveDataClass = ViewModelProvider(this)[LiveDataClass::class.java]
        binding.activity = this
binding.hueSeekBar
    }



    fun onButtonBlue() {
       // val color= Color(R.color.Blue)
    }
    fun onButtonGreen() {
       // val color= Color(R.color.Green)
    }
    fun onButtonPlus()
    {
        var value=binding.etInput.text.toString().toInt()
        value=value+1
        liveDataClass.data.setValue(value)
    }
    fun onButtonMinus()
    {
        var value=binding.etInput.text.toString().toInt()
        value=value-1
        liveDataClass.data.setValue(value)
    }
}