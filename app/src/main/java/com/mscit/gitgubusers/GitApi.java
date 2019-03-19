package com.mscit.gitgubusers;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;




/*

 * URL: https://api.github.com/
 * https://api.github.com/users/{user}
 * https://api.github.com/users/{user}/repos

 * URL: https://api.github.com/
 * https://api.github.com/users/taylorotwell
 * https://api.github.com/users/taylorotwell/repos

 * https://api.github.com/search/repositories?q=flexsass
 * https://api.github.com/repos/dipenparmar12/FlexSass

 */


public interface GitApi {

    public final String BASE_URL = "https://api.github.com/";

    @GET("users/{gitUser}")
    Call<GitUserDetail> getUserDetail(@Path("gitUser") String gitUser);

    @GET("users/{gitUser}/repos")
    Call<ArrayList<GitRepoDetail>> getReposByUser(@Path("gitUser") String gitUser);

//    @GET("search/repositories?q={SearchQry}")
//    Call<ArrayList<GitUserDetail>> getReposBySearch(@Path("SearchQry") String SearchQry);

}
