package com.theironyard.novauc.entities;

/**
 * Created by jerieshasmith on 4/11/17.
 */
public class Batter extends Player {
    String results;
    Count batterCount;


    public Batter(){

    }
    public Batter(String name) {
        super(name);
        this.batterCount = new Count(0,0);
    }


    public Batter(String name, int number, String position, int posNumber) {
        super(name, number, position, posNumber);
        this.batterCount = new Count(0,0);
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public Count getBatterCount() {
        return batterCount;
    }

    public void setBatterCount(Count batterCount) {
        this.batterCount = batterCount;
    }
}
