package com.mscit.gitgubusers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



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

public class MainActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repos_list);
    }


//    Retrofit retrofit;
//    GitUserDetail gitUserDetail;
//    final String TAG = "dipen";
//
//    RecyclerView recyclerView;
//    RecyclerView.Adapter adapter;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        Log.e(TAG, "onCreate():");
//        retrofit = new Retrofit.Builder()
//                .baseUrl(GitUserApi.URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        GitUserApi gitUserApi = retrofit.create(GitUserApi.class);
//
////        Call<ArrayList<GitUserDetail>> call = gitUserApi.GitUserDetail();
//        Call<ArrayList<GitUserDetail>> call = gitUserApi.GitUserDetail("dipenparmar12");
//
//        call.enqueue(new Callback<ArrayList<GitUserDetail>>() {
//            @Override
//            public void onResponse(Call<ArrayList<GitUserDetail>> call, Response<ArrayList<GitUserDetail>> response) {
//                Log.e(TAG, "onResponse:");
//
//                ArrayList<GitUserDetail> gitUserDetails = response.body();
//                Log.e(TAG, ":"+response.body().toString());
////
////                for (GitUserDetail gitUserDetail : gitUserDetails){
////                    Log.e(TAG, gitUserDetail.toString()+", \n" );
////                    textView.append(gitUserDetail.toString()+", \n");
////                }
//
//                recyclerView = findViewById(R.id.recyclerViewGiUser);
//                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//                adapter = new AdapterGitUserDetail(gitUserDetails,getApplicationContext());
//                recyclerView.setAdapter(adapter);
//
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<GitUserDetail>> call, Throwable t) {
//                Log.e(TAG, "onFailure(): " );
//                Log.e(TAG, t.toString());
//            }
//        });
//
//    }
//

}
