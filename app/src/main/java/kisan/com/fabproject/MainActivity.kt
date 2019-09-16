package kisan.com.fabproject

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        initView()


    }
  // view Initlialize

    private fun initView() {
        imageView2.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotation))
        button.setOnClickListener { mainViewModel.retryButtonClick() }
        setView()
    }

    // setting observer for error and loading handling
    private fun setView() {
        mainViewModel.data.observe(this, Observer { resource ->
           resource?.let {
               when (it.status) {
                   Resource.Status.LOADING -> {
                       loading.visibility = View.VISIBLE
                       error.visibility = View.GONE
                   }
                   Resource.Status.ERROR -> {
                       loading.visibility = View.GONE
                       error.visibility = View.VISIBLE
                   }
                   Resource.Status.SUCCESS -> {
                       val intent = Intent(this@MainActivity, Main2Activity::class.java)
                       intent.putExtra("DATA", it.data)
                       startActivity(intent)
                       finish()
                   }
               }
           }
        })
    }
}
