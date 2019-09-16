package kisan.com.fabproject

import android.content.Intent
import android.support.test.espresso.Espresso
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.json.JSONObject
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestName
import org.junit.runner.RunWith
import java.lang.Exception
import java.util.*

@LargeTest
@RunWith(AndroidJUnit4::class)
class SecondActivityUITest {
    @Rule
    @JvmField
    var mActivityTestRule: ActivityTestRule<Main2Activity> =  object : ActivityTestRule<Main2Activity>(Main2Activity::class.java){
         override fun getActivityIntent() : Intent {
            return Intent().apply {
                val jsonObject = JSONObject("{\"location\":{\"name\":\"Bengaluru\",\"region\":\"Karnataka\",\"country\":\"India\",\"lat\":12.98,\"lon\":77.58,\"tz_id\":\"Asia/Kolkata\",\"localtime_epoch\":1567845156,\"localtime\":\"2019-09-07 14:02\"},\"current\":{\"last_updated_epoch\":1567844118,\"last_updated\":\"2019-09-07 13:45\",\"temp_c\":27.0,\"temp_f\":80.6,\"is_day\":1,\"condition\":{\"text\":\"Partly cloudy\",\"icon\":\"//cdn.apixu.com/weather/64x64/day/116.png\",\"code\":1003},\"wind_mph\":19.2,\"wind_kph\":31.0,\"wind_degree\":270,\"wind_dir\":\"W\",\"pressure_mb\":1011.0,\"pressure_in\":30.3,\"precip_mm\":0.0,\"precip_in\":0.0,\"humidity\":66,\"cloud\":50,\"feelslike_c\":28.9,\"feelslike_f\":83.9,\"vis_km\":8.0,\"vis_miles\":4.0,\"uv\":7.0,\"gust_mph\":24.6,\"gust_kph\":39.6},\"forecast\":{\"forecastday\":[{\"date\":\"2019-09-07\",\"date_epoch\":1567814400,\"day\":{\"maxtemp_c\":26.0,\"maxtemp_f\":78.8,\"mintemp_c\":20.4,\"mintemp_f\":68.7,\"avgtemp_c\":22.9,\"avgtemp_f\":73.1,\"maxwind_mph\":22.1,\"maxwind_kph\":35.6,\"totalprecip_mm\":0.7,\"totalprecip_in\":0.03,\"avgvis_km\":9.8,\"avgvis_miles\":6.0,\"avghumidity\":74.0,\"condition\":{\"text\":\"Patchy rain possible\",\"icon\":\"//cdn.apixu.com/weather/64x64/day/176.png\",\"code\":1063},\"uv\":10.8},\"astro\":{\"sunrise\":\"06:09 AM\",\"sunset\":\"06:27 PM\",\"moonrise\":\"01:32 PM\",\"moonset\":\"12:21 AM\"}},{\"date\":\"2019-09-08\",\"date_epoch\":1567900800,\"day\":{\"maxtemp_c\":24.6,\"maxtemp_f\":76.3,\"mintemp_c\":20.6,\"mintemp_f\":69.1,\"avgtemp_c\":22.5,\"avgtemp_f\":72.6,\"maxwind_mph\":20.1,\"maxwind_kph\":32.4,\"totalprecip_mm\":0.3,\"totalprecip_in\":0.01,\"avgvis_km\":10.0,\"avgvis_miles\":6.0,\"avghumidity\":76.0,\"condition\":{\"text\":\"Patchy rain possible\",\"icon\":\"//cdn.apixu.com/weather/64x64/day/176.png\",\"code\":1063},\"uv\":11.0},\"astro\":{\"sunrise\":\"06:09 AM\",\"sunset\":\"06:26 PM\",\"moonrise\":\"02:23 PM\",\"moonset\":\"01:12 AM\"}},{\"date\":\"2019-09-09\",\"date_epoch\":1567987200,\"day\":{\"maxtemp_c\":28.0,\"maxtemp_f\":82.4,\"mintemp_c\":20.3,\"mintemp_f\":68.5,\"avgtemp_c\":23.4,\"avgtemp_f\":74.0,\"maxwind_mph\":20.8,\"maxwind_kph\":33.5,\"totalprecip_mm\":0.5,\"totalprecip_in\":0.02,\"avgvis_km\":9.8,\"avgvis_miles\":6.0,\"avghumidity\":73.0,\"condition\":{\"text\":\"Patchy rain possible\",\"icon\":\"//cdn.apixu.com/weather/64x64/day/176.png\",\"code\":1063},\"uv\":12.2},\"astro\":{\"sunrise\":\"06:09 AM\",\"sunset\":\"06:25 PM\",\"moonrise\":\"03:14 PM\",\"moonset\":\"02:03 AM\"}},{\"date\":\"2019-09-10\",\"date_epoch\":1568073600,\"day\":{\"maxtemp_c\":27.0,\"maxtemp_f\":80.6,\"mintemp_c\":19.9,\"mintemp_f\":67.8,\"avgtemp_c\":23.4,\"avgtemp_f\":74.1,\"maxwind_mph\":15.4,\"maxwind_kph\":24.8,\"totalprecip_mm\":1.9,\"totalprecip_in\":0.07,\"avgvis_km\":9.8,\"avgvis_miles\":6.0,\"avghumidity\":74.0,\"condition\":{\"text\":\"Patchy rain possible\",\"icon\":\"//cdn.apixu.com/weather/64x64/day/176.png\",\"code\":1063},\"uv\":13.0},\"astro\":{\"sunrise\":\"06:09 AM\",\"sunset\":\"06:24 PM\",\"moonrise\":\"04:01 PM\",\"moonset\":\"02:54 AM\"}},{\"date\":\"2019-09-11\",\"date_epoch\":1568160000,\"day\":{\"maxtemp_c\":27.2,\"maxtemp_f\":81.0,\"mintemp_c\":20.4,\"mintemp_f\":68.7,\"avgtemp_c\":23.8,\"avgtemp_f\":74.9,\"maxwind_mph\":10.7,\"maxwind_kph\":17.3,\"totalprecip_mm\":13.5,\"totalprecip_in\":0.53,\"avgvis_km\":9.1,\"avgvis_miles\":5.0,\"avghumidity\":76.0,\"condition\":{\"text\":\"Moderate or heavy rain shower\",\"icon\":\"//cdn.apixu.com/weather/64x64/day/356.png\",\"code\":1243},\"uv\":11.9},\"astro\":{\"sunrise\":\"06:09 AM\",\"sunset\":\"06:24 PM\",\"moonrise\":\"04:45 PM\",\"moonset\":\"03:44 AM\"}}]},\"alert\":{}}")
                putExtra("DATA",CurrentDataModel.getData(jsonObject))
            }
        }
    }

    @Rule
    @JvmField
    var testName = TestName()


    @Test fun checkActivityData(){
        try {
            Thread.sleep(2000)
             Espresso.onView(ViewMatchers.withText("Bengaluru")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            Espresso.onView(ViewMatchers.withText("27")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            Espresso.onView(ViewMatchers.withText("Sunday")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            Espresso.onView(ViewMatchers.withText("Monday")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            Espresso.onView(ViewMatchers.withText("Tuesday")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            Espresso.onView(ViewMatchers.withText("wednesday")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            Espresso.onView(ViewMatchers.withText("24.6 C")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            Espresso.onView(ViewMatchers.withText("28.0 C")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

            Espresso.onView(ViewMatchers.withText("27.0 C")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

            Espresso.onView(ViewMatchers.withText("27.2 C")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        } catch (e : Exception){
            assert(false)
        }
    }


}