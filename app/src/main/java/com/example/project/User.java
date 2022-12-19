package com.example.project;

public class User
{
    private String uName;
    private String email;
    private String password;
    private String phoneNumber;
    private String bCountry;

    public User() { }

    public User(String uName, String email, String password, String PhoneNumber, String bCountry)
    {
        this.uName = uName;
        this.email = email;
        this.password = password;
        this.phoneNumber=PhoneNumber;
        this.bCountry=bCountry;
    }

    public User(User u)
    {
        uName=u.uName;
        email=u.email;
        password=u.password;
        phoneNumber=u.phoneNumber;
        bCountry=u.bCountry;
    }


    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
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

    public String getPhoneNumber() {return phoneNumber;}

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
}
