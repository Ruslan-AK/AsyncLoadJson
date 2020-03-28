package com.example.asyncmethod;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String name;
    private String blog;
    private String email;
    @JsonProperty(value = "repos_url")
    private String reposUrl;

    @Override
    public String toString() {
        return "\nUser{" +
                "name='" + name + '\'' +
                ", blog='" + blog + '\'' +
                ", email='" + email + '\'' +
                ", reposUrl='" + reposUrl + '\'' +
                ", repos=" + repos +
                "\n}";
    }

    private List<Repos> repos;

    public List<Repos> getRepos() {
        return repos;
    }

    public void setRepos(List<Repos> repos) {
        this.repos = repos;
    }

    public String getReposUrl() {
        return reposUrl;
    }

    public void setReposUrl(String reposUrl) {
        this.reposUrl = reposUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }
}
