package com.theironyard.novauc.entities;

/**
 * Created by jerieshasmith on 4/11/17.
 */
public class Innings {

    private String number;
    private int outs;
    private int totalOuts;
    private boolean isEven;


    public Innings() {

    }

    public Innings(String number, int outs, int totalOuts) {
        this.number = number;
        this.outs = outs;
        this.totalOuts = totalOuts;
        this.isEven = isEven;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getOuts() {
        return outs;
    }

    public void setOuts(int outs) {
        this.outs = outs;
    }

    public int getTotalOuts() {
        return totalOuts;
    }

    public void setTotalOuts(int totalOuts) {
        this.totalOuts = totalOuts;
    }

    public boolean isEven() {
        return isEven;
    }

    public void setEven(boolean even) {
        isEven = even;
    }
}