package kisan.com.fabproject

import android.os.Parcel
import android.os.Parcelable

import org.json.JSONException
import org.json.JSONObject

/**
 * weather model for showing the data
 */

class CurrentDataModel : Parcelable {
    var city: String = ""
    var temp: String = ""
    var list: ArrayList<ForcastModel> = ArrayList()

    constructor() {

    }

    protected constructor(parcel : Parcel) {
        city = parcel.readString()
        temp = parcel.readString()
        list = parcel.createTypedArrayList(ForcastModel.CREATOR)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(city)
        parcel.writeString(temp)
        parcel.writeTypedList(list)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<CurrentDataModel> = object : Parcelable.Creator<CurrentDataModel> {
            override fun createFromParcel(`in`: Parcel): CurrentDataModel {
                return CurrentDataModel(`in`)
            }

            override fun newArray(size: Int): Array<CurrentDataModel?> {
                return arrayOfNulls(size)
            }
        }

        @Throws(JSONException::class)
        fun getData(`object`: JSONObject): CurrentDataModel {
            val location = `object`.getJSONObject("location")
            val current = `object`.getJSONObject("current")
            val forcast = `object`.getJSONObject("forecast")
            val dataModel = CurrentDataModel()
            dataModel.city = location.getString("name")
            dataModel.temp = current.getString("temp_c")
            dataModel.list = ForcastModel.getList(forcast.getJSONArray("forecastday"))
            return dataModel
        }
    }
}