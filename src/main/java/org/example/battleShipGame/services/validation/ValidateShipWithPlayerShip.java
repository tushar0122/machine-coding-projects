package org.example.battleShipGame.services.validation;

import org.example.battleShipGame.entities.Player;
import org.example.battleShipGame.entities.Ship;

public class ValidateShipWithPlayerShip {

    public static boolean checkIfNotOverlapWithExistingShip(Player player, Ship ship){
        var shipList = player.getShipList();
        int x1 = ship.getxMin();
        int x2 = ship.getxMax();
        int y1 = ship.getyMin();
        int y2 = ship.getyMax();
        if(player.getShipList().contains(ship)){
            System.out.println("Ship Id already exists: "+ship.getId()+" for Player: "+player.getId());
            return false;
        }
        for(var i: shipList){
            int xMin = i.getxMin();
            int xMax = i.getxMax();
            int yMin = i.getyMin();
            int yMax = i.getyMax();
            if(!checkIfNotOverlapWithShip(x1, x2, y1, y2, xMin, xMax, yMin, yMax)){
                System.out.println("Ship overlaps with existing ship: "+i.getId()+" for player "+player.getId()+" and Ship "+ship.getId());
                return false;
            }
        }
        return true;
    }

    public static boolean checkIfNotOverlapWithShip(int ax1, int ax2, int ay1, int ay2, int bx1, int bx2, int by1, int by2){
        if(ax1>=bx2||ax2<=bx1||ay1>=by2||ay2<=by1){
            return true;
        }
        return false;
    }

}
