package Data.APIManage;

import retrofit2.Retrofit;

/**
 * Created by NEO on 9/16/2017.
 */

public class APIUtils {
    public static final String BASE_URL = "";

    public static MDService getService(){
        return APIManagement.getClient(BASE_URL).create(MDService.class);
    }
}
