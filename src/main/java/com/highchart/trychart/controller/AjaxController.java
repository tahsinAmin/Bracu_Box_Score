package com.highchart.trychart.controller;

import com.highchart.trychart.modal.BracubBoxScore;
import com.highchart.trychart.modal.PlayerScore;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {

    @RequestMapping("/ajax/box_score_result")
    public BracubBoxScore bracubBoxScore() {

        List<PlayerScore> playerScores = new ArrayList<PlayerScore>();
        BracubBoxScore score = new BracubBoxScore();
        score.setTitle("BRACU Basketball Players' Box Scores");

        var filename = "src/main/resources/numbers.csv";
        try (var fr = new FileReader(filename, StandardCharsets.UTF_8);
             var reader = new CSVReader(fr)) {
            String[] nextLine;
            //
            List<String> categories = new ArrayList<String>();
            if ((nextLine = reader.readNext()) != null) {
                for (String x : nextLine) {
                    categories.add(x);
                }
            }
            categories.remove(0);
            score.setCategories(categories);

            while ((nextLine = reader.readNext()) != null) {
                PlayerScore playerScore = new PlayerScore();
                playerScore.setName(nextLine[0]);
                List<Integer> playersData = new ArrayList<Integer>();

                for (int i = 1; i <= 5; i++) {
                    playersData.add(Integer.parseInt(nextLine[i]));
                }

                playerScore.setData(playersData);
                playerScores.add(playerScore);
            }
            score.setSeries(playerScores);

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return score;
    }
}
