package com.highchart.trychart.controller;

import com.highchart.trychart.modal.BracubBoxScore;
import com.highchart.trychart.modal.PlayerScore;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class AjaxController {

    @RequestMapping("/ajax/box_score_result")
    public BracubBoxScore bracubBoxScore(){
        List<String> players = new ArrayList<String>();
        players.add("Ahnaf Ahmed");
        players.add("Masnun Alvi");
        players.add("Sakib Anjum");
        players.add("Zubair Islam");

        List<PlayerScore> playerScores = new ArrayList<PlayerScore>();

        for (String player : players){
            PlayerScore playerScore = new PlayerScore();
            playerScore.setName(player);
            playerScore.setData(buildPlayersData());

            playerScores.add(playerScore);
        }

        BracubBoxScore score = new BracubBoxScore();

        score.setTitle("BRACU Basketball Players' Box Scores");
        score.setCategories(buildPointsCategories());
        score.setSeries(playerScores);

        return score;
    }

    private List<String> buildPointsCategories() {
        List<String> categories = new ArrayList<String>();

        categories.add("PTS");
        categories.add("AST");
        categories.add("TOV");
        categories.add("STL");
        categories.add("FG%");

        return categories;
    }

    private List<Integer> buildPlayersData() {
        Random rnd = new Random();

        List<Integer> playersData = new ArrayList<Integer>();

        for (int i = 0; i< 5; i++){
            playersData.add(rnd.nextInt(100) + 1);
        }

        return playersData;
    }
}
