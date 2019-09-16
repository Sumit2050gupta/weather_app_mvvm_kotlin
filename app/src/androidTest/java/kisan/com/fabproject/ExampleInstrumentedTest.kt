package kisan.com.fabproject

import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import org.json.JSONException
import org.json.JSONObject

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import java.util.concurrent.CountDownLatch

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun ForcastApiTesting() {
        val countDownLatch = CountDownLatch(1)
        var i = 0
        val url = "https://api.apixu.com/v1/forecast.json?key=bd0460b24f4a45b798d60925180712&q=bengaluru&days=5"
        val jsonObjReq = JsonObjectRequest(Request.Method.GET,
                url, null,
                Response.Listener { response ->

                    i = 1
                   countDownLatch.countDown()
                }, Response.ErrorListener { error ->
            countDownLatch.countDown()
        })

        // Adding request to request queue
        AppController.instance.addToRequestQueue(jsonObjReq, "api")
        AppController.instance.mRequestQueue.cache.clear()

        countDownLatch.await()
        assert(i == 1)
    }


    @Test
    fun checkJsonParsing(){
        val jsonObject = JSONObject("{\"location\":{\"name\":\"Bengaluru\",\"region\":\"Karnataka\",\"country\":\"India\",\"lat\":12.98,\"lon\":77.58,\"tz_id\":\"Asia/Kolkata\",\"localtime_epoch\":1567832337,\"localtime\":\"2019-09-07 10:28\"},\"current\":{\"last_updated_epoch\":1567831521,\"last_updated\":\"2019-09-07 10:15\",\"temp_c\":25.0,\"temp_f\":77.0,\"is_day\":1,\"condition\":{\"text\":\"Partly cloudy\",\"icon\":\"//cdn.apixu.com/weather/64x64/day/116.png\",\"code\":1003},\"wind_mph\":20.6,\"wind_kph\":33.1,\"wind_degree\":260,\"wind_dir\":\"W\",\"pressure_mb\":1013.0,\"pressure_in\":30.4,\"precip_mm\":0.1,\"precip_in\":0.0,\"humidity\":79,\"cloud\":75,\"feelslike_c\":27.0,\"feelslike_f\":80.7,\"vis_km\":6.0,\"vis_miles\":3.0,\"uv\":7.0,\"gust_mph\":24.8,\"gust_kph\":40.0},\"forecast\":{\"forecastday\":[{\"date\":\"2019-09-07\",\"date_epoch\":1567814400,\"day\":{\"maxtemp_c\":26.0,\"maxtemp_f\":78.8,\"mintemp_c\":20.4,\"mintemp_f\":68.7,\"avgtemp_c\":22.9,\"avgtemp_f\":73.1,\"maxwind_mph\":22.1,\"maxwind_kph\":35.6,\"totalprecip_mm\":0.7,\"totalprecip_in\":0.03,\"avgvis_km\":9.8,\"avgvis_miles\":6.0,\"avghumidity\":74.0,\"condition\":{\"text\":\"Patchy rain possible\",\"icon\":\"//cdn.apixu.com/weather/64x64/day/176.png\",\"code\":1063},\"uv\":10.8},\"astro\":{\"sunrise\":\"06:09 AM\",\"sunset\":\"06:27 PM\",\"moonrise\":\"01:32 PM\",\"moonset\":\"12:21 AM\"}},{\"date\":\"2019-09-08\",\"date_epoch\":1567900800,\"day\":{\"maxtemp_c\":24.6,\"maxtemp_f\":76.3,\"mintemp_c\":20.6,\"mintemp_f\":69.1,\"avgtemp_c\":22.5,\"avgtemp_f\":72.6,\"maxwind_mph\":20.1,\"maxwind_kph\":32.4,\"totalprecip_mm\":0.3,\"totalprecip_in\":0.01,\"avgvis_km\":10.0,\"avgvis_miles\":6.0,\"avghumidity\":76.0,\"condition\":{\"text\":\"Patchy rain possible\",\"icon\":\"//cdn.apixu.com/weather/64x64/day/176.png\",\"code\":1063},\"uv\":11.0},\"astro\":{\"sunrise\":\"06:09 AM\",\"sunset\":\"06:26 PM\",\"moonrise\":\"02:23 PM\",\"moonset\":\"01:12 AM\"}},{\"date\":\"2019-09-09\",\"date_epoch\":1567987200,\"day\":{\"maxtemp_c\":28.0,\"maxtemp_f\":82.4,\"mintemp_c\":20.3,\"mintemp_f\":68.5,\"avgtemp_c\":23.4,\"avgtemp_f\":74.0,\"maxwind_mph\":20.8,\"maxwind_kph\":33.5,\"totalprecip_mm\":0.5,\"totalprecip_in\":0.02,\"avgvis_km\":9.8,\"avgvis_miles\":6.0,\"avghumidity\":73.0,\"condition\":{\"text\":\"Patchy rain possible\",\"icon\":\"//cdn.apixu.com/weather/64x64/day/176.png\",\"code\":1063},\"uv\":12.2},\"astro\":{\"sunrise\":\"06:09 AM\",\"sunset\":\"06:25 PM\",\"moonrise\":\"03:14 PM\",\"moonset\":\"02:03 AM\"}},{\"date\":\"2019-09-10\",\"date_epoch\":1568073600,\"day\":{\"maxtemp_c\":27.0,\"maxtemp_f\":80.6,\"mintemp_c\":19.9,\"mintemp_f\":67.8,\"avgtemp_c\":23.4,\"avgtemp_f\":74.1,\"maxwind_mph\":15.4,\"maxwind_kph\":24.8,\"totalprecip_mm\":1.9,\"totalprecip_in\":0.07,\"avgvis_km\":9.8,\"avgvis_miles\":6.0,\"avghumidity\":74.0,\"condition\":{\"text\":\"Patchy rain possible\",\"icon\":\"//cdn.apixu.com/weather/64x64/day/176.png\",\"code\":1063},\"uv\":13.0},\"astro\":{\"sunrise\":\"06:09 AM\",\"sunset\":\"06:24 PM\",\"moonrise\":\"04:01 PM\",\"moonset\":\"02:54 AM\"}}]},\"alert\":{}}")

        try {
            val data = CurrentDataModel.getData(jsonObject)
            assert(true)
        } catch (e : java.lang.Exception){
            assert(false)
        }

    }


}
