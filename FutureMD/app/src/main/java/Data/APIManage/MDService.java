package Data.APIManage;

import java.util.List;

import Data.ResponseInfo.UserPatient;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by NEO on 9/16/2017.
 */

public interface MDService {
    //Get Patient Login info
    @GET("http://kajlfdkj.com")
    Call<List<UserPatient>> getPatientInfo(@Query("username") String username, @Query("password") String password);

    //Post Patient Register info
}
