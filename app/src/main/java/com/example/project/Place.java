package com.example.project;

public class Place
{
    private String PCountry;
    private String PType;

    public Place(String PCountry, String PType) {
        this.PCountry = PCountry;
        this.PType = PType;
    }

    public String getPCountry() {
        return PCountry;
    }

    public void setPCountry(String PCountry) {
        this.PCountry = PCountry;
    }

    public String getPType() {
        return PType;
    }

    public void setPType(String PType) {
        this.PType = PType;
    }
}
