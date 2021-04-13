package com.app.companyfp_app.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by SERGIO on 03/04/2021.
 */

public interface WebService {
    //public static final String BASE_URL = "https://192.168.1.37:8084/wp/rest/companyFP/listStudents";

    public static final String BASE_URL = "http://192.168.1.39:8084/wp/rest/";

    @GET("student/listStudents")
    Call<List<User>> listStudents();

    @GET("user/login")
    Call<ResponseJSON> loginUser(@Query("email") String  email,
                            @Query("password") String password);
}
