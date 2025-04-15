package org.example.battleShipGame.entities;

import java.util.HashSet;

public class Player {
    private String id;
    private String shortId;
    private int xMin;
    private int xMax;
    private int yMin;
    private int yMax;
    private HashSet<Ship> shipList;

    public Player(String id, String shortId, int xMin, int xMax, int yMin, int yMax){
        this.id = id;
        this.shortId=shortId;
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
        shipList = new HashSet<>();
    }

    public void addShip(Ship ship){
        this.shipList.add(ship);
    }

    public Coordinate play(RandomGenerator randomGenerator, Player opponentPlayer){
        int x =  randomGenerator.getRandom(opponentPlayer.getxMin(), opponentPlayer.getxMax()+1);
        int y = randomGenerator.getRandom(opponentPlayer.getyMin(), opponentPlayer.getyMax()+1);
        return new Coordinate(x, y);
    }

    public boolean isShipPresent(){
        return !this.shipList.isEmpty();
    }

    public String getId() {
        return id;
    }

    public String getShortId() {
        return shortId;
    }

    public int getxMin() {
        return xMin;
    }

    public int getxMax() {
        return xMax;
    }

    public int getyMax() {
        return yMax;
    }

    public int getyMin() {
        return yMin;
    }

    public HashSet<Ship> getShipList() {
        return shipList;
    }
}
