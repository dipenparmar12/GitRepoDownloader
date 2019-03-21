package com.mscit.gitgubusers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RepoListItemsJson {

    @SerializedName("total_count")
    @Expose
    private Integer totalCount;
    @SerializedName("incomplete_results")
    @Expose
    private Boolean incompleteResults;

    @SerializedName("items") // KeyWord Convert to GitRepoDetailArrayList
    @Expose
    private ArrayList<GitRepoDetailJson> GitRepoDetailArrayList = null;

    public Integer getTotalCount() {
        return totalCount;
    }

    @Override
    public String toString() {
        return "RepoListItemsJson{" +
                "totalCount=" + totalCount +
                ", incompleteResults=" + incompleteResults +
                ", GitRepoDetailArrayList=" + GitRepoDetailArrayList +
                '}';
    }

    public Boolean getIncompleteResults() {
        return incompleteResults;
    }

    public ArrayList<GitRepoDetailJson> getGitRepoDetailArrayList() {
        return GitRepoDetailArrayList;
    }

    public RepoListItemsJson(Integer totalCount, Boolean incompleteResults, ArrayList<GitRepoDetailJson> GitRepoDetailArrayList) {
        this.totalCount = totalCount;
        this.incompleteResults = incompleteResults;
        this.GitRepoDetailArrayList = GitRepoDetailArrayList;
    }

    public String itemsArrayToString(){
        return this.GitRepoDetailArrayList.toString();
    }
}
