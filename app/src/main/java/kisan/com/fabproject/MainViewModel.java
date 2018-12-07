package kisan.com.fabproject;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by hp on 07-12-2018.
 */

public class MainViewModel extends ViewModel {
    MutableLiveData<Resource> data ;


   public MainViewModel(){
       data = new MutableLiveData<>();
       UserRepository.hitApi(data);
   }

    public void retryButtonClick() {
        UserRepository.hitApi(data);
    }
}
