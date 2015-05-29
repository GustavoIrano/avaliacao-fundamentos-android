package com.example.administrador.myapplication.models.entities;

/**
 * Created by Administrador on 28/05/2015.
 */
public class ServiceUser{

    private Integer mId;
    private String mName;
    private String mPassword;

    public ServiceUser(){
        super();
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        this.mId = id;
    }

    public String getName(){
        return mName;
    }

    public void setName(String name){
        this.mName = name;
    }

    public String getPassword(){
        return mPassword;
    }

    public void setPassword(String password){
        this.mPassword = password;
    }
}
