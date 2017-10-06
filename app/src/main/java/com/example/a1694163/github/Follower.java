package com.example.a1694163.github;

/**
 * Created by 1694163 on 9/9/2017.
 */

class Follower {
    private String imageurl;
    private String name;
    private String followerurl;
    private String prourl;

    public Follower(String imageurl, String name, String followerurl, String prourl) {
        this.imageurl = imageurl;
        this.name = name;
        this.followerurl = followerurl;
        this.prourl = prourl;

    }

    public String getProurl() {
        return prourl;
    }

    public void setProurl(String prourl) {
        this.prourl = prourl;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFollowerurl() {
        return followerurl;
    }

    public void setFollowerurl(String followerurl) {
        this.followerurl = followerurl;
    }
}
