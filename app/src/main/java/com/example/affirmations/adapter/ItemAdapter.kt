package com.example.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

//ItemAdapter necesita información sobre cómo resolver los recursos de strings. Esta y otra información sobre la app se almacena en una instancia del objeto Context
class ItemAdapter(private val context: Context, private val dataset: List<Affirmation>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    //El layout manager llama al método onCreateViewHolder() a fin de crear nuevas interfaces de vista
    // para RecyclerView (cuando no hay viewHolder existentes que puedan reutilizarse).
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // crea una nueva vista
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    // El layout manager llama a este método para reemplazar el contenido de una vista de elementos de lista.
    //En este método, encontrarás el objeto Affirmation adecuado del conjunto de datos según la posición.
    override fun onBindViewHolder(holder: ItemAdapter.ItemViewHolder, position: Int) {
        //ItemViewHolder, creado anteriormente por el método onCreateViewHolder(),
        //int que representa el elemento actual position en la lista.
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)

    }

    //El método getItemCount() debe mostrar el tamaño de tu conjunto de datos.
    override fun getItemCount() = dataset.size

    // Como ItemAdapter solo usa ItemViewHolder, si se crea dentro de ItemAdapter, se muestra esta relación. Esto no es obligatorio, pero ayuda a otros desarrolladores a comprender la estructura de tu programa.
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView : TextView = view.findViewById(R.id.tv_item_text)
        val imageView : ImageView = view.findViewById(R.id.iv_item_image)

    }
}