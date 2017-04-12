package com.theironyard.novauc.entities;

/**
 * Created by jerieshasmith on 4/11/17.
 */
public class Innings {
    static int i  = 0;
    private int number;
    private int outs;


    public Innings(){

    }

    public Innings(int number, int outs) {
        this.number = number;
        this.outs = outs;
    }

    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        Innings.i = i;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getOuts() {
        return outs;
    }

    public void setOuts(int outs) {
        this.outs = outs;
    }
}
