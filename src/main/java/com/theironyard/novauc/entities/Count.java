package com.theironyard.novauc.entities;

/**
 * Created by jerieshasmith on 4/11/17.
 */
public class Count {
    private int balls;
    private int strike;

    public Count() {

    }

    public Count(int balls, int strike) {
        this.balls = balls;
        this.strike = strike;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }
}




