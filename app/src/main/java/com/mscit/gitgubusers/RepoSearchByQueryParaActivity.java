package com.mscit.gitgubusers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RepoSearchByQueryParaActivity extends AppCompatActivity implements Callback {

    Retrofit retrofit;
    GitRepoDetailJson gitUserDetail;
    String serach_qry, radioGroupSearchType;
    ProgressBar progressBar;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    GitApi gitApi;

    Call<GitUserDetailJson> call_GitUserDetail;
    Call<RepoListItemsJson> call_GitRepoSearchByQueryPara;

    final String TAG = "dipen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG,"RepoSearchByQueryPar Activity():");
        setContentView(R.layout.activity_git_repo_detail);

        radioGroupSearchType = getIntent().getExtras().getString("radioGroupSearchType");
        serach_qry = getIntent().getExtras().getString("textViewSearchQry");

        retrofit = new Retrofit.Builder().baseUrl(GitApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        gitApi = retrofit.create(GitApi.class);

        call_GitRepoSearchByQueryPara = gitApi.getReposBySearchPara(serach_qry); // Set_serach_qry
        call_GitRepoSearchByQueryPara.enqueue(this);

    }


    @Override
    public void onResponse(Call call, Response response) {
        Log.e(TAG, "onResponse_Body: " + response.body());
        Log.e(TAG, "onResponse_ResponseObject: " + response);

        if (response.isSuccessful()) {
            Log.e(TAG,"RepoSearchByQrypara:Response.isSuccessful:");

            if (response.body() == null) {
                Toast.makeText(getApplicationContext(), serach_qry + ":Repository NotFound:", Toast.LENGTH_SHORT).show();
                getApplicationContext().startActivity(new Intent(getApplicationContext(), HomePage.class).putExtra("textViewSearchQry", serach_qry));

            } else {

                RepoListItemsJson repoListItemsJson = (RepoListItemsJson) response.body();

                recyclerView = findViewById(R.id.recyclerViewGiUser);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new AdapterGitRepoDetail(repoListItemsJson.getGitRepoDetailArrayList(), getApplicationContext());
                recyclerView.setAdapter(adapter);

            }

            progressBar = findViewById(R.id.progressBar1);
            progressBar.setVisibility(View.INVISIBLE);

        } else {

            Toast.makeText(getApplicationContext(), serach_qry + ":Repository NotFound:", Toast.LENGTH_SHORT).show();
            getApplicationContext().startActivity(new Intent(getApplicationContext(), HomePage.class).putExtra("textViewSearchQry", serach_qry));

        }

    }

    @Override
    public void onFailure(Call call, Throwable t) {
        Log.e(TAG, "FAILED :" + t.toString());
    }


}
