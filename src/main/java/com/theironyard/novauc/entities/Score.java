package com.theironyard.novauc.entities;

/**
 * Created by jerieshasmith on 4/11/17.
 */
public class Score {
    private String away;
    private String home;


    public Score(){

    }

    public Score(String away, String home) {
        this.away = away;
        this.home = home;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }
}
