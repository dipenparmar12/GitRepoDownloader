package com.mscit.gitgubusers;

import java.net.URL;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitUserApi {


    public final String URL = "https://api.github.com/users/";
    @GET("{gitUser}/repos")
    Call<ArrayList<GitUserDetail>>  GitUserDetail(@Path("gitUser") String gitUser);

//    public final String URL = "http://127.0.0.1/";
//    @GET("api.php")
//    Call<ArrayList<GitUserDetail>>  GitUserDetail();

}
