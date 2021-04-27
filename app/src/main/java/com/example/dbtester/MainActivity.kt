package com.example.dbtester

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dbtester.databinding.ActivityMainBinding
import com.example.dbtester.db.DatabaseRicette
import com.example.dbtester.db.RicettaEntity
import com.example.kitau.ui.notifications.AdapteRecy
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
val db = DatabaseRicette.invoke(applicationContext)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        GlobalScope.launch {
           // val lista:ArrayList<RicettaEntity>=db.
      //  db.DaoRicette().insertAll(RicettaEntity(4,"s","sd",2))



        }

       // array.add(RicettaEntity(2,"sds","sds",22))


        val AdapteRecy: RecyclerView.Adapter<*>
        val layoutManager = LinearLayoutManager(baseContext, LinearLayoutManager.VERTICAL, false)
        val gridLayoutManager = LinearLayoutManager(baseContext, GridLayoutManager.VERTICAL, false)

        with(binding){
            recyclerView.setHasFixedSize(true)
             recyclerView.layoutManager=layoutManager
             recyclerView.layoutManager =gridLayoutManager

           // recyclerView.adapter = AdapteRecy(array,this@MainActivity)



        }

        setContentView(binding.root)


    }
}