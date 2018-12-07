package kisan.com.fabproject;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import static kisan.com.fabproject.AppController.TAG;

/**
 * Created by hp on 07-12-2018.
 */

public class UserRepository {

    public static void hitApi(final MutableLiveData<Resource> data){
        String url = "https://api.apixu.com/v1/forecast.json?key=bd0460b24f4a45b798d60925180712&q=bengaluru&days=7";
        data.postValue(Resource.loading(null));
        final JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());
                        try{
                           CurrentDataModel dataModel = CurrentDataModel.getData(response);
                           data.postValue(Resource.success(dataModel));
                        } catch (JSONException e){
                            Log.d(TAG, "onResponse: " + e.getMessage());
                            data.postValue(Resource.error("Json error",null));
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "Error: " + error.getMessage());
                data.postValue(Resource.error("network Error",null));
                // hide the progress dialog

            }
        });

// Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, "api");


    }
}
