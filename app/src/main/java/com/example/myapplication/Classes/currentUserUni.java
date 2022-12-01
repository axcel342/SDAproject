package com.example.myapplication.Classes;

public class currentUserUni {
    private static currentUserUni instance = null;
    private University a;

    private currentUserUni(University obj)
    {
        this.a = obj;
    }

    public static currentUserUni getInstance(University obj2)
    {
        if(instance == null)
        {
            instance = new currentUserUni(obj2);
        }
        return instance;
    }

    public University getU() {
        return a;
    }

    public void logout()
    {
        instance = null;
        this.a = null;
    }
}
