package com.mscit.gitgubusers;

import android.app.LauncherActivity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AdapterGitUserDetail extends RecyclerView.Adapter<AdapterGitUserDetail.ViewHolder>{

    ArrayList<GitUserDetail> gitUserDetails;
    Context context;

    public AdapterGitUserDetail(ArrayList<GitUserDetail> gitUserDetails, Context context) {
        this.gitUserDetails = gitUserDetails;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.repos_list,viewGroup,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.textViewId.setText(gitUserDetails.get(i).getId()+".");
        viewHolder.textViewName.setText(gitUserDetails.get(i).getName());
        viewHolder.textViewFullName.setText(gitUserDetails.get(i).getFull_name());

    }

    @Override
    public int getItemCount() {
        return gitUserDetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewFullName,textViewName,textViewId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

//            textViewId= (TextView) itemView.<View>findViewById(R.id.textView_id);
//            textViewName= (TextView) itemView.<View>findViewById(R.id.textView_name);
//            textViewFullName= (TextView) itemView.<View>findViewById(R.id.textView_full_name);

        }
    }

}
