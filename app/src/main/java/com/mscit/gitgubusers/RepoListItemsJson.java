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
    @SerializedName("items")
    @Expose
    private ArrayList<GitRepoDetailJson> items = null;

    public Integer getTotalCount() {
        return totalCount;
    }

    @Override
    public String toString() {
        return "RepoListItemsJson{" +
                "totalCount=" + totalCount +
                ", incompleteResults=" + incompleteResults +
                ", items=" + items +
                '}';
    }

    public Boolean getIncompleteResults() {
        return incompleteResults;
    }

    public ArrayList<GitRepoDetailJson> getItems() {
        return items;
    }

    public RepoListItemsJson(Integer totalCount, Boolean incompleteResults, ArrayList<GitRepoDetailJson> items) {
        this.totalCount = totalCount;
        this.incompleteResults = incompleteResults;
        this.items = items;
    }

    public String arrayToString(){
        return this.items.toString();
    }
}
