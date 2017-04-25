package com.theironyard.novauc.entities;

import javax.persistence.*;

/**
 * Created by jerieshasmith on 4/11/17.
 */
@Entity
@Table(name= "batters")
public class Batter extends Player {
    @Id
    @GeneratedValue
    int id;

    @ManyToOne
    @JoinColumn
    Count batterCount;

    @ManyToOne
    @JoinColumn
    Result result;


    public Batter(){
    }

    public Batter(String name) {
        super(name);
        this.batterCount = new Count(0,0);
    }

    public Batter(String name, int number, String position, int posNumber) {
        super(name, number, position, posNumber);
        this.batterCount = new Count(0,0);
        this.result = new Result(0,0,"");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Count getBatterCount() {
        return batterCount;
    }

    public void setBatterCount(Count batterCount) {
        this.batterCount = batterCount;
    }
}