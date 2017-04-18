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
   static ArrayList<Player> playerList = new ArrayList<>();
   static Game games = new Game();



    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("scores",scores);
        model.addAttribute("innings", innings);
        model.addAttribute("counts", count);
        model.addAttribute("pitcher",pitcher);
        model.addAttribute("player",players);
        model.addAttribute("playerList", playerList);



        return "home";

    }


    @RequestMapping(path = "/home-player", method = RequestMethod.POST)
    public String player(Model model, HttpSession session, String playerText,Integer playerNumber, String positionText, Integer positionNumber,String playerText1,Integer playerNumber1, String positionText1, Integer positionNumber1,String playerText2,Integer playerNumber2, String positionText2, Integer positionNumber2,String playerText3 ,Integer playerNumber3, String positionText3, Integer positionNumber3,String playerText4,Integer playerNumber4, String positionText4, Integer positionNumber4,String playerText5,Integer playerNumber5, String positionText5, Integer positionNumber5,String playerText6,Integer playerNumber6, String positionText6, Integer positionNumber6,String playerText7,Integer playerNumber7, String positionText7,  Integer positionNumber7, String playerText8,Integer playerNumber8, String positionText8, Integer positionNumber8, String playerText9,Integer playerNumber9, String positionText9, Integer positionNumber9){
        Player player = new Player(playerText,playerNumber,positionText,positionNumber);
        Player player1 = new Player(playerText1,playerNumber1,positionText1,positionNumber1);
        Player player2 = new Player(playerText2,playerNumber2,positionText2,positionNumber2);
        Player player3 = new Player(playerText3,playerNumber3,positionText3,positionNumber3);
        Player player4 = new Player(playerText4,playerNumber4,positionText4,positionNumber4);
        Player player5 = new Player(playerText5,playerNumber5,positionText5,positionNumber5);
        Player player6 = new Player(playerText6,playerNumber6,positionText6,positionNumber6);
        Player player7 = new Player(playerText7,playerNumber7,positionText7,positionNumber7);
        Player player8 = new Player(playerText8,playerNumber8,positionText8,positionNumber8);

        players.add(player);
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        players.add(player6);
        players.add(player7);
        players.add(player8);
        return "redirect:/";

    }
    @RequestMapping(path = "/away-player", method = RequestMethod.POST)
    public String playerList(Model model, HttpSession session, String playerText,Integer playerNumber, String positionText, Integer positionNumber,String playerText1,Integer playerNumber1, String positionText1, Integer positionNumber1,String playerText2,Integer playerNumber2, String positionText2, Integer positionNumber2,String playerText3 ,Integer playerNumber3, String positionText3, Integer positionNumber3,String playerText4,Integer playerNumber4, String positionText4, Integer positionNumber4,String playerText5,Integer playerNumber5, String positionText5, Integer positionNumber5,String playerText6,Integer playerNumber6, String positionText6, Integer positionNumber6,String playerText7,Integer playerNumber7, String positionText7,  Integer positionNumber7, String playerText8,Integer playerNumber8, String positionText8, Integer positionNumber8, String playerText9,Integer playerNumber9, String positionText9, Integer positionNumber9) {
        Player playerList0 = new Player(playerText, playerNumber, positionText, positionNumber);
        Player playerList1 = new Player(playerText1, playerNumber1, positionText1, positionNumber1);
        Player playerList2 = new Player(playerText2, playerNumber2, positionText2, positionNumber2);
        Player playerList3 = new Player(playerText3, playerNumber3, positionText3, positionNumber3);
        Player playerList4 = new Player(playerText4, playerNumber4, positionText4, positionNumber4);
        Player playerList5 = new Player(playerText5, playerNumber5, positionText5, positionNumber5);
        Player playerList6 = new Player(playerText6, playerNumber6, positionText6, positionNumber6);
        Player playerList7 = new Player(playerText7, playerNumber7, positionText7, positionNumber7);
        Player playerList8 = new Player(playerText8, playerNumber8, positionText8, positionNumber8);

        playerList.add(playerList0);
        playerList.add(playerList1);
        playerList.add(playerList2);
        playerList.add(playerList3);
        playerList.add(playerList4);
        playerList.add(playerList5);
        playerList.add(playerList6);
        playerList.add(playerList7);
        playerList.add(playerList8);
        return "index";
    }


    @RequestMapping(path = "/add-score", method = RequestMethod.POST)
    public String addScore(Model model,   HttpSession session, int scoreText){
            scores.setAway(scores.getAway() + scoreText);
            scores.setHome(scores.getAway() + scoreText);
            return "redirect:/";

    }

    @RequestMapping(path = "/add-outs", method = RequestMethod.POST)
    public String addOuts(Model model, HttpSession session, Integer outsText, String numberText, Boolean isEven ){
        //innings.setNumber(innings.getNumber() + 1);
        innings.setOuts(innings.getOuts()+ outsText);
        innings.setTotalOuts(innings.getTotalOuts() + outsText);

        isEven = (innings.getTotalOuts() % 3 == 0);


        if(innings.getTotalOuts() >= 3 && innings.getTotalOuts() <= 5) {
            innings.setNumber("1B");
        }
        else if(innings.getTotalOuts() >= 6 && innings.getTotalOuts() <= 8) {
                innings.setNumber("2T");
        }
     else if(innings.getTotalOuts() >= 9 && innings.getTotalOuts() <= 11) {
                innings.setNumber("2B");
        } else if(innings.getTotalOuts() >= 12 && innings.getTotalOuts() <= 14) {
                       innings.setNumber("3T");
                   }
                    else if(innings.getTotalOuts() >= 15 && innings.getTotalOuts() <= 17){
                          innings.setNumber("3B");

        }  else if(innings.getTotalOuts() >= 18 && innings.getTotalOuts() <= 20){
                        innings.setNumber("4T");

        } else if(innings.getTotalOuts() >= 21 && innings.getTotalOuts() <= 23){
                innings.setNumber("4B");

        } else if(innings.getTotalOuts() >= 24 && innings.getTotalOuts() <= 26 ){
            innings.setNumber("5T");


        } else if(innings.getTotalOuts() >= 27 && innings.getTotalOuts() <= 29){
            innings.setNumber("5B");

        } else if(innings.getTotalOuts() >= 30 && innings.getTotalOuts() <= 32){
            innings.setNumber("6T");


        } else if(innings.getTotalOuts() >= 33 && innings.getTotalOuts() <= 35 ){
            innings.setNumber("6B");


        } else if(innings.getTotalOuts() >= 36 && innings.getTotalOuts() <= 38){
            innings.setNumber("7T");


        } else if(innings.getTotalOuts() >= 39 && innings.getTotalOuts() <= 41){
            innings.setNumber("7B");

        } else if(innings.getTotalOuts() >= 42 && innings.getTotalOuts() <= 44){
            innings.setNumber("8T");

        } else if(innings.getTotalOuts() >= 45 && innings.getTotalOuts() <= 47 ){
            innings.setNumber("8B");

        } else if(innings.getTotalOuts() >= 48 && innings.getTotalOuts() <= 50 ){
            innings.setNumber("9T");

        } else if(innings.getTotalOuts() >= 51 && innings.getTotalOuts() <= 53){
            innings.setNumber("9B");
        }


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

    @RequestMapping(path = "/add-scorekeeper", method = RequestMethod.POST)
    public String login(   Model model,HttpSession session, String scorekeeperName, String passWord) {
        model.addAttribute("scorekeeperName",scorekeeperName);
        ScoreKeeper scoreKeeper = new ScoreKeeper();
        scoreKeeper.setName(scoreKeeper.getName() + scorekeeperName);
        return "player";
    }
        }