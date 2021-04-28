package com.example.dbtester

import android.R
import android.app.Activity
import android.os.Bundle
import android.view.*
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dbtester.databinding.FragmentFragutilBinding
import com.example.dbtester.db.DatabaseRicette
import com.example.dbtester.db.RicettaEntity
import com.example.kitau.ui.notifications.AdapteRecy
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import layout.Venatana


class Fragutil : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentFragutilBinding.inflate(layoutInflater)
        var adapteRecy: RecyclerView.Adapter<*>
        val layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
        val gridLayoutManager = LinearLayoutManager(
            requireContext(),
            GridLayoutManager.HORIZONTAL,
            false
        )
        val db = DatabaseRicette.invoke(activity!!)




        GlobalScope.launch {

            val array: Array<RicettaEntity> = db.DaoRicette().getAll() as Array<RicettaEntity>
            adapteRecy = AdapteRecy(array, requireContext())
            with(binding) {

                recyclerView.setHasFixedSize(true)
                // recyclerView.layoutManager = layoutManager
                recyclerView.layoutManager = gridLayoutManager
                recyclerView.adapter = adapteRecy

                adapteRecy.notifyDataSetChanged()

                with(binding){
                    floatBtn.setOnClickListener {
                        Toast.makeText(requireContext(), "fatto", Toast.LENGTH_SHORT).show()



                    }

                }


            }


        }



        return binding.root


    }
}

