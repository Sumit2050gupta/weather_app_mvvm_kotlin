package kisan.com.fabproject

import android.app.Application
import android.text.TextUtils

import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

/**
 * Created by hp on 07-12-2018.
 */


class AppController : Application() {

    lateinit var  mRequestQueue : RequestQueue

    override fun onCreate() {
        super.onCreate()
        instance = this
        mRequestQueue = Volley.newRequestQueue(applicationContext)
    }


    fun <T> addToRequestQueue(req: Request<T>, tag: String) {
        // set the default tag if tag is empty
        req.tag = if (TextUtils.isEmpty(tag)) TAG else tag
        mRequestQueue.add(req)
    }

    fun <T> addToRequestQueue(req: Request<T>) {
        req.tag = TAG
        mRequestQueue.add(req)
    }

    fun cancelPendingRequests(tag: Any) {
        mRequestQueue.cancelAll(tag)

    }

    companion object {

        val TAG = AppController::class.java
                .simpleName

        lateinit var  instance :AppController
    }
}
