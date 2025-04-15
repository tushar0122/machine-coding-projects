package org.example.battleShipGame.services.validation;


import org.example.battleShipGame.entities.Player;
import org.example.battleShipGame.entities.Ship;

public class ValidateShipWithPlayerArea {

    public static boolean checkIfInPlayerArea(Player player, Ship ship, int N){
        int xMin = ship.getxMin();
        int xMax = ship.getxMax();
        int yMin = ship.getyMin();
        int yMax = ship.getyMax();
        if(xMin>=player.getxMin()&&xMax<= player.getxMax()&&yMin>=player.getyMin()&&yMax<= player.getyMax()){
            return true;
        }
        System.out.println("Ship is not in player area: "+player.getId()+" and Ship "+ship.getId());
        return false;
    }

}
