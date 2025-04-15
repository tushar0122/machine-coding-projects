package org.example.cricketScoreSystem.entities;

import java.util.ArrayList;
import java.util.List;

public class Team {
    String teamId;
    int numberOfPlayers;
    int numberOfOvers;
    List<org.example.cricketScoreSystem.entities.Player> playerListOrder = new ArrayList<org.example.cricketScoreSystem.entities.Player>();
    List<org.example.cricketScoreSystem.entities.Over> overList;
    int strikerIndex = 0;
    int nonStrikerIndex = 1;
    int nextStrikerIndex = 2;
    public int totalRuns;
    public int numberOfWickets;

    public Team(String teamId, int numberOfPlayers, int numberOfOvers, List<String> playerListOrder) {
        this.teamId = teamId;
        this.numberOfPlayers = numberOfPlayers;
        this.numberOfOvers = numberOfOvers;
        for(var i: playerListOrder){
            var k = new org.example.cricketScoreSystem.entities.Player(i);
            this.playerListOrder.add(k);
        }
    }

    public void addDelivery(String BallType){
        org.example.cricketScoreSystem.entities.Player striker = playerListOrder.get(strikerIndex);
        switch (BallType) {
            case "Wd":
            case "N":
                striker.numberOfBallsFaced++;
                break;
            case "W":
                striker.numberOfBallsFaced++;
                strikerIndex=nextStrikerIndex;
                nextStrikerIndex++;
                numberOfWickets++;
                break;
            default:
                var run = Integer.valueOf(BallType);
                striker.totalScore+=run;
                striker.numberOfBallsFaced++;
                totalRuns+=run;
                if (run == 3 || run == 1) {
                    swapStrike();
                } else if (run == 4) {
                    striker.numberOf4s++;
                } else if (run == 6) {
                    striker.numberOf6s++;
                }
        }
    }

    public void swapStrike(){
        var temp = nonStrikerIndex;
        nonStrikerIndex = strikerIndex;
        strikerIndex = temp;
    }

    public void printScoreBoard(){
        for(org.example.cricketScoreSystem.entities.Player i: playerListOrder){
            System.out.println(i.playerId+"     "+i.totalScore+"    "+i.numberOf4s+"    "+i.numberOf6s+"    "+i.numberOfBallsFaced);
        }
    }
}
