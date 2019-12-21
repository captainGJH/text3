package com.gjh.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class News {
    @Id
    @GeneratedValue
    private int new_id;
    private String title;
    private String time;
    private String imgurl;
    private String newbodys;
    private boolean pinglun;
    private int ox;
    private boolean fabu;

    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "news")
    private List<Comment> commentslist=new ArrayList<>();

    public List<Comment> getCommentslist() {
        return commentslist;
    }

    public void setCommentslist(List<Comment> commentslist) {
        this.commentslist = commentslist;
    }

    public boolean isFabu() {
        return fabu;
    }

    public void setFabu(boolean fabu) {
        this.fabu = fabu;
    }

    public boolean isPinglun() {
        return pinglun;
    }

    public void setPinglun(boolean pinglun) {
        this.pinglun = pinglun;
    }

    public int getOx() {
        return ox;
    }

    public void setOx(int ox) {
        this.ox = ox;
    }

    public int getNew_id() {
        return new_id;
    }

    public void setNew_id(int new_id) {
        this.new_id = new_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getNewbodys() {
        return newbodys;
    }

    public void setNewbodys(String newbodys) {
        this.newbodys = newbodys;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
