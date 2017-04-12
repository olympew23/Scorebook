package com.theironyard.novauc.entities;

/**
 * Created by jerieshasmith on 4/11/17.
 */
public class Pitcher extends Player {
  private  int pitchCount;


public Pitcher(){

}

    public Pitcher(String name, String position, int number, int posNumber, int pitchCount) {
        super(name, position, number, posNumber);
        this.pitchCount = pitchCount;
    }

    public int getPitchCount() {
        return pitchCount;
    }

    public void setPitchCount(int pitchCount) {
        this.pitchCount = pitchCount;
    }
}
