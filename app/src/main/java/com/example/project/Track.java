package com.example.project;

import java.util.ArrayList;

public class Track
{
    private String TName;
    private ArrayList<Place> places;

    public Track(String TName, ArrayList<Place> places)
    {
        this.TName = TName;
        this.places = new ArrayList<>(1);
    }

    public String getTName()
    {
        return TName;
    }

    public void setTName(String TName) {
        this.TName = TName;
    }

    public ArrayList<Place> getPlaces() {
        return places;
    }


    public String HowToGo(Place a,Place b)
    {
        if (a.CalcDiss(a,b)<1500)
            return "walking";
        return "driving";
    }

}
