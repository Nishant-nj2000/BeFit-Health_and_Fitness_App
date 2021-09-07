package com.example.befit_healthandfitnessapplication;

public class UserHelperClass {

    String email,password,gender;

    public UserHelperClass()
    {

    }

    public UserHelperClass(String email, String password, String gender) {
        this.email = email;
        this.password = password;
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
