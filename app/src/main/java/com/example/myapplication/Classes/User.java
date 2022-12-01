package com.example.myapplication.Classes;

import android.os.Parcelable;

import java.io.Serializable;

public abstract class User implements Serializable{
    protected String name;
    protected String email;
    protected String password;
    protected int isAdmin;
    protected int isDisabled;
    protected authenticateUser au;
    protected accountCreator ac;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String str)
    {
        this.name = str;
    }

    public void setEmail(String str)
    {
        this.email = str;
    }

    public void setPassword(String str)
    {
        this.password = str;
    }

    public void setIsDisabled(int a)
    {
        this.isDisabled = a;
    }

    public String getPassword() {
        return password;
    }

}
