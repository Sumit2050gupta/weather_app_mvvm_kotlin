package kisan.com.fabproject

/**
 * Created by hp on 07-12-2018.
 */

// A generic class that contains data and status about loading this data.
class Resource private constructor(val status: Status, val data: CurrentDataModel?,
                                   val message: String?) {

    enum class Status {
        SUCCESS, ERROR, LOADING
    }

    companion object {

        fun success(data: CurrentDataModel): Resource {
            return Resource(Status.SUCCESS, data, null)
        }

        fun error(msg: String, data: CurrentDataModel?): Resource {
            return Resource(Status.ERROR, data, msg)
        }

        fun loading(data: CurrentDataModel?): Resource {
            return Resource(Status.LOADING, data, null)
        }
    }
}




