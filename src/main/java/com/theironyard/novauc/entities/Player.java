package com.theironyard.novauc.entities;

import javax.persistence.*;
import javax.validation.groups.ConvertGroup;

/**
 * Created by jerieshasmith on 4/11/17.
 */

public class Player {
    private String name;
    private String position;
    private int number;
    private int posNumber;


    public Player(){

    }

    public Player(String name, String position, int number, int posNumber) {
        this.name = name;
        this.position = position;
        this.number = number;
        this.posNumber = posNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPosNumber() {
        return posNumber;
    }

    public void setPosNumber(int posNumber) {
        this.posNumber = posNumber;
    }
}
