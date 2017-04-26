package com.theironyard.novauc.entities;

import javax.persistence.*;

/**
 * Created by jerieshasmith on 4/24/17.
 */

public class Result {
    private int hit;
    private int atBat;
    private String outcome;

    public Result() {
    }

    public Result(int hit, int out, String outcome) {
        this.hit = hit;
        this.atBat = out;
        this.outcome = outcome;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public int getAtBat() {
        return atBat;
    }

    public void setAtBat(int atBat) {
        this.atBat = atBat;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }
}
