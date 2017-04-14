package com.theironyard.novauc.entities;

/**
 * Created by jerieshasmith on 4/11/17.
 */
public class Innings {

    private String number;
    private int outs;
    private int totalOuts;


    public Innings() {

    }

    public Innings(String number, int outs, int totalOuts) {
        this.number = number;
        this.outs = outs;
        this.totalOuts = totalOuts;
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
}