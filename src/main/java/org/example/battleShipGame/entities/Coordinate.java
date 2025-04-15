package org.example.battleShipGame.entities;

import java.util.Objects;

public class Coordinate {

    private int x;
    private int y;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Coordinate)) return false;
        Coordinate coordinate = (Coordinate) obj;
        return coordinate.getX()==x&&coordinate.getY()==y;
    }
}
