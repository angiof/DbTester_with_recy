package com.example.kitau.ui.notifications

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.dbtester.databinding.RecyModelBinding
import com.example.dbtester.db.RicettaEntity

class AdapteRecy(private var mdaata: Array<RicettaEntity>, val contex: Context?) :
    RecyclerView.Adapter<AdapteRecy.RicetteHolder>() {

    inner class RicetteHolder(val binding: RecyModelBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapteRecy.RicetteHolder {
        return RicetteHolder(RecyModelBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    override fun getItemCount(): Int=mdaata.size

    override fun onBindViewHolder(holder: AdapteRecy.RicetteHolder, position: Int) {
        with(holder.binding){
            titoloRicetta.text=mdaata[position].titolo.toString()
            descrizioneRicetta.text=mdaata[position].descrizione.toString()

            tempoRicetta.text= mdaata[position].tempo.toInt().toString()
            cardView.setOnClickListener {
                Toast.makeText(contex, mdaata[position].titolo, Toast.LENGTH_SHORT).show()

            }


        }
    }


}