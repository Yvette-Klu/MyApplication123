package com.example.myapplication;

public class SignUp {

    String userName, email, passWord;

    public SignUp(String username, String email, String password) {
        this.userName = username;
        this.email = email;
        this.passWord = password;
    }

    public String getuserName() {
        return userName;
    }

    public void setuserName(String username) {
        this.userName = username;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getpassWord() {
        return passWord;
    }

    public void setPassWord(String password) {
        this.passWord= password;
    }


}
