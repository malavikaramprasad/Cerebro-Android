package com.hci.project.cerebro;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;

/**
 * Created by Malavika Ramprasad on 12/1/2017.
 */

public interface TutorRequestsAPI {
    @GET("current_user/requests")
    Call<List<SubmitQuestion>> getRequests(@HeaderMap Map<String, String> headers);
}
