package kisan.com.fabproject;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by hp on 07-12-2018.
 */

public class CurrentDataModel implements Parcelable {
    private String city;
    private String temp;
    private List<ForcastModel> list;

    public CurrentDataModel(){

    }

    protected CurrentDataModel(Parcel in) {
        city = in.readString();
        temp = in.readString();
        list = in.createTypedArrayList(ForcastModel.CREATOR);
    }

    public static final Creator<CurrentDataModel> CREATOR = new Creator<CurrentDataModel>() {
        @Override
        public CurrentDataModel createFromParcel(Parcel in) {
            return new CurrentDataModel(in);
        }

        @Override
        public CurrentDataModel[] newArray(int size) {
            return new CurrentDataModel[size];
        }
    };

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public List<ForcastModel> getList() {
        return list;
    }

    public void setList(List<ForcastModel> list) {
        this.list = list;
    }

    public static CurrentDataModel getData(JSONObject object) throws JSONException{
        JSONObject location = object.getJSONObject("location");
        JSONObject current = object.getJSONObject("current");
        JSONObject forcast = object.getJSONObject("forecast");
        CurrentDataModel dataModel = new CurrentDataModel();
        dataModel.city = location.getString("name");
        dataModel.temp = current.getString("temp_c");
        dataModel.list = ForcastModel.getList(forcast.getJSONArray("forecastday"));
        return dataModel;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(city);
        parcel.writeString(temp);
        parcel.writeTypedList(list);
    }
}