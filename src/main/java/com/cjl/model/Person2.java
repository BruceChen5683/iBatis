package com.cjl.model;

public class Person2 {
    private Integer id;
    private String username;
    private Integer mygender;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getMygender() {
        return mygender;
    }

    public void setMygender(Integer mygender) {
        this.mygender = mygender;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", mygender=" + mygender +
                '}';
    }
}
