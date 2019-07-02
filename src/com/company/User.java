package com.company;

public abstract class User {
    static int countId = 0;
    private int id;
    private String userName;
    private String pass;
    private String email;

    public User(String userName, String pass, String email) {
        this.id = setId();
        this.setUserName(userName);
        this.setPass(pass);
        this.setEmail(email);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    private int setId() {
        countId++;
        return countId;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "\nUser name : " + this.getUserName() + "\nE-mail : " + this.getEmail() + "\nId : " + this.getId();
    }
}
