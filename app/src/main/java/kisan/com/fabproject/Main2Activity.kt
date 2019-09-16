package kisan.com.fabproject

import android.app.FragmentTransaction
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {
    lateinit var main2ViewModel: Main2ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        main2ViewModel = ViewModelProviders.of(this).get(Main2ViewModel::class.java)
        init()
        main2ViewModel.setIntent(intent)
    }

    private fun init() {

        setView()
    }


// seting observer for showing data to user
    private fun setView() {
        main2ViewModel.currentDataModel.observe(this, Observer { currentDataModel ->
            currentDataModel?.let {
                temp.text = currentDataModel.temp.toFloat().toInt().toString() + "°"
                name.text = currentDataModel.city
                Handler(Looper.getMainLooper()).postDelayed(Runnable {
                    val ft = supportFragmentManager.beginTransaction();
                    ft.setCustomAnimations(R.anim.translate,0)
                    ft.add(R.id.frame,ForcastFrgament.newInstance(it.list)).commit()
                },500)
            }

        })
    }
}
