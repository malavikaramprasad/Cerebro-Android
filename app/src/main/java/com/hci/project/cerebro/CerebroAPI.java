package com.hci.project.cerebro;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by Malavika Ramprasad on 11/29/2017.
 */

public interface CerebroAPI {
    @Headers("X-Authorization: eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoidnBhbmRpMkB1aWMuZWR1IiwiZXhwIjoxNTEyMDI0NDAxfQ.qpK4xDnfcRUI1D9VKPH5EtOMjyvsGN2F2gKUisTPZh8")
    @GET("current_user")
    //Call<List<Change>> loadChanges(@Query("q") String status);
    Call<User> loadChanges();
}