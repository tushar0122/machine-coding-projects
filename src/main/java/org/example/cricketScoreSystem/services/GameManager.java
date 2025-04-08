package org.example.cricketScoreSystem.services;
import org.example.cricketScoreSystem.entities.Team;

import java.util.List;

public class GameManager {

    private Team team1;
    private Team team2;
    private static GameManager gameManager;

    public static GameManager getInstance(){
        if(gameManager==null){
            gameManager = new GameManager();
        }
        return gameManager;
    }

    public Team getTeam(String teamId){
        switch (teamId){
            case "team1":
                return team1;
            case "team2":
                return team2;
            default:
                throw new IllegalArgumentException("Invalid team id");
        }
    }

    public void setTeam(String teamId, int numberOfPlayers, int numberOfOvers, List<String> playerListOrder) {
        var team = new Team(teamId, numberOfPlayers, numberOfOvers, playerListOrder);
        switch (teamId){
            case "team1":
                this.team1 = team;
                break;
            case "team2":
                this.team2 = team;
                break;
            default:
                throw new IllegalArgumentException("Invalid team id");
        }
    }

}
