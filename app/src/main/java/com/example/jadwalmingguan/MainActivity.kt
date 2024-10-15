package com.example.jadwalmingguan

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.jadwalmingguan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listAdapter: listAdapter
    private lateinit var listData: listData
    var dataArrayList = ArrayList<listData?>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dayList = arrayListOf("Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu")
        val descList = arrayListOf(
            getString(R.string.detailSenin),
            getString(R.string.detailSelasa),
            getString(R.string.detailRabu),
            getString(R.string.detailKamis),
            getString(R.string.detailJumat),
            getString(R.string.detailSabtu),
            getString(R.string.detailMinggu)
        )

        for (i in dayList.indices){
            listData = listData(dayList[i], descList[i])
            dataArrayList.add(listData)
        }
        listAdapter = listAdapter(this@MainActivity, dataArrayList)
        binding.listView.adapter = listAdapter
        binding.listView.isClickable = true

        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this@MainActivity, detailHari::class.java)
            intent.putExtra("name", dayList[i])
            intent.putExtra("desc", descList[i])
            startActivity(intent)
        }
    }
}