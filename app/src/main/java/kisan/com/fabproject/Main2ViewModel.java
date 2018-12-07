package kisan.com.fabproject;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Intent;

import java.util.List;

/**
 * Created by hp on 07-12-2018.
 */

public class Main2ViewModel extends ViewModel {
    MutableLiveData<List<ForcastModel>> recycleList;
    CurrentDataModel model;
    public Main2ViewModel(){
       recycleList = new MutableLiveData<>();
    }

    public void setIntent(Intent intent){
        model = intent.getParcelableExtra("DATA");

        recycleList.setValue(model.getList());
    }

}
