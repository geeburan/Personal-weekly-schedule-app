package com.example.jadwalmingguan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jadwalmingguan.databinding.ActivityDetailHariBinding

class detailHari : AppCompatActivity() {

    private lateinit var binding: ActivityDetailHariBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailHariBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Tangkap Intent
        val intent = this.intent
        if (intent != null){
            val name = intent.getStringExtra("name")
            val desc = intent.getStringExtra("desc")
            binding.dayName.text = name
            binding.dayList.text = desc
        }
    }
}
