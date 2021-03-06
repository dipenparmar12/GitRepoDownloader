package com.mscit.gitgubusers;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class AdapterGitRepoDetail extends RecyclerView.Adapter<AdapterGitRepoDetail.ViewHolder> {

    ArrayList<GitRepoDetailJson> gitUserDetails;
    Context context;

    public AdapterGitRepoDetail(ArrayList<GitRepoDetailJson> gitUserDetails, Context context) {
        this.gitUserDetails = gitUserDetails;
        this.context = context;
    } // AdapterGitRepoDetail() Constructor


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.repos_list, viewGroup, false);

        // onClick Event on Recycler View
        return new ViewHolder(v,context,gitUserDetails);

        // onClick Event on Recycler View
        // return new ViewHolder(v);

    } // onCreateViewHolder();

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        viewHolder.textView_Id.setText("Id: "+gitUserDetails.get(i).getId());
        viewHolder.textView_Name.setText(gitUserDetails.get(i).getName());
        viewHolder.textView_Full_name.setText(gitUserDetails.get(i).getFull_name());
        viewHolder.textView_login_value.setText(gitUserDetails.get(i).getOwnerJson().getLogin());
        viewHolder.textView_Html_url.setText(gitUserDetails.get(i).getHtml_url());
        viewHolder.textView_Description.setText(gitUserDetails.get(i).getDescription());
        viewHolder.textView_Url.setText(gitUserDetails.get(i).getUrl());
        viewHolder.textView_Languages_url.setText(gitUserDetails.get(i).getLanguages_url());
        viewHolder.textView_Contributors_url.setText(gitUserDetails.get(i).getContributors_url());
        viewHolder.textView_Created_at.setText(gitUserDetails.get(i).getCreated_at());
        viewHolder.textView_Updated_at.setText(gitUserDetails.get(i).getUpdated_at());
        viewHolder.textView_Git_url.setText(gitUserDetails.get(i).getGit_url());
        viewHolder.textView_Clone_url.setText(gitUserDetails.get(i).getClone_url());
        viewHolder.textView_Svn_url.setText(gitUserDetails.get(i).getSvn_url());
        viewHolder.textView_Homepage.setText(gitUserDetails.get(i).getHomepage());
        viewHolder.textView_Size.setText(gitUserDetails.get(i).getSize()+" KB");
        viewHolder.textView_Watchers_count.setText(gitUserDetails.get(i).getWatchers_count());
        viewHolder.textView_Forks_count.setText(gitUserDetails.get(i).getForks_count());
        viewHolder.textView_Archived.setText(gitUserDetails.get(i).getArchived());
        viewHolder.textView_Forks.setText(gitUserDetails.get(i).getForks());
        viewHolder.textView_Watchers.setText(gitUserDetails.get(i).getWatchers());
        viewHolder.textView_Default_branch.setText(gitUserDetails.get(i).getDefault_branch());


        // RepoDownload Btn CLicked Event
        viewHolder.btn_download_repo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String repoDownloadUrl = gitUserDetails.get(i).getSvn_url()+"/archive/"+gitUserDetails.get(i).getDefault_branch()+".zip";

                Log.e("ButtonClicked", "DownloadUrl:"+repoDownloadUrl);
                Log.e("ButtonClicked", "BtnRepo onClick:"+gitUserDetails.get(i).getName());
                Toast.makeText(context, "Downloading Started :"+gitUserDetails.get(i).getName(), Toast.LENGTH_SHORT).show();

                downloadRepoByUrl(repoDownloadUrl,gitUserDetails.get(i).getFull_name());

            }
        });
        //

    } // onBindViewHolder();

    @Override
    public int getItemCount() {
        return gitUserDetails.size();
    } // getItenCount();

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView_Id,textView_Name,textView_Full_name,textView_Html_url,textView_Description,
                textView_Url,textView_Languages_url,textView_Contributors_url,textView_Created_at,
                textView_Updated_at,textView_Git_url,textView_Clone_url,textView_Svn_url,textView_Homepage,
                textView_Size,textView_Watchers_count,textView_Forks_count,textView_Archived,textView_Forks,
                textView_Watchers,textView_Default_branch,textView_login_value;

        // onClick Event on Recycler View
        ArrayList<GitRepoDetailJson> gitRepoDetailJsons = new ArrayList<GitRepoDetailJson>();
        Button btn_download_repo;
        Context context;
        //

        public ViewHolder(@NonNull View itemView, final Context context, final ArrayList<GitRepoDetailJson> gitRepoDetailJsons) {
            super(itemView);

            this.context = context;
            this.gitRepoDetailJsons = gitRepoDetailJsons;

            // onClick Event on Recycler View
            itemView.setOnClickListener(this);
            //

            // RepoDownload Btn CLicked Event
            btn_download_repo = itemView.findViewById(R.id.btn_download_repo);

            textView_Id = (TextView) itemView.<View>findViewById(R.id.textView_Id);
            textView_Name = (TextView) itemView.<View>findViewById(R.id.textView_Name);
            textView_login_value = (TextView) itemView.<View>findViewById(R.id.textView_login_value);
            textView_Full_name = (TextView) itemView.<View>findViewById(R.id.textView_Full_name);
            textView_Html_url = (TextView) itemView.<View>findViewById(R.id.textView_Html_url);
            textView_Description = (TextView) itemView.<View>findViewById(R.id.textView_Description);
            textView_Url = (TextView) itemView.<View>findViewById(R.id.textView_Url);
            textView_Languages_url = (TextView) itemView.<View>findViewById(R.id.textView_Languages_url);
            textView_Contributors_url = (TextView) itemView.<View>findViewById(R.id.textView_Contributors_url);
            textView_Created_at = (TextView) itemView.<View>findViewById(R.id.textView_Created_at);
            textView_Updated_at = (TextView) itemView.<View>findViewById(R.id.textView_Updated_at);
            textView_Git_url = (TextView) itemView.<View>findViewById(R.id.textView_Git_url);
            textView_Clone_url = (TextView) itemView.<View>findViewById(R.id.textView_Clone_url);
            textView_Svn_url = (TextView) itemView.<View>findViewById(R.id.textView_Svn_url);
            textView_Homepage = (TextView) itemView.<View>findViewById(R.id.textView_Homepage);
            textView_Size = (TextView) itemView.<View>findViewById(R.id.textView_Size);
            textView_Watchers_count = (TextView) itemView.<View>findViewById(R.id.textView_Watchers_count);
            textView_Forks_count = (TextView) itemView.<View>findViewById(R.id.textView_Forks_count);
            textView_Archived = (TextView) itemView.<View>findViewById(R.id.textView_Archived);
            textView_Forks = (TextView) itemView.<View>findViewById(R.id.textView_Forks);
            textView_Watchers = (TextView) itemView.<View>findViewById(R.id.textView_Watchers);
            textView_Default_branch = (TextView) itemView.<View>findViewById(R.id.textView_Default_branch);

        } // viewHolder();



        // onClick Event on Recycler View
        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            GitRepoDetailJson gitRepoDetailsJson = this.gitRepoDetailJsons.get(position);
            Toast.makeText(context, ""+ gitRepoDetailsJson.getName(), Toast.LENGTH_SHORT).show();
            context.startActivity(new Intent(this.context,HomePage.class));
        } // onClick()

    }  // #ViewHolder InnerClass



    public void downloadRepoByUrl(String url,String fileName){
        Uri download_url = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(download_url);
        request.setTitle("GitRepo_"+fileName);
        request.setVisibleInDownloadsUi(true);
//        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,"/GitRepos/"+fileName);
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        downloadManager.enqueue(request);

//        AndroidNetworking.download(url,"",fileName).build()
//                .setDownloadProgressListener(new DownloadProgressListener() {
//                    public void onProgress(long bytesDownloaded, long totalBytes) {
//                        bar.setMax((int) totalBytes);
//                        bar.setProgress((int) bytesDownloaded);
//                    }
//                }).startDownload(new DownloadListener() {
//            public void onDownloadComplete() {
//            ...
//            }
//
//            public void onError(ANError error) {
//            ...
//            }
//        });

        

    } // downloadRepoByUrl(String);






} // # AdapterGitRepoDetail