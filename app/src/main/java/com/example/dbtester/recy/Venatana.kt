package layout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.dbtester.databinding.VentanaLayoutBinding
import com.example.dbtester.db.DatabaseRicette
import com.example.dbtester.db.RicettaEntity
import com.example.kitau.ui.notifications.AdapteRecy
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Venatana : DialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = VentanaLayoutBinding.inflate(layoutInflater)
        val db = DatabaseRicette.invoke(activity!!)

        with(binding) {

            button.setOnClickListener {

                GlobalScope.launch {
                    val title: String = titolotText.text.toString()
                    val descri: String = descrizioneText.text.toString()

                    db.DaoRicette().insertAll(RicettaEntity(titolo = title, descrizione = descri, tempo = 7))

                }
                dismiss()


            }

        }

        return binding.root
    }
}