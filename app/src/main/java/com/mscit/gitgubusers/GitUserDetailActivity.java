package com.mscit.gitgubusers;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GitUserDetailActivity extends AppCompatActivity implements Callback {

    Retrofit retrofit;
    GitApi gitApi;
    GitUserDetailJson gitUserDetailJson;

    String serach_qry;
    Button btn_back, btn_show_repos;
    final String TAG = "dipen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.git_user_profile_ui);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            serach_qry = getIntent().getExtras().getString("textViewSearchQry");
        } else {
            serach_qry = "";
        }

        retrofit = new Retrofit.Builder().baseUrl(GitApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        gitApi = retrofit.create(GitApi.class);

        // Passing SearchQRy to GitAPi ( prepering data For Sending Request )
        Call<GitUserDetailJson> call_GitUserDetail = gitApi.getUserDetail(serach_qry); // set to serach_qry
        call_GitUserDetail.enqueue(this);


        // Goto HomePage Btn (Back Btn)
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HomePage.class));
            }
        }); // BackBtn()


    } // onCreate();


    @Override
    public void onResponse(Call call, Response response) {

        if (response.isSuccessful()) {
            Log.e(TAG, "userNotFound:" + response.body());

            // Response Error Hander Condition
            if (response.body() == null) {

                // IF Response not Found , Redirected to HomePage Back with Toast Msg (intent)
                Toast.makeText(getApplicationContext(), serach_qry + " :User NotFound:", Toast.LENGTH_SHORT).show();
                getApplicationContext().startActivity(new Intent(getApplicationContext(), HomePage.class).putExtra("textViewSearchQry", serach_qry));

            } else {

                ImageView avatar_url;
                TextView login, id, node_id, gravatar_id, url, html_url, followers_url, following_url,
                        gists_url, starred_url, subscriptions_url, organizations_url, repos_url,
                        events_url, received_events_url, type, site_admin, name, company, blog, location,
                        email, hireable, bio, public_repos, public_gists, followers, following, created_at, updated_at;

                gitUserDetailJson = (GitUserDetailJson) response.body();

                Log.e(TAG, "onResponse:" + gitUserDetailJson);

                login = findViewById(R.id.login);
                id = findViewById(R.id.id);
                node_id = findViewById(R.id.node_id);
                avatar_url = findViewById(R.id.avatar_url);
                gravatar_id = findViewById(R.id.gravatar_id);
                url = findViewById(R.id.url);
                html_url = findViewById(R.id.html_url);
                followers_url = findViewById(R.id.followers_url);
                following_url = findViewById(R.id.following_url);
                gists_url = findViewById(R.id.gists_url);
                starred_url = findViewById(R.id.starred_url);
                subscriptions_url = findViewById(R.id.subscriptions_url);
                organizations_url = findViewById(R.id.organizations_url);
                repos_url = findViewById(R.id.repos_url);
                events_url = findViewById(R.id.events_url);
                received_events_url = findViewById(R.id.received_events_url);
                type = findViewById(R.id.type);
                site_admin = findViewById(R.id.site_admin);
                name = findViewById(R.id.name);
                company = findViewById(R.id.company);
                blog = findViewById(R.id.blog);
                location = findViewById(R.id.location);
                email = findViewById(R.id.email);
                hireable = findViewById(R.id.hireable);
                bio = findViewById(R.id.bio);
                public_repos = findViewById(R.id.public_repos);
                public_gists = findViewById(R.id.public_gists);
                followers = findViewById(R.id.followers);
                following = findViewById(R.id.following);
                created_at = findViewById(R.id.created_at);
                updated_at = findViewById(R.id.updated_at);


                login.setText("login: " + gitUserDetailJson.getLogin());
                id.setText("id: " + gitUserDetailJson.getId());
                node_id.setText("node_id: " + gitUserDetailJson.getNode_id());

                // Fetching Avater_image to imageView (User Profile,DP)
                String image_url = gitUserDetailJson.getAvatar_url();
                Picasso.get().load(image_url).into(avatar_url);

//            gravatar_id.setText("gravatar_id: " + gitUserDetailJson.getGravatar_id());
                url.setText("url: " + gitUserDetailJson.getUrl());
                html_url.setText("html_url: " + gitUserDetailJson.getHtml_url());
                followers_url.setText("followers_url: " + gitUserDetailJson.getFollowers_url());
                following_url.setText("following_url: " + gitUserDetailJson.getFollowing_url());
                gists_url.setText("gists_url: " + gitUserDetailJson.getGists_url());
                starred_url.setText("starred_url: " + gitUserDetailJson.getStarred_url());
                subscriptions_url.setText("subscriptions_url: " + gitUserDetailJson.getSubscriptions_url());
                organizations_url.setText("organizations_url: " + gitUserDetailJson.getOrganizations_url());
                repos_url.setText("repos_url: " + gitUserDetailJson.getRepos_url());
                events_url.setText("events_url: " + gitUserDetailJson.getEvents_url());
                received_events_url.setText("received_events_url: " + gitUserDetailJson.getReceived_events_url());
                type.setText("type: " + gitUserDetailJson.getType());
                site_admin.setText("site_admin: " + gitUserDetailJson.getSite_admin());
                name.setText(gitUserDetailJson.getName());
                company.setText("company: " + gitUserDetailJson.getCompany());
                blog.setText("blog: " + gitUserDetailJson.getBlog());
                location.setText("location: " + gitUserDetailJson.getLocation());
                email.setText("email: " + gitUserDetailJson.getEmail());
                hireable.setText("hireable: " + gitUserDetailJson.getHireable());
                bio.setText("bio: " + gitUserDetailJson.getBio());
                public_repos.setText(gitUserDetailJson.getPublic_repos());
                public_gists.setText("public_gists: " + gitUserDetailJson.getPublic_gists());
                followers.setText(gitUserDetailJson.getFollowers());
                following.setText(gitUserDetailJson.getFollowing());
                created_at.setText("created_at: " + gitUserDetailJson.getCreated_at());
                updated_at.setText("updated_at: " + gitUserDetailJson.getUpdated_at());


                // Remove ProgressBar When Data Successfly loaded to Activity
                ProgressBar git_user_profile_ui_progressBar = findViewById(R.id.git_user_profile_ui_progressBar);
                git_user_profile_ui_progressBar.setVisibility(View.GONE);

                // Set Visitble userProfile Layouy When Data Successfly loaded to Activity
                LinearLayout git_user_profile_ui_linearLayout = findViewById(R.id.git_user_profile_ui_linear_layout);
                git_user_profile_ui_linearLayout.setVisibility(View.VISIBLE);

                // Set Visitble userProfile ExtraDetails (Detailed Data) Layouy When Data Successfly loaded to Activity
                LinearLayout git_user_profile_ui_linear_layout_extra_details = findViewById(R.id.git_user_profile_ui_linear_layout_extra_details);
                git_user_profile_ui_linear_layout_extra_details.setVisibility(View.VISIBLE);


                btn_show_repos = findViewById(R.id.btn_download_repo);
                btn_show_repos.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(), GitRepoDetailActivity.class)
                                .putExtra("textViewSearchQry", gitUserDetailJson.getLogin())
                        );
                    }
                }); // Show users Repositiries

            } // IF-Else() on Error

        } else {
            Toast.makeText(getApplicationContext(), serach_qry + " :User NotFound:", Toast.LENGTH_SHORT).show();
            getApplicationContext().startActivity(new Intent(getApplicationContext(), HomePage.class).putExtra("textViewSearchQry", serach_qry));

        }// Response.isSuccessful();

    } // onResponse();


    @Override
    public void onFailure(Call call, Throwable t) {
        Log.e(TAG, "FAILED :" + t.toString());
    } // onFailure()


} // #GitUserDetailActivity
