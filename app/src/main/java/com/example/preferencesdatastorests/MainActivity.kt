package com.example.preferencesdatastorests

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.preferencesdatastorests.repository.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private val tv: TextView by lazy { findViewById(R.id.tvText) }
    private val et: EditText by lazy { findViewById(R.id.etText) }
    private val btn:Button by lazy { findViewById(R.id.btnSave) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.readFromDataStore.observe(this) { name ->
            tv.text = name
        }

        btn.setOnClickListener {
            val myName = et.text.toString()
            mainViewModel.saveToDataStore(myName)
        }

    }
}

