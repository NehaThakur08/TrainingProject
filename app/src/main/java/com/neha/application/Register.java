package com.neha.application;

import java.io.Serializable;

public class Register implements Serializable {

    public String Name;
    public String Email;
    public String Password;

    public Register(){

    }

    public Register(String name, String email, String password) {
        Name = name;
        Email = email;
        Password = password;
    }

    @Override
    public String toString() {
        return "Register{" +
                "Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
