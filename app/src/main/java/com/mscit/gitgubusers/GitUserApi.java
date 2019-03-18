package com.mscit.gitgubusers;

import java.net.URL;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitUserApi {


//    public final String URL = "https://api.github.com/";
//    @GET("users/{name}")
//    Call<ArrayList<GitUserDetail>>  GitUserDetail(@Path("name") String name);

//    public final String URL = "https://api.github.com/users/";
//    @GET("dipenparmar12/repos")
//    Call<ArrayList<GitUserDetail>>  GitUserDetail();

    public final String URL = "https://api.github.com/users/";
    @GET("{gitUser}/repos")
    Call<ArrayList<GitUserDetail>>  GitUserDetail(@Path("gitUser") String gitUser);

}
