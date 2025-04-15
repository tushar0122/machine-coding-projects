package org.example.battleShipGame.services;


import org.example.battleShipGame.entities.Player;
import org.example.battleShipGame.entities.Ship;
import org.example.battleShipGame.services.validation.ValidateShipSize;
import org.example.battleShipGame.services.validation.ValidateShipWithPlayerArea;
import org.example.battleShipGame.services.validation.ValidateShipWithPlayerShip;

public class ShipUtils {

    public static boolean validateShip(Player player, Ship ship, int N){
        boolean isValid = true;
        isValid = (isValid&&ValidateShipSize.checkSize(ship));
        isValid = (isValid&&ValidateShipWithPlayerArea.checkIfInPlayerArea(player, ship, N));
        isValid = (isValid&&ValidateShipWithPlayerShip.checkIfNotOverlapWithExistingShip(player, ship));
        if(isValid){
            return true;
        }
        return false;
    }

    public static boolean checkIfHit(Ship ship, int x, int y){
        int xMin = ship.getxMin();
        int xMax = ship.getxMax();
        int yMin = ship.getyMin();
        int yMax = ship.getyMax();
        if(x>=xMin&&x<=xMax&&y>=yMin&&y<=yMax){
            return true;
        }
        else{
            return false;
        }
    }
}
