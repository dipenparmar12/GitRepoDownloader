package com.mscit.gitgubusers;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitUserApi {

    public final String URL = "https://api.github.com/users/";

    @GET("{gitUser}/repos")
    Call<ArrayList<GitRepoDetail>>  GitUserDetail(@Path("gitUser") String gitUser);

    @GET("{gitUser}/repos")
    Call<ArrayList<GitUserDetail>>  GitRepoDetail(@Path("gitUser") String gitUser);

}
