package com.slocupdation.sloc_updation.retrofit;

import com.slocupdation.sloc_updation.parser.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("login.php")
    Call<LoginResponse> getLoginInfo(
            @Query("mobile1") String username, @Query("password") String password
    );
}
