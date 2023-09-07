package com.domain;

public class User {

    private String username;
    private String vistorsname;
    private String psw;


    public String getVistorsname() {
        return vistorsname;
    }

    public void setVistorsname(String vistorsname) {
        this.vistorsname = vistorsname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", vistorsname='" + vistorsname + '\'' +
                ", psw='" + psw + '\'' +
                '}';
    }
}
