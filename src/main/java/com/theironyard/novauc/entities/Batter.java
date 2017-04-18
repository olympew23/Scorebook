package com.theironyard.novauc.entities;

/**
 * Created by jerieshasmith on 4/11/17.
 */
public class Batter extends Player {
    String results;


    public Batter(){

    }

    public Batter(String name,  int number, String position,  int posNumber, String results) {
        super(name,number, position,  posNumber);
        this.results = results;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }
}
