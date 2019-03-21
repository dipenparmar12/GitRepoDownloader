package com.mscit.gitgubusers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RepoListItemsJson {

    @SerializedName("total_count")
    @Expose
    private Integer ReposFoundTotalCount;
    @SerializedName("incomplete_results")
    @Expose
    private Boolean incompleteResults;

    @SerializedName("items") // KeyWord Convert to GitRepoDetailArrayList
    @Expose
    private ArrayList<GitRepoDetailJson> GitRepoDetailArrayList = null;

    public Integer getReposFoundTotalCount() {
        return ReposFoundTotalCount;
    }

    public Boolean getIncompleteResults() {
        return incompleteResults;
    }

    public ArrayList<GitRepoDetailJson> getGitRepoDetailArrayList() {
        return GitRepoDetailArrayList;
    }

    public RepoListItemsJson(Integer ReposFoundTotalCount, Boolean incompleteResults, ArrayList<GitRepoDetailJson> GitRepoDetailArrayList) {
        this.ReposFoundTotalCount = ReposFoundTotalCount;
        this.incompleteResults = incompleteResults;
        this.GitRepoDetailArrayList = GitRepoDetailArrayList;
    }

    public String itemsArrayToString(){
        return this.GitRepoDetailArrayList.toString();
    }

    @Override
    public String toString() {
        return "RepoListItemsJson{" +
                "ReposFoundTotalCount=" + ReposFoundTotalCount +
                ", incompleteResults=" + incompleteResults +
                ", GitRepoDetailArrayList=" + GitRepoDetailArrayList +
                '}';
    }
}
