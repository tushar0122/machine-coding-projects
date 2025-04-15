package org.example.battleShipGame.entities;

import java.util.Objects;

public class Ship {
    private String id;
    private int xMin;
    private int yMin;
    private int xMax;
    private int yMax;
    private int size;

    public Ship(String id, int size, int x, int y){
        this.id = id;
        this.size = size;
        xMin = x - size/2;
        xMax = x + size/2;
        yMin = y - size/2;
        yMax = y + size/2;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Ship)) return false;
        Ship ship = (Ship) o;
        return ship.getId().equals(this.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    public String getId() {
        return id;
    }

    public int getxMin() {
        return xMin;
    }

    public int getyMin() {
        return yMin;
    }

    public int getxMax() {
        return xMax;
    }

    public int getyMax() {
        return yMax;
    }

    public int getSize() {
        return size;
    }
}