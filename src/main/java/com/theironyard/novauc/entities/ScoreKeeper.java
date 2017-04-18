package com.theironyard.novauc.entities;

/**
 * Created by jerieshasmith on 4/16/17.
 */
public class ScoreKeeper {
    private String name;
    private String password;

    public ScoreKeeper(){

    }

    public ScoreKeeper(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
