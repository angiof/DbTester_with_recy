package com.example.dbtester

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dbtester.databinding.FragmentFragutilBinding
import com.example.dbtester.db.DatabaseRicette
import com.example.dbtester.db.RicettaEntity
import com.example.kitau.ui.notifications.AdapteRecy
import kotlinx.coroutines.*


class Fragutil : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private var _binding: FragmentFragutilBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFragutilBinding.inflate(layoutInflater)
        return binding.root

    }
    var array: Array<RicettaEntity> = emptyArray()
    var  adapteRecy = AdapteRecy(array, requireContext())
    override fun onStart() {
        super.onStart()
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val gridLayoutManager = LinearLayoutManager(requireContext(), GridLayoutManager.HORIZONTAL, false)
        binding.recyclerView.setHasFixedSize(true)
        // recyclerView.layoutManager = layoutManager
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.adapter = adapteRecy
        val db = DatabaseRicette.invoke(activity!!)
        GlobalScope.launch {
            array = db.DaoRicette().getAll() as Array<RicettaEntity>
            with(binding) {
                floatBtn.setOnClickListener {
                    Toast.makeText(requireContext(), "fatto", Toast.LENGTH_SHORT).show() }
                adapteRecy.itemsList= array
            }
        }
    }
}




