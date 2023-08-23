package com.sanket.livedata

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.sanket.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var liveDataClass: LiveDataClass
    lateinit var numberViewModel: NumberViewModel
    var value = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        liveDataClass = ViewModelProvider(this)[LiveDataClass::class.java]

        numberViewModel = ViewModelProvider(this)[NumberViewModel::class.java]

        binding.btnRed.setOnClickListener {
            numberViewModel.color.value = 1
        }
        binding.btnBlue.setOnClickListener {
            numberViewModel.color.value = 2
        }
        binding.btnGreen.setOnClickListener {
            numberViewModel.color.value = 3
        }



        binding.activity = this
        fun onButtonBlue() {
            // val color= Color(R.color.Blue)
        }

        fun onButtonGreen() {
            // val color= Color(R.color.Green)
        }


    }

    fun onButtonPlus() {
        if (binding.etInput.text.isNullOrEmpty()) {
            Toast.makeText(this, "please enter number", Toast.LENGTH_SHORT).show()
        } else {
            var value = binding.etInput.text.toString().toInt()
            value = value + 1
            liveDataClass.data.setValue(value)
        }
    }

    fun onButtonMinus() {
        if (binding.etInput.text.isNullOrEmpty()) {
            Toast.makeText(this, "please enter number", Toast.LENGTH_SHORT).show()
        } else {
            var value = binding.etInput.text.toString().toInt()
            value = value - 1
            liveDataClass.data.setValue(value)


        }
    }
}
