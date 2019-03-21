package com.mscit.gitgubusers;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AdapterGitUserDetail extends RecyclerView.Adapter<AdapterGitUserDetail.ViewHolder> {

    GitUserDetailJson gitUserDetailJson;
    Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = (View) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.git_user_profile_ui,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }


    public class ViewHolder extends  RecyclerView.ViewHolder{

        TextView login,id,node_id,avatar_url,gravatar_id,url,html_url,followers_url,following_url,
                gists_url,starred_url,subscriptions_url,organizations_url,repos_url,
                events_url,received_events_url,type,site_admin,name,company,blog,location,
                email,hireable,bio,public_repos,public_gists,followers,following,created_at,updated_at;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            login = (itemView).findViewById(R.id.login);
            id = (itemView).findViewById(R.id.id);
            node_id = (itemView).findViewById(R.id.node_id);
            avatar_url = (itemView).findViewById(R.id.avatar_url);
            gravatar_id = (itemView).findViewById(R.id.gravatar_id);
            url = (itemView).findViewById(R.id.url);
            html_url = (itemView).findViewById(R.id.html_url);
            followers_url = (itemView).findViewById(R.id.followers_url);
            following_url = (itemView).findViewById(R.id.following_url);
            gists_url = (itemView).findViewById(R.id.gists_url);
            starred_url = (itemView).findViewById(R.id.starred_url);
            subscriptions_url = (itemView).findViewById(R.id.subscriptions_url);
            organizations_url = (itemView).findViewById(R.id.organizations_url);
            repos_url = (itemView).findViewById(R.id.repos_url);
            events_url = (itemView).findViewById(R.id.events_url);
            received_events_url = (itemView).findViewById(R.id.received_events_url);
            type = (itemView).findViewById(R.id.type);
            site_admin = (itemView).findViewById(R.id.site_admin);
            name = (itemView).findViewById(R.id.name);
            company = (itemView).findViewById(R.id.company);
            blog = (itemView).findViewById(R.id.blog);
            location = (itemView).findViewById(R.id.location);
            email = (itemView).findViewById(R.id.email);
            hireable = (itemView).findViewById(R.id.hireable);
            bio = (itemView).findViewById(R.id.bio);
            public_repos = (itemView).findViewById(R.id.public_repos);
            public_gists = (itemView).findViewById(R.id.public_gists);
            followers = (itemView).findViewById(R.id.followers);
            following = (itemView).findViewById(R.id.following);
            created_at = (itemView).findViewById(R.id.created_at);
            updated_at = (itemView).findViewById(R.id.updated_at);

        }

    }

}
