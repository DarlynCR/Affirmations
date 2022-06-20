package com.example.affirmations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.affirmations.adapter.ItemAdapter
import com.example.affirmations.data.Datasource
import com.example.affirmations.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //se iniciliza la lista de los datos a pintar en el rv
        val myDataset = Datasource().loadAffirmations()
        //Inicializa el rv
        val recyclerView = binding.rvAffirmations
        //instancio el adapter a pasar en rv y s ele pasa el context y la lista de datos
        recyclerView.adapter = ItemAdapter(this, myDataset)
        //Si el diseño es fijo, para mejorar el rendimiento
        recyclerView.setHasFixedSize(true)
        //Úsala si sabes que los cambios en el contenido no cambiarán el tamaño del diseño de RecyclerView.
    }
}