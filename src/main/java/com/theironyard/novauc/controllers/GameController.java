package com.theironyard.novauc.controllers;
import com.theironyard.novauc.entities.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by jerieshasmith on 4/11/17.
 */
@Controller
public class GameController {
   static Score scores = new Score(0,0);
   static Innings innings = new Innings("1T", 0, 0);
   static Count count = new Count(0,0);
   static Pitcher pitcher = new Pitcher();
   static ArrayList<Player> players = new ArrayList<>();



    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("scores",scores);
        model.addAttribute("innings", innings);
        model.addAttribute("counts", count);
        model.addAttribute("pitcher",pitcher);
        return "home";

    }


    @RequestMapping(path = "/player", method = RequestMethod.GET)
    public String player(Model model, String name, String position, int number, int posNumber){
        Player players = new Player(name,position,number,posNumber);
        model.addAttribute("player",players);
        return "player";

    }

    @RequestMapping(path = "/add-score", method = RequestMethod.POST)
    public String addScore(Model model,   HttpSession session, int scoreText){
            scores.setAway(scores.getAway() + scoreText);
            scores.setHome(scores.getAway() + scoreText);
            return "redirect:/";

    }

    @RequestMapping(path = "/add-outs", method = RequestMethod.POST)
    public String addOuts(Model model, HttpSession session, int outsText){
        innings.setOuts(innings.getOuts() + outsText);
        innings.setTotalOuts(innings.getTotalOuts() + outsText);

        return "redirect:/";
    }

    @RequestMapping(path = "/game-count", method = RequestMethod.POST)
    public String gameCount(Model model, HttpSession session, String countText){
        pitcher.setPitchCount(pitcher.getPitchCount()+ 1);

        if(countText.equals("balls")) {
            if (count.getBalls() < 3) {
                count.setBalls(count.getBalls() + 1);
            }
        } else {
            if(countText.equals("strikes")){
                if(count.getStrike() < 2){
                    count.setStrike(count.getStrike() + 1);
                }
            }
        }
        return "redirect:/";

    }


        }