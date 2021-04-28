package com.example.dbtester

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dbtester.databinding.ActivityMainBinding
import com.example.dbtester.db.DatabaseRicette
import com.example.dbtester.db.RicettaEntity
import com.example.kitau.ui.notifications.AdapteRecy
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import layout.Venatana

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)


        // array.add(RicettaEntity(2,"sds","sds",22))








        setContentView(binding.root)


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.popu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.okmenu -> {
                val dialog= Venatana()
                dialog.show(supportFragmentManager,"fd")
            }
        }

        return super.onOptionsItemSelected(item)
    }

}