package com.hci.project.cerebro;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Malavika Ramprasad on 11/29/2017.
 */

public interface SubmitQuestionAPI {
    @Headers("content_type: application/json")
    @POST("questions")
        //Call<UserToken> addPost(@Body @Root("user") CreateUser userobj);
    Call<User> addQuestion(@Body @Root("questions") SubmitQuestion quesObj);
}
