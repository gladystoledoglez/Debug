package com.example.debug

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import com.example.debug.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var etName: EditText
    private lateinit var btnShowMessage: Button
    private lateinit var tvMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        etName = binding.etName
        btnShowMessage = binding.btnShowMessage
        tvMessage = binding.tvMessage

        btnShowMessage.setOnClickListener {
            val name = etName.text.toString()
            tvMessage.text = getString(R.string.hello_name, name)
        }

        etName.addTextChangedListener { text ->
            btnShowMessage.isVisible = text?.isNotBlank() ?: false
        }
    }
}