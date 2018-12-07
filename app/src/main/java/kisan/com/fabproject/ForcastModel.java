package kisan.com.fabproject;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 07-12-2018.
 */

public class ForcastModel implements Parcelable {
    private String date;
    private String condition;
    private int conditionCode;
    private String minT;
    private String maxT;

    public ForcastModel(){

    }
    protected ForcastModel(Parcel in) {
        date = in.readString();
        condition = in.readString();
        conditionCode = in.readInt();
        minT = in.readString();
        maxT = in.readString();
    }

    public static final Creator<ForcastModel> CREATOR = new Creator<ForcastModel>() {
        @Override
        public ForcastModel createFromParcel(Parcel in) {
            return new ForcastModel(in);
        }

        @Override
        public ForcastModel[] newArray(int size) {
            return new ForcastModel[size];
        }
    };

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getConditionCode() {
        return conditionCode;
    }

    public void setConditionCode(int conditionCode) {
        this.conditionCode = conditionCode;
    }

    public String getMinT() {
        return minT;
    }

    public void setMinT(String minT) {
        this.minT = minT;
    }

    public String getMaxT() {
        return maxT;
    }

    public void setMaxT(String maxT) {
        this.maxT = maxT;
    }

    public static List<ForcastModel> getList(JSONArray array) throws JSONException{
        List<ForcastModel> list = new ArrayList<>();
        for(int i = 0;i < array.length();i++){
            list.add(getData(array.getJSONObject(i)));
        }
        return list;
    }
    public static ForcastModel getData(JSONObject object) throws JSONException{
        ForcastModel data = new ForcastModel();
        data.date= object.getString("date");
        JSONObject day = object.getJSONObject("day");
        data.minT = day.getString("mintemp_c");
        data.maxT = day.getString("maxtemp_c");
        JSONObject condition = day.getJSONObject("condition");
        data.condition = condition.getString("text");
        data.conditionCode = condition.getInt("code");
        return data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(date);
        parcel.writeString(condition);
        parcel.writeInt(conditionCode);
        parcel.writeString(minT);
        parcel.writeString(maxT);
    }
}
