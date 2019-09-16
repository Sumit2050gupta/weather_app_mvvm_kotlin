package kisan.com.fabproject

import android.os.Parcel
import android.os.Parcelable

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

import java.util.ArrayList

/**
 *
 * forcast model for forcast list
 */

class ForcastModel : Parcelable {
    var date: String = ""
    var maxT: String = ""

    constructor() {

    }

    protected constructor(parcel : Parcel) {
        date = parcel.readString()

        maxT = parcel.readString()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(date)

        parcel.writeString(maxT)
    }

    companion object {

        @JvmField
        val CREATOR: Parcelable.Creator<ForcastModel> = object : Parcelable.Creator<ForcastModel> {
            override fun createFromParcel(parcel: Parcel): ForcastModel {
                return ForcastModel(parcel)
            }

            override fun newArray(size: Int): Array<ForcastModel?> {
                return arrayOfNulls(size)
            }
        }

        @Throws(JSONException::class)
        fun getList(array: JSONArray): ArrayList<ForcastModel> {
            val list = ArrayList<ForcastModel>()
            for (i in 1 until array.length()) {
                list.add(getData(array.getJSONObject(i)))
            }
            return list
        }

        @Throws(JSONException::class)
        fun getData(`object`: JSONObject): ForcastModel {
            val data = ForcastModel()
            data.date = `object`.getString("date")
            val day = `object`.getJSONObject("day")
            data.maxT = day.getString("maxtemp_c")
            return data
        }
    }
}
