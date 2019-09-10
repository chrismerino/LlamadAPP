package com.crismerino.llamadapp

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val pedirPermiso: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TextView que muestra los numeros
        var editTextNumberDisplay: TextView? = findViewById(R.id.editTextNumberDisplay)

        // Variable que guarda los numeros ingresados
        var numeroString: String = ""


        // Botones del 1 al 0
        var botonNumeroUno: Button = findViewById(R.id.buttonUno)
        var botonNumeroDos: Button = findViewById(R.id.buttonDos)
        var botonNumeroTres: Button = findViewById(R.id.buttonTres)
        var botonNumeroCuatro: Button = findViewById(R.id.buttonCuatro)
        var botonNumeroCinco: Button = findViewById(R.id.buttonCinco)
        var botonNumeroSeis: Button = findViewById(R.id.buttonSeis)
        var botonNumeroSiete: Button = findViewById(R.id.buttonSiete)
        var botonNumeroOcho: Button = findViewById(R.id.buttonOcho)
        var botonNumeroNueve: Button = findViewById(R.id.buttonNueve)
        var botonNumeroCero: Button = findViewById(R.id.buttonCero)
        var botonClear: Button = findViewById(R.id.buttonClear)
        var botonLlamar: Button = findViewById(R.id.buttonLlamar)

        botonNumeroUno.setOnClickListener {
            numeroString = "1"
            editTextNumberDisplay?.append(numeroString)
        }

        botonNumeroDos.setOnClickListener {
            numeroString = "2"
            editTextNumberDisplay?.append(numeroString)
        }

        botonNumeroTres.setOnClickListener {
            numeroString = "3"
            editTextNumberDisplay?.append(numeroString)        }

        botonNumeroCuatro.setOnClickListener {
            numeroString = "4"
            editTextNumberDisplay?.append(numeroString)
        }

        botonNumeroCinco.setOnClickListener {
            numeroString = "5"
            editTextNumberDisplay?.append(numeroString)
        }

        botonNumeroSeis.setOnClickListener {
            numeroString = "6"
            editTextNumberDisplay?.append(numeroString)
        }

        botonNumeroSiete.setOnClickListener {
            numeroString = "7"
            editTextNumberDisplay?.append(numeroString)
        }

        botonNumeroOcho.setOnClickListener {
            numeroString = "8"
            editTextNumberDisplay?.append(numeroString)
        }

        botonNumeroNueve.setOnClickListener {
            numeroString = "9"
            editTextNumberDisplay?.append(numeroString)
        }

        botonNumeroCero.setOnClickListener {
            numeroString = "0"
            editTextNumberDisplay?.append(numeroString)
        }

        botonClear.setOnClickListener {
            numeroString= ""
            editTextNumberDisplay?.text = numeroString
        }

        // Boton llamar

//        botonLlamar.setOnClickListener {
//            numeroString = editTextNumberDisplay?.text.toString().trim()
//
//            // marcar Intent
//            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(numeroString)))
//            startActivity(intent)
//        }

        botonLlamar.setOnClickListener {

            Llamar()
        }
    }

    fun Llamar(){
        var numeroString: String = editTextNumberDisplay.text.toString().trim()

        if (numeroString.trim().length > 0){
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, arrayOf<String>(android.Manifest.permission.CALL_PHONE), pedirPermiso)

            } else {
                val llamar = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + Uri.encode(numeroString)))
                startActivity(llamar)
            }

        } else {
            Toast.makeText(this, "Ingresa un numero", Toast.LENGTH_SHORT).show()
        }
    }
}

