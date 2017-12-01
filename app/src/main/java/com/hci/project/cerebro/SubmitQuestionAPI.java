package com.hci.project.cerebro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Malavika Ramprasad on 11/29/2017.
 */

public interface SubmitQuestionAPI {
    @Headers("X-Authorization: eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoidnBhbmRpMkB1aWMuZWR1IiwiZXhwIjoxNTEyMjQ1NzY1fQ.pp_w7vKTcA6OTHDmifHAIXc9QCrt7O9GzwO66JhynRQ")
    @POST("questions")
        //Call<UserToken> addPost(@Body @Root("user") CreateUser userobj);
    Call<List<User>> addQuestion(@Body @Root("questions") SubmitQuestion quesObj);
}
