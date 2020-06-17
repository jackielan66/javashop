package com.example.hm_ui.model;

public class Role {
    public int id;
    public String role;
    public  String xtitle;
    public  String img;

    public Role(int id, String role, String xtitle, String img) {
        this.id = id;
        this.role = role;
        this.xtitle = xtitle;
        this.img = img;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setXtitle(String xtitle) {
        this.xtitle = xtitle;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public String getXtitle() {
        return xtitle;
    }

    public String getImg() {
        return img;
    }
}
