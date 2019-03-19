package com.mscit.gitgubusers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterGitRepoDetail extends RecyclerView.Adapter<AdapterGitRepoDetail.ViewHolder> {

    ArrayList<GitRepoDetail> gitUserDetails;
    Context context;

    public AdapterGitRepoDetail(ArrayList<GitRepoDetail> gitUserDetails, Context context) {
        this.gitUserDetails = gitUserDetails;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.repos_list, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

//        viewHolder.textViewId.setText(gitUserDetails.get(i).getId() + ".");
//        viewHolder.textViewName.setText(gitUserDetails.get(i).getName());
//        viewHolder.textViewFullName.setText(gitUserDetails.get(i).getFull_name());

        viewHolder.textView_Id.setText(gitUserDetails.get(i).getId()+"");
        viewHolder.textView_Name.setText(gitUserDetails.get(i).getName());
        viewHolder.textView_Full_name.setText(gitUserDetails.get(i).getFull_name());
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
        viewHolder.textView_Size.setText(gitUserDetails.get(i).getSize());
        viewHolder.textView_Watchers_count.setText(gitUserDetails.get(i).getWatchers_count());
        viewHolder.textView_Forks_count.setText(gitUserDetails.get(i).getForks_count());
        viewHolder.textView_Archived.setText(gitUserDetails.get(i).getArchived());
        viewHolder.textView_Forks.setText(gitUserDetails.get(i).getForks());
        viewHolder.textView_Watchers.setText(gitUserDetails.get(i).getWatchers());
        viewHolder.textView_Default_branch.setText(gitUserDetails.get(i).getDefault_branch());

    }

    @Override
    public int getItemCount() {
        return gitUserDetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView
            textView_Id,
            textView_Name,
            textView_Full_name,
            textView_Html_url,
            textView_Description,
            textView_Url,
            textView_Languages_url,
            textView_Contributors_url,
            textView_Created_at,
            textView_Updated_at,
            textView_Git_url,
            textView_Clone_url,
            textView_Svn_url,
            textView_Homepage,
            textView_Size,
            textView_Watchers_count,
            textView_Forks_count,
            textView_Archived,
            textView_Forks,
            textView_Watchers,
            textView_Default_branch;


        TextView textViewFullName,
                textViewName,
                textViewId;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView_Id = (TextView) itemView.<View>findViewById(R.id.textView_Id);
            textView_Name = (TextView) itemView.<View>findViewById(R.id.textView_Name);
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

//            textViewId= (TextView) itemView.<View>findViewById(R.id.textView_id);
//            textViewName= (TextView) itemView.<View>findViewById(R.id.textView_name);

        }
    }


}