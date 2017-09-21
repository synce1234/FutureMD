package com.dev.app.futuremd.data.apimanager;

/**
 * Created by NEO on 9/16/2017.
 */

public class APIUtils {
    public static final String BASE_URL = "http://futuremd.nanobiotechcrm.com/";

    public static MDService getService(){
        return APIManagement.getClient(BASE_URL).create(MDService.class);
    }
}
