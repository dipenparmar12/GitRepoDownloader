package com.mscit.gitgubusers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.security.acl.Owner;

public class GitUserDetail {
    private Integer id;
    private String name;
    private String full_name;
    private String homepage;
    private String description;

    public GitUserDetail(Integer id, String name, String full_name, String homepage, String description) {
        this.id = id;
        this.name = name;
        this.full_name = full_name;
        this.homepage = homepage;
        this.description = description;
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

    public String getHomepage() {
        return homepage;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "GitUserDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", full_name='" + full_name + '\'' +
                '}';
    }

}

