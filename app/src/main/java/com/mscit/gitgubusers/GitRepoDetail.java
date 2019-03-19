package com.mscit.gitgubusers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.security.acl.Owner;

public class GitRepoDetail {
    private Integer id;
    private  String name,full_name,html_url,description,url,languages_url,contributors_url,created_at,updated_at,git_url,clone_url,svn_url,homepage,size,watchers_count,forks_count,archived,forks,watchers,default_branch;

    public GitRepoDetail(Integer id, String name, String full_name, String html_url, String description, String url, String languages_url, String contributors_url, String created_at, String updated_at, String git_url, String clone_url, String svn_url, String homepage, String size, String watchers_count, String forks_count, String archived, String forks, String watchers, String default_branch) {
        this.id = id;
        this.name = name;
        this.full_name = full_name;
        this.html_url = html_url;
        this.description = description;
        this.url = url;
        this.languages_url = languages_url;
        this.contributors_url = contributors_url;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.git_url = git_url;
        this.clone_url = clone_url;
        this.svn_url = svn_url;
        this.homepage = homepage;
        this.size = size;
        this.watchers_count = watchers_count;
        this.forks_count = forks_count;
        this.archived = archived;
        this.forks = forks;
        this.watchers = watchers;
        this.default_branch = default_branch;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getHtml_url() {
        return html_url;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getLanguages_url() {
        return languages_url;
    }

    public String getContributors_url() {
        return contributors_url;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getGit_url() {
        return git_url;
    }

    public String getClone_url() {
        return clone_url;
    }

    public String getSvn_url() {
        return svn_url;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getSize() {
        return size;
    }

    public String getWatchers_count() {
        return watchers_count;
    }

    public String getForks_count() {
        return forks_count;
    }

    public String getArchived() {
        return archived;
    }

    public String getForks() {
        return forks;
    }

    public String getWatchers() {
        return watchers;
    }

    public String getDefault_branch() {
        return default_branch;
    }

}
