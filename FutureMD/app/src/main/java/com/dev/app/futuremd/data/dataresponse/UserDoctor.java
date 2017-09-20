package com.dev.app.futuremd.data.dataresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by NEO on 9/19/2017.
 */

public class UserDoctor {
    @SerializedName("fullname")
    @Expose
    private String fullName;

    @SerializedName("specialty")
    @Expose
    private String specialty;

    
}
