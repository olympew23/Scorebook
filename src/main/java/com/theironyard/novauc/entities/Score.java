package com.theironyard.novauc.entities;

/**
 * Created by jerieshasmith on 4/11/17.
 */
public class Score {
    private int away;
    private int home;


    public Score() {

    }

    public Score(int away, int home) {
        this.away = away;
        this.home = home;


    }

    public int getAway() {
        return away;
    }

    public void setAway(int away) {
        this.away = away;
    }

    public int getHome() {
        return home;
    }

    public void setHome(int home) {
        this.home = home;
    }

}


