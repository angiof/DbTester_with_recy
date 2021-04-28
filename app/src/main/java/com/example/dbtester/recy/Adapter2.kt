package com.example.dbtester.recy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dbtester.R
import com.example.dbtester.databinding.RecyModelBinding
import com.example.dbtester.db.RicettaEntity
import com.example.kitau.ui.notifications.AdapteRecy

class Adapter2 (var ricettaLista: ArrayList<RicettaEntity>, var listener: OnAdapterListener) :
    RecyclerView.Adapter<Adapter2.RicetteHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RicetteHolder {
        return RicetteHolder(
            RecyModelBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun getItemCount() = ricettaLista.size

    override fun onBindViewHolder(holder: RicetteHolder, position: Int) {
        val ricetat = ricettaLista[position]
        holder.binding.titoloRicetta.text=ricettaLista[position].titolo

        holder.binding.descrizioneRicetta.text=ricettaLista[position].descrizione

        holder.binding.buttonCard.setOnClickListener {
            setData(ricettaLista)
        }



    }

    inner class RicetteHolder(val binding: RecyModelBinding) : RecyclerView.ViewHolder(binding.root)

    fun setData(newList: List<RicettaEntity>) {
        ricettaLista.clear()
        ricettaLista.addAll(newList)
    }

    interface OnAdapterListener {
        fun onClick(ricette: RicettaEntity)
        fun onUpdate(ricette: RicettaEntity)
        fun onDelete(ricette: RicettaEntity)
    }
}