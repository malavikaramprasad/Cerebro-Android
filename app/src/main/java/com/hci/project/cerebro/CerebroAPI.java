package com.hci.project.cerebro;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by Malavika Ramprasad on 11/29/2017.
 */

public interface CerebroAPI {
    @Headers("X-Authorization: eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoidnBhbmRpMkB1aWMuZWR1IiwiZXhwIjoxNTEyMTU1MjY4fQ.1ucDSDzGjnEgN--t_TuYolwlfagf9jPsDVo6kG1cXPU")
    @GET("current_user")
    //Call<List<Change>> loadChanges(@Query("q") String status);
    Call<User> loadChanges();
}