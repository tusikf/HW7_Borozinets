package com.example.components

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.components.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var time = binding.slider.value.toInt()

        binding.slider.addOnChangeListener { _, value, _ ->
            binding.timer.text = value.toInt().toString()
            binding.progressBar.max = value.toInt()
            binding.progressBar.progress = value.toInt()
            time = value.toInt()
        }

        fun reset() {
            binding.timer.text = time.toString()
            binding.progressBar.progress = time
            binding.buttonStop.visibility = View.GONE
            binding.buttonStart.visibility = View.VISIBLE
            binding.slider.isEnabled = true
            Toast.makeText(this, "Timer Task Finished", Toast.LENGTH_SHORT).show()
        }

        binding.buttonStart.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                binding.slider.isEnabled = false
                binding.buttonStart.visibility = View.GONE
                binding.buttonStop.visibility = View.VISIBLE

                (1..time).asFlow().collect {
                    binding.buttonStop.setOnClickListener {
                        reset()
                        cancel()
                    }
                    binding.timer.text = (time - it).toString()
                    binding.progressBar.progress = time - it
                    delay(1000)
                }
                reset()
            }
        }
    }
}
