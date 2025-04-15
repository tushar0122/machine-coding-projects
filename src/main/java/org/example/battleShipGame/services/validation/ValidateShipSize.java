package org.example.battleShipGame.services.validation;


import org.example.battleShipGame.entities.Ship;

public class ValidateShipSize {

    public static boolean checkSize(Ship ship){
        if(ship.getSize()%2!=0){
            System.out.println("Ship size should be even for ship: "+ship.getId());
            return false;
        }
        return true;
    }
}
