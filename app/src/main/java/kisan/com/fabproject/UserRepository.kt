package kisan.com.fabproject

import android.arch.lifecycle.MutableLiveData
import android.util.Log

import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.VolleyLog
import com.android.volley.toolbox.JsonObjectRequest

import org.json.JSONException
import org.json.JSONObject

/**
 * Api helper class
 */

object UserRepository {

  // hitting the api for forcast detail

    fun hitApi(data: MutableLiveData<Resource>) {
        val url = "https://api.apixu.com/v1/forecast.json?key=bd0460b24f4a45b798d60925180712&q=bengaluru&days=5"
        data.postValue(Resource.loading(null))
        val jsonObjReq = JsonObjectRequest(Request.Method.GET,
                url, null,
                Response.Listener { response ->
                    Log.d("UserRepository", response.toString())
                    try {
                        val dataModel = CurrentDataModel.getData(response)
                        data.postValue(Resource.success(dataModel))
                    } catch (e: JSONException) {
                        Log.d("UserRepository", "onResponse: " + e.message)
                        data.postValue(Resource.error("Json error", null))
                    }
                }, Response.ErrorListener { error ->
            Log.d("UserRepository", "Error: " + error.message)
            data.postValue(Resource.error("network Error", null))
            // hide the progress dialog
        })

        // Adding request to request queue
        AppController.instance.addToRequestQueue(jsonObjReq, "api")
        AppController.instance.mRequestQueue.cache.clear()


    }
}
