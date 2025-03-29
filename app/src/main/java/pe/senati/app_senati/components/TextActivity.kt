package pe.senati.app_senati.components

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.MultiAutoCompleteTextView
import android.widget.Toast

import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import pe.senati.app_senati.R


class TextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_text)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        var textViewTitle = findViewById<TextView>(R.id.textViewTitle)
        textViewTitle.setText("Bienvenidos todos!")
        textViewTitle.setTextColor(Color.RED)
        textViewTitle.setOnClickListener {
            Toast.makeText(this, "click en el titulo", Toast.LENGTH_SHORT).show()
        }

        var editTextTextSurname = findViewById<TextView>(R.id.editTextTextSurname)
        editTextTextSurname.addTextChangedListener {
            if(editTextTextSurname.length() == 0) {
                editTextTextSurname.setError("Campo requerido")
            }
        }

        var autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        var countries = resources.getStringArray(R.array.countries_array)
        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, countries)
        autoCompleteTextView.setAdapter(adapter)


        var multiAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.multiAutoCompleteTextView)
        multiAutoCompleteTextView.setAdapter(adapter)
        multiAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())


    }
}