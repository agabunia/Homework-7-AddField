package com.example.homework_7_addfield

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.TypedValue
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.widget.LinearLayoutCompat
import com.example.homework_7_addfield.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUp()
    }

    fun setUp(){
        val addBtn: Button = binding.addBtn
        val checkBox: CheckBox = binding.checkbox
        val containerLayout: LinearLayoutCompat = binding.container
        var idCount = 1

        addBtn.setOnClickListener {
            addEditText(containerLayout, checkBox.isChecked, idCount)
            idCount++
        }
    }

    fun addEditText(containerLayout: LinearLayoutCompat, isChecked: Boolean, count: Int) {
        val editText = EditText(this)
        val params = LinearLayoutCompat.LayoutParams(
            LinearLayoutCompat.LayoutParams.MATCH_PARENT,
            LinearLayoutCompat.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(20, 15, 20, 20)

        editText.id = count
        editText.layoutParams = params
        editText.hint = hintText(isChecked)
        editText.setTextColor(Color.parseColor("#FFFFFFFF"))
        editText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15f)
        editText.setPadding(10, 20, 10, 40)
        editText.inputType = if(isChecked) InputType.TYPE_CLASS_NUMBER else InputType.TYPE_CLASS_TEXT
        containerLayout.addView(editText)
    }

    fun hintText(value: Boolean): String {
        return if(value) {
            "Enter Numeric Text"
        } else {
            "Enter String Text"
        }
    }
}