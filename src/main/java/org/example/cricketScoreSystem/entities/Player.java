package org.example.cricketScoreSystem.entities;

public class Player {

    String playerId;
    int numberOf4s;
    int numberOf6s;
    int totalScore;
    int totalWickets;
    int numberOfBallsFaced;

    Player(String playerId){
        this.playerId = playerId;
    }
}
