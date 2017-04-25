package com.theironyard.novauc.entities;

import javax.persistence.*;

/**
 * Created by jerieshasmith on 4/11/17.
 */
@Entity
@Table(name= "counts")
public class Count {
    @Id
    @GeneratedValue
    int id;

    @Column
    private int balls;

    @Column
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








