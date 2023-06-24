package com.lulu.mapper.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lulu.mapper.R

class CardUfCursoAdapter constructor(private val onItemClicked: (UnidadeFederativaItem) -> Unit): RecyclerView.Adapter<CardUfCursoAdapter.ViewHolder>() {

    private var ufs = mutableListOf<UnidadeFederativaItem>()

    fun setUfList(unidadeFederativa: List<UnidadeFederativaItem>, aux: String? = ""){
        this.ufs = unidadeFederativa.toMutableList()
        notifyDataSetChanged()
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView: TextView = itemView.findViewById(R.id.cardTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_uf_curso, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ufs.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = ufs[position]
        holder.textView.text = item.uf
    }


}