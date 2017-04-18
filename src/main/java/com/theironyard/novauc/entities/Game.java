package com.theironyard.novauc.entities;

/**
 * Created by jerieshasmith on 4/12/17.
 */
public class Game extends Player {
    private Score score;
    private Innings innings;
    private Team away;
    private Team home;

    public Game() {
    }

    public Game(String name, int number, String position, int posNumber, Score score, Innings innings, Team away, Team home) {
        super(name, number, position, posNumber);
        this.score = score;
        this.innings = innings;
        this.away = away;
        this.home = home;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Innings getInnings() {
        return innings;
    }

    public void setInnings(Innings innings) {
        this.innings = innings;
    }

    public Team getAway() {
        return away;
    }

    public void setAway(Team away) {
        this.away = away;
    }

    public Team getHome() {
        return home;
    }

    public void setHome(Team home) {
        this.home = home;
    }

    public void setAway(String s, int playerNumber, String positionText, int positionNumber) {
    }

    public void setHome(String s, int playerNumber, String positionText, int positionNumber) {
    }
}



