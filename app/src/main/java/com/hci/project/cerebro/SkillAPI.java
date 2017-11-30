package com.hci.project.cerebro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

/**
 * Created by Malavika Ramprasad on 11/30/2017.
 */

public interface SkillAPI {
    @Headers("X-Authorization: eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoidnBhbmRpMkB1aWMuZWR1IiwiZXhwIjoxNTEyMTU1MjY4fQ.1ucDSDzGjnEgN--t_TuYolwlfagf9jPsDVo6kG1cXPU")
    @GET("skills")
    Call<List<Skill>> getSkills();
}
