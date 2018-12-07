package kisan.com.fabproject;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by hp on 07-12-2018.
 */

// A generic class that contains data and status about loading this data.
public class Resource {
    @NonNull public final Status status;
    @Nullable public final CurrentDataModel data;
    @Nullable public final String message;
    private Resource(@NonNull Status status, @Nullable CurrentDataModel data,
                     @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static  Resource success(@NonNull CurrentDataModel data) {
        return new Resource(Status.SUCCESS, data, null);
    }

    public static  Resource error(String msg, @Nullable CurrentDataModel data) {
        return new Resource(Status.ERROR, data, msg);
    }

    public static  Resource loading(@Nullable CurrentDataModel data) {
        return new Resource(Status.LOADING, data, null);
    }

    public enum Status { SUCCESS, ERROR, LOADING }
}




