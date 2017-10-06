package com.example.a1694163.github;

/**
 * Created by Harsh on 10/2/2017.
 */

public class Users {

    private String name;
    private String prourl;

    public Users(String name,String prourl) {
        this.name = name;
        this.prourl=prourl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProurl() {
        return prourl;
    }

    public void setProurl(String prourl) {
        this.prourl = prourl;
    }}