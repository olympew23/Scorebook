package com.theironyard.novauc.controllers;
import com.theironyard.novauc.entities.*;
import com.theironyard.novauc.entities.Batter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.Array;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by jerieshasmith on 4/11/17.
 */
@Controller
public class GameController {
    static Score scores = new Score(0, 0);
    static Innings innings = new Innings(1, "T", 0, 0);
    static Count count = new Count(0, 0);
    static Pitcher currentPitcher = new Pitcher("Kevin");
    static ArrayList<Batter> players = new ArrayList<>();
    static ArrayList<Batter> playerList = new ArrayList<>();
    static Game games = new Game();
    static ScoreKeeper scoreKeeper = new ScoreKeeper();
    static User users = new User();
    public static int homeBattingOrder = 0;
    public static int awayBattingOrder = 1;
    public static int awayPitcherCounter = 0;
    public static int homePitcherCounter = 0;
    static Batter currentBatter = new Batter("Olympew");
    static ArrayList<Pitcher> homePitcherList = new ArrayList<>();
    static ArrayList<Pitcher> awayPitcherList = new ArrayList<>();


    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("scores", scores);
        model.addAttribute("innings", innings);
        model.addAttribute("counts", currentBatter.getBatterCount());
        model.addAttribute("pitcher", currentPitcher);
        model.addAttribute("player", players);
        model.addAttribute("playerList", playerList);
        model.addAttribute("scoreKeeper", scoreKeeper);
        model.addAttribute("userName", users);
        model.addAttribute("currentBatter", currentBatter);
//        model.addAttribute("pitcher", homePitcherList);
//        model.addAttribute("pitcher",awayPitcherList);
        return "home";

    }


    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String lo(Model model, HttpSession session) {
        if (scoreKeeper != null)
            model.addAttribute("scoreKeeper", scoreKeeper);
        model.addAttribute("player", players);
        model.addAttribute("playerList", playerList);
        return "index";


    }


//    @RequestMapping(path = "/batter", method = RequestMethod.GET)
//    public String addBatter(Model model, HttpSession session){
//        model.addAttribute("batter", batters);
//        return "love";
//    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String login(Model model, HttpSession session) {
        model.addAttribute("scoreKeeper", scoreKeeper);
        return "player";


    }

    @RequestMapping(path = "/info", method = RequestMethod.GET)
    public String info(Model model) {
        model.addAttribute("scores", scores);
        model.addAttribute("innings", innings);
        model.addAttribute("counts", currentBatter.getBatterCount());
        model.addAttribute("pitcher", currentPitcher);
        model.addAttribute("player", players);
        model.addAttribute("playerList", playerList);
        model.addAttribute("scoreKeeper", scoreKeeper);
        model.addAttribute("userName", users);
        model.addAttribute("currentBatter", currentBatter);
//        model.addAttribute("pitcher",homePitcherList);
//        model.addAttribute("pitcher",awayPitcherList);
        return "info";


    }

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public String user(Model model, HttpSession session) {
        model.addAttribute("user", users);
        return "stats.html";
    }


    @RequestMapping(path = "/home-player", method = RequestMethod.POST)
    public String player(Model model, HttpSession session, String playerText, Integer playerNumber, String positionText, Integer positionNumber,
                         String playerText1, Integer playerNumber1, String positionText1, Integer positionNumber1,
                         String playerText2, Integer playerNumber2, String positionText2, Integer positionNumber2,
                         String playerText3, Integer playerNumber3, String positionText3, Integer positionNumber3,
                         String playerText4, Integer playerNumber4, String positionText4, Integer positionNumber4,
                         String playerText5, Integer playerNumber5, String positionText5, Integer positionNumber5,
                         String playerText6, Integer playerNumber6, String positionText6, Integer positionNumber6,
                         String playerText7, Integer playerNumber7, String positionText7, Integer positionNumber7,
                         String playerText8, Integer playerNumber8, String positionText8, Integer positionNumber8,
                         String playerText9, Integer playerNumber9, String positionText9, Integer positionNumber9,
                         String playerText10, Integer playerNumber10, String positionText10, Integer positionNumber10,
                         String playerText11, Integer playerNumber11, String positionText11, Integer positionNumber11,
                         String playerText12, Integer playerNumber12, String positionText12, Integer positionNumber12,
                         String playerText13, Integer playerNumber13, String positionText13, Integer positionNumber13,
                         String playerText14, Integer playerNumber14, String positionText14, Integer positionNumber14,
                         String playerText15, Integer playerNumber15, String positionText15, Integer positionNumber15,
                         String playerText16, Integer playerNumber16, String positionText16, Integer positionNumber16,
                         String playerText17, Integer playerNumber17, String positionText17, Integer positionNumber17,
                         String playerText18, Integer playerNumber18, String positionText18, Integer positionNumber18,
                         String playerText19, Integer playerNumber19, String positionText19, Integer positionNumber19) {


        Batter player = new Batter(playerText, playerNumber, positionText, positionNumber);
        Batter player1 = new Batter(playerText1, playerNumber1, positionText1, positionNumber1);
        Batter player2 = new Batter(playerText2, playerNumber2, positionText2, positionNumber2);
        Batter player3 = new Batter(playerText3, playerNumber3, positionText3, positionNumber3);
        Batter player4 = new Batter(playerText4, playerNumber4, positionText4, positionNumber4);
        Batter player5 = new Batter(playerText5, playerNumber5, positionText5, positionNumber5);
        Batter player6 = new Batter(playerText6, playerNumber6, positionText6, positionNumber6);
        Batter player7 = new Batter(playerText7, playerNumber7, positionText7, positionNumber7);
        Batter player8 = new Batter(playerText8, playerNumber8, positionText8, positionNumber8);
        Batter playerList0 = new Batter(playerText9, playerNumber9, positionText9, positionNumber9);
        Batter playerList1 = new Batter(playerText10, playerNumber10, positionText10, positionNumber10);
        Batter playerList2 = new Batter(playerText11, playerNumber11, positionText11, positionNumber11);
        Batter playerList3 = new Batter(playerText12, playerNumber12, positionText12, positionNumber12);
        Batter playerList4 = new Batter(playerText13, playerNumber13, positionText13, positionNumber13);
        Batter playerList5 = new Batter(playerText14, playerNumber14, positionText14, positionNumber14);
        Batter playerList6 = new Batter(playerText15, playerNumber15, positionText15, positionNumber15);
        Batter playerList7 = new Batter(playerText16, playerNumber16, positionText16, positionNumber16);
        Batter playerList8 = new Batter(playerText17, playerNumber17, positionText17, positionNumber17);

        playerList.add(playerList0);
        playerList.add(playerList1);
        playerList.add(playerList2);
        playerList.add(playerList3);
        playerList.add(playerList4);
        playerList.add(playerList5);
        playerList.add(playerList6);
        playerList.add(playerList7);
        playerList.add(playerList8);


        players.add(player);
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        players.add(player6);
        players.add(player7);
        players.add(player8);
        Pitcher awayPitcher = new Pitcher(playerText18, playerNumber18, positionText18, positionNumber18);
        Pitcher homePitcher = new Pitcher(playerText19, playerNumber19, positionText19, positionNumber19);
        awayPitcherList.add(awayPitcher);
        homePitcherList.add(homePitcher);
        currentBatter = players.get(0);
        currentPitcher = homePitcherList.get(0);
        return "redirect:/info";

    }


    @RequestMapping(path = "/add-score", method = RequestMethod.POST)
    public String addScore(Model model, HttpSession session, int scoreText, int scoresText) {
        scores.setAway(scores.getAway() + scoreText);
        scores.setHome(scores.getHome() + scoresText);
        return "redirect:/info";

    }
//
//    @RequestMapping(path = "/add-outs", method = RequestMethod.POST)
//    public String addOuts(Model model, HttpSession session, Integer outsText, String numberText, Boolean isEven ) {
//        //innings.setNumber(innings.getNumber() + 1);
//
//
//
//
//
//        return "redirect:/info";
//    }


    @RequestMapping(path = "/game-count", method = RequestMethod.POST)
    public String gameCount(Model model, HttpSession session, String countText, String countsText) {
        currentPitcher.setPitchCount(currentPitcher.getPitchCount() + 1);
        //count.setBalls(count.getBalls() + 2 );
        // count.setStrike(count.getStrike() + 1 );

        if (countText.equals("balls")) {
            if (currentBatter.getBatterCount().getBalls() < 3) {
                currentBatter.getBatterCount().setBalls(currentBatter.getBatterCount().getBalls() + 1);
            }
        } else {
            if (countText.equals("strikes")) {
                if (currentBatter.getBatterCount().getStrike() < 2) {
                    currentBatter.getBatterCount().setStrike(count.getStrike() + 1);
                }
            }
        }
        return "redirect:/info";

    }

    @RequestMapping(path = "/add-scorekeeper", method = RequestMethod.POST)
    public String login(Model model, HttpSession session, String scoreKeeper, String passWord) {
        model.addAttribute("scoreKeeper", scoreKeeper);
        return "redirect:/index";
    }

    @RequestMapping(path = "/add-user", method = RequestMethod.POST)
    public String addUser(Model model, HttpSession session, String userName, String passWord)  {
        model.addAttribute("userName", userName);
        return "redirect:/user";
    }

//    @RequestMapping(path = "/save", method = RequestMethod.POST)
//    public String save(Model model, HttpSession session) throws IOException {
//        PrintWriter outputFile = new PrintWriter("/Users/jerieshasmith/Downloads/ScoreBook/public/stats.html");
//
//
//        URL url = new URL("http://localhost:8080/home");
//
//
//        URLConnection con = url.openConnection();
//        InputStream is = con.getInputStream();
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(is));
//
//        String line = null;
//
//
//        while ((line = br.readLine()) != null) {
////             System.out.println(line);
//            outputFile.println(line);
//        }
//        br.close();
//        outputFile.close();
//        return "redirect:/info";
//    }

    @RequestMapping(path = "/batter", method = RequestMethod.POST)
    public String nextBatter(String result, String updatedCanvas) throws IOException {
        Result updateResult = new Result();
        if (result.equalsIgnoreCase("single")) {
            updateResult.setHit(currentBatter.getResult().getHit() + 1);
            updateResult.setAtBat(currentBatter.getResult().getAtBat() + 1);
            updateResult.setOutcome(currentBatter.getResult().getOutcome() + " single");
            currentBatter.setResult(updateResult);
        } else if (result.equalsIgnoreCase("double")) {
            updateResult.setHit(currentBatter.getResult().getHit() + 1);
            updateResult.setAtBat(currentBatter.getResult().getAtBat() + 1);
            updateResult.setOutcome(currentBatter.getResult().getOutcome() + " double");
            currentBatter.setResult(updateResult);

        } else if (result.equalsIgnoreCase("triple")) {
            updateResult.setHit(currentBatter.getResult().getHit() + 1);
            updateResult.setAtBat(currentBatter.getResult().getAtBat() + 1);
            updateResult.setOutcome(currentBatter.getResult().getOutcome() + " triple");
            currentBatter.setResult(updateResult);

        } else if (result.equalsIgnoreCase("home run")) {
            updateResult.setHit(currentBatter.getResult().getHit() + 1);
            updateResult.setAtBat(currentBatter.getResult().getAtBat() + 1);
            updateResult.setOutcome(currentBatter.getResult().getOutcome() + " Home Run");
            currentBatter.setResult(updateResult);
        } else if (result.equalsIgnoreCase("out")) {
            updateResult.setAtBat(currentBatter.getResult().getAtBat() + 1);
            currentBatter.setResult(updateResult);
            innings.setTotalOuts(innings.getTotalOuts() + 1);
        } else if (result.equalsIgnoreCase("dp")) {
            updateResult.setAtBat(currentBatter.getResult().getAtBat() + 1);
            currentBatter.setResult(updateResult);
            innings.setTotalOuts(innings.getTotalOuts() + 2);
        } else if (result.equalsIgnoreCase("tp")) {
            updateResult.setAtBat(currentBatter.getResult().getAtBat() + 1);
            currentBatter.setResult(updateResult);
            innings.setTotalOuts(innings.getTotalOuts() + 3);
        }


        innings.setOuts(innings.getTotalOuts() % 3);

        if (innings.getTotalOuts() >= 3 && innings.getTotalOuts() <= 5) {
            innings.setNumber(1);
            innings.setTop("B");
        } else if (innings.getTotalOuts() >= 6 && innings.getTotalOuts() <= 8) {
            innings.setNumber(2);
            innings.setTop("T");
        } else if (innings.getTotalOuts() >= 9 && innings.getTotalOuts() <= 11) {
            innings.setNumber(2);
            innings.setTop("B");
        } else if (innings.getTotalOuts() >= 12 && innings.getTotalOuts() <= 14) {
            innings.setNumber(3);
            innings.setTop("T");
        } else if (innings.getTotalOuts() >= 15 && innings.getTotalOuts() <= 17) {
            innings.setNumber(3);
            innings.setTop("B");
        } else if (innings.getTotalOuts() >= 18 && innings.getTotalOuts() <= 20) {
            innings.setNumber(4);
            innings.setTop("T");
        } else if (innings.getTotalOuts() >= 21 && innings.getTotalOuts() <= 23) {
            innings.setNumber(4);
            innings.setTop("B");
        } else if (innings.getTotalOuts() >= 24 && innings.getTotalOuts() <= 26) {
            innings.setNumber(5);
            innings.setTop("T");
        } else if (innings.getTotalOuts() >= 27 && innings.getTotalOuts() <= 29) {
            innings.setNumber(5);
            innings.setTop("B");
        } else if (innings.getTotalOuts() >= 30 && innings.getTotalOuts() <= 32) {
            innings.setNumber(6);
            innings.setTop("T");
        } else if (innings.getTotalOuts() >= 33 && innings.getTotalOuts() <= 35) {
            innings.setNumber(6);
            innings.setTop("B");
        } else if (innings.getTotalOuts() >= 36 && innings.getTotalOuts() <= 38) {
            innings.setNumber(7);
            innings.setTop("T");
        } else if (innings.getTotalOuts() >= 39 && innings.getTotalOuts() <= 41) {
            innings.setNumber(7);
            innings.setTop("B");
        } else if (innings.getTotalOuts() >= 42 && innings.getTotalOuts() <= 44) {
            innings.setNumber(8);
            innings.setTop("T");
        } else if (innings.getTotalOuts() >= 45 && innings.getTotalOuts() <= 47) {
            innings.setNumber(8);
            innings.setTop("B");
        } else if (innings.getTotalOuts() >= 48 && innings.getTotalOuts() <= 50) {
            innings.setNumber(9);
            innings.setTop("T");
        } else if (innings.getTotalOuts() >= 51 && innings.getTotalOuts() <= 53) {
            innings.setNumber(9);
            innings.setTop("B");
        }

        if (innings.getTop().equals("T")) {
            currentPitcher = homePitcherList.get(homePitcherCounter);
            currentBatter = players.get(awayBattingOrder);
            if (awayBattingOrder == 8) {
                awayBattingOrder = 0;
            } else {
                awayBattingOrder++;
            }
        } else {
            currentPitcher = awayPitcherList.get(awayPitcherCounter);
            currentBatter = playerList.get(homeBattingOrder);
            if (homeBattingOrder == 8) {
                homeBattingOrder = 0;
            } else {
                homeBattingOrder++;
            }
        }
        currentBatter.getBatterCount().setBalls(0);
        currentBatter.getBatterCount().setStrike(0);
//save image/path
        String base64Image = updatedCanvas.split(",")[1];
        byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);

        //byte[] valueDecoded= Base64.getDecoder().decode(updatedCanvas);

        ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);

        BufferedImage image = ImageIO.read(bis);
        bis.close();

        File outputfile = new File("public/canvas.png");

        ImageIO.write(image, "png", outputfile);

        PrintWriter outputFile = new PrintWriter("/Users/jerieshasmith/Downloads/ScoreBook/public/stats.html");


        URL url = new URL("http://localhost:8080/home");


        URLConnection con = url.openConnection();
        InputStream is = con.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line = null;


        while ((line = br.readLine()) != null) {
             System.out.println(line);
            outputFile.println(line);
            //inside here
        }
        br.close();
        outputFile.close();

        return "redirect:/info";
    }

    @RequestMapping(path = "/pitcher", method = RequestMethod.POST)
    public String changePitcher(String pitcherName, String pitcherSide) {
        Pitcher changePitcher = new Pitcher(pitcherName);

        if (pitcherSide.equalsIgnoreCase("away")) {
            awayPitcherList.add(changePitcher);
            awayPitcherCounter++;
        } else {
            homePitcherList.add(changePitcher);
            homePitcherCounter++;
        }
        return "redirect:/info";
    }





}