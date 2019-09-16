package kisan.com.fabproject

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/**
 * Created by hp on 07-12-2018.
 */

class MainViewModel : ViewModel() {
    internal var data: MutableLiveData<Resource>

    init {
        data = MutableLiveData()
        UserRepository.hitApi(data)
    }


    // hit api on retry button click

    fun retryButtonClick() {
        UserRepository.hitApi(data)
    }
}
