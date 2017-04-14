package com.theironyard.novauc.entities;

/**
 * Created by jerieshasmith on 4/12/17.
 */
public class Game {
  private  Score score;
   private Innings innings;
    private Team away;
   private Team home;


    public Game() {
    }

    public Game(Score score, Innings innings, Team away, Team home) {
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
}
