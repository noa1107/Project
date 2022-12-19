package com.example.project;

public class post
{
    private String userName;
    private String subject;
    private String conect;

    public post(String userName, String subject, String conect) {
        this.userName = userName;
        this.subject = subject;
        this.conect = conect;
    }

    public post() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getConect() {
        return conect;
    }

    public void setConect(String conect) {
        this.conect = conect;
    }
}
