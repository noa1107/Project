package com.example.project;

public class User
{
    private String uName;
    private String email;
    private String phoneNumber;
    private String bCountry;
    private String imgSrc;
    private int friends;
    private int cTracks;

    public User() { }

    public User(String uName, String email, String password, String PhoneNumber, String bCountry)
    {
        this.uName = uName;
        this.email = email;
        this.phoneNumber=PhoneNumber;
        this.bCountry=bCountry;
        this.friends=0;
        this.cTracks=0;
        this.imgSrc="choose your profile photo!";
    }

    public User(User u)
    {
        uName=u.uName;
        email=u.email;
        phoneNumber=u.phoneNumber;
        bCountry=u.bCountry;
    }
    public User(String email)
    {
        this.email=email;
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


    public String getPhoneNumber() {return phoneNumber;}


    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public String getbCountry() {
        return bCountry;
    }

    public void setbCountry(String bCountry) {
        this.bCountry = bCountry;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public int getFriends() {
        return friends;
    }

    public void setFriends(int friends) {
        this.friends = friends;
    }

    public int getcTracks() {
        return cTracks;
    }

    public void setcTracks() {
        this.cTracks ++;
    }
}
