package org.example.cricketScoreSystem;

import org.example.cricketScoreSystem.entities.Team;
import org.example.cricketScoreSystem.services.GameManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String args[]){
        GameManager gameManager = GameManager.getInstance();
        Scanner scanner = new Scanner(System.in);
        System.out.print("No. of players for each team: ");
        int numberOfPlayers = scanner.nextInt();
        System.out.print("No. of overs: ");
        int numberOfOvers = scanner.nextInt();
        List<String> playerList = new ArrayList<>();
        System.out.println("Batting Order for team 1: ");
        scanner.nextLine();
        for(int i=0;i<numberOfPlayers;i++){
            System.out.println("Player "+i+" :");
            String k = scanner.nextLine();
            playerList.add(k);
        }
        gameManager.setTeam("team1", numberOfPlayers, numberOfOvers, playerList);
        Team team1 = gameManager.getTeam("team1");
        int o = 1;
        while(o<=numberOfOvers){
            System.out.println("Over "+o+": ");
            int n = 6;
            while(n>0){
                String ballType = scanner.nextLine();
                team1.addDelivery(ballType);
                n--;
            }
            team1.swapStrike();
            System.out.println("Scorecard for Team 1: ");
            System.out.println("Player Name     Score   4s  6s  Balls");
            team1.printScoreBoard();
            System.out.println("Total: "+team1.totalRuns+"/"+team1.numberOfWickets);
            System.out.println("Overs: "+o);
            o++;
        }
        List<String> playerList2 = new ArrayList<>();
        System.out.println("Batting Order for team 2:");
        for(int i=0;i<numberOfPlayers;i++){
            playerList2.add(scanner.nextLine());
        }
        gameManager.setTeam("team2", numberOfPlayers, numberOfOvers, playerList2);
        Team team2 = gameManager.getTeam("team2");
        o = 1;
        while(o<=numberOfOvers){
            System.out.println("Over "+o+": ");
            int n = 6;
            while(n>0){
                String ballType = scanner.nextLine();
                team2.addDelivery(ballType);
                n--;
            }
            team2.swapStrike();
            System.out.println("Scorecard for Team 2: ");
            System.out.println("Player Name     Score   4s  6s  Balls");
            team2.printScoreBoard();
            System.out.println("Total: "+team2.totalRuns+"/"+team2.numberOfWickets);
            System.out.println("Overs: "+o);
            o++;
        }
    }
}
