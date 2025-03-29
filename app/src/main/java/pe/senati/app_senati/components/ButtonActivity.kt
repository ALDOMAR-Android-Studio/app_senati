package pe.senati.app_senati.components

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import pe.senati.app_senati.R

class ButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_button)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        var chipGroup1 = findViewById<ChipGroup>(R.id.chipGroup1)
        var chip: Chip
        for (i in 0 until chipGroup1.childCount) {
            chip = chipGroup1.getChildAt(i) as Chip
            chip.textAlignment = View.TEXT_ALIGNMENT_CENTER

            // Set the close icon to be visible
            chip.setOnCloseIconClickListener {
                chipGroup1.removeView(it)
            }

            // Set the click listener for the chip
            chip.setOnClickListener {
                var aux = it as Chip
                Toast.makeText(this, "${aux.text} pulsado", Toast.LENGTH_SHORT).show()
            }
        }

    }
}