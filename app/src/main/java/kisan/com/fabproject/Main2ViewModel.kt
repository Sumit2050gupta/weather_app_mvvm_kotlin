package kisan.com.fabproject

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Intent

/**
 * Created by hp on 07-12-2018.
 */

class Main2ViewModel : ViewModel() {
    internal var currentDataModel: MutableLiveData<CurrentDataModel>
    var model: CurrentDataModel? = null

    init {
        currentDataModel = MutableLiveData()
    }

    fun setIntent(intent: Intent) {
        model = intent.getParcelableExtra("DATA")

        currentDataModel.value = model
    }

}
