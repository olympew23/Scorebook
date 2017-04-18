package com.theironyard.novauc.entities;

/**
 * Created by jerieshasmith on 4/11/17.
 */
public class Pitcher extends Player {
  private  int pitchCount;


public Pitcher(){

}

    public Pitcher(String name, int number,  String position,  int posNumber, int pitchCount) {
        super(name, number,position,  posNumber);
        this.pitchCount = pitchCount;
    }

    public int getPitchCount() {
        return pitchCount;
    }

    public void setPitchCount(int pitchCount) {
        this.pitchCount = pitchCount;
    }
}
