package ms.example.homeworke1_borozinets

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.helloworld.R
import com.example.helloworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var counter = 0
        var color1 = Color.RED
        var color2 = Color.BLUE
        var color3 = Color.GREEN
        binding.counter.text = counter.toString()
        binding.minus.isEnabled = false
        binding.plus.isEnabled = true
        binding.status.text = binding.status.context.getText(R.string.default_status)
        binding.status.text = binding.status.context.getColor(color1.toInt()).toString()

        binding.plus.setOnClickListener {
            if (binding.plus.isEnabled == true) {
                when (counter) {
                    0 -> {
                        counter++
                        binding.status.text = binding.status.context.getText(R.string.default_status)
                        binding.status.text = binding.status.context.getColor(color1.toInt()).toString()
                        binding.counter.text = counter.toString()
                    }
                    in 1..49 -> {
                        counter++
                        binding.status.text = binding.status.context.getText(R.string.average_status)
                        binding.status.text = binding.status.context.getColor(color2.toInt()).toString()
                        binding.counter.text = counter.toString()
                    }
                    50 -> {
                        binding.status.text = binding.status.context.getText(R.string.warning_status)
                        binding.status.text = binding.status.context.getColor(color3.toInt()).toString()
                        binding.reset.visibility = View.VISIBLE
                        binding.plus.isEnabled = false
                        binding.counter.text = counter.toString()
                    }

                }
            }

        }
        binding.minus.setOnClickListener {
            if (binding.minus.isEnabled == true) {
                when (counter) {
                    0 -> {
                        binding.minus.isEnabled = false

                    }
                    in 1..49 -> {
                        counter--
                        binding.status.text = binding.status.context.getText(R.string.average_status)
                        binding.status.text = binding.status.context.getColor(color2.toInt()).toString()
                        binding.counter.text = counter.toString()
                    }

                }
            }

        }
        binding.reset.setOnClickListener {
            counter = 0
            binding.status.text = binding.status.context.getText(R.string.default_status)
            binding.status.text = binding.status.context.getColor(color1.toInt()).toString()
            binding.minus.isEnabled = false
        }




    }
}