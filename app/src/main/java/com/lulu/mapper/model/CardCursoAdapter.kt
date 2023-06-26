package com.lulu.mapper.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lulu.mapper.R

class CardCursoAdapter constructor(private val onItemClicked: (CursoItem) -> Unit): RecyclerView.Adapter<CardCursoAdapter.ViewHolder>() {

    private var cursos = mutableListOf<CursoItem>()
    fun setCursoList(curso: List<CursoItem>, aux: String? = ""){
        this.cursos = curso.toMutableList()
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

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = cursos[position]
        holder.textView.text = item.curso
    }

    override fun getItemCount(): Int {
        return cursos.size
    }

}