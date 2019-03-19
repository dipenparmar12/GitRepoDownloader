package com.mscit.gitgubusers;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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

public class MainActivity extends AppCompatActivity implements Callback<ArrayList<GitUserDetail>> {


//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.repos_list);
//    }

    final String TAG = "dipen";

    Retrofit retrofit;
    GitUserDetail gitUserDetail;
    String serach_qry;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        String radioGroupSearchType = getIntent().getExtras().getString("radioGroupSearchType");
        serach_qry = getIntent().getExtras().getString("textViewSearchQry");

        Log.e(TAG, "onCreate():+Qry: " + serach_qry);

        retrofit = new Retrofit.Builder()
                .baseUrl(GitUserApi.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitUserApi gitUserApi = retrofit.create(GitUserApi.class);

//        Call<ArrayList<GitUserDetail>> call = gitUserApi.GitUserDetail();
        Call<ArrayList<GitUserDetail>> call = gitUserApi.GitUserDetail(serach_qry);

        call.enqueue(this);

    }

//    @Override
//    public void onResponse(Call<ArrayList<GitUserDetail>> call, Response<ArrayList<GitUserDetail>> response) {
//        Log.e(TAG, "onResponse:" + response.body().toString());
//        ArrayList<GitUserDetail> gitUserDetails = response.body();
//        recyclerView = findViewById(R.id.recyclerViewGiUser);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//
//        adapter = new AdapterGitUserDetail(gitUserDetails, getApplicationContext());
//        recyclerView.setAdapter(adapter);
//
//        ProgressBar progressBar = findViewById(R.id.progressBar1);
//        progressBar.setVisibility(View.INVISIBLE);
//    }

    @Override
    public void onResponse(Call call, Response response) {
        Log.e(TAG, "onResponse:" + response);

        if (response.body() == null) {
            Log.e(TAG, "userNotFound:" + response.body());

//            Intent intent = new Intent(getApplicationContext(), HomePage.class);
//            intent.putExtra("textViewSearchQry",serach_qry);
//            startActivity(intent);

            startActivity(new Intent(getApplicationContext(), HomePage.class).putExtra("textViewSearchQry",serach_qry));
            Toast.makeText(getApplicationContext(), "User not Found", Toast.LENGTH_SHORT).show();

        } else {

            Log.e(TAG, "userFound:" + response.body());

            ArrayList<GitUserDetail> gitUserDetails = new ArrayList<GitUserDetail>();
            gitUserDetails = (ArrayList<GitUserDetail>) response.body();

            recyclerView = findViewById(R.id.recyclerViewGiUser);
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

            adapter = new AdapterGitUserDetail(gitUserDetails, getApplicationContext());
            recyclerView.setAdapter(adapter);

        }

        progressBar = findViewById(R.id.progressBar1);
        progressBar.setVisibility(View.INVISIBLE);
    }


    @Override
    public void onFailure(Call<ArrayList<GitUserDetail>> call, Throwable t) {
        Log.e(TAG, "onFailure(): ");
        Log.e(TAG, t.toString());
    }
}
