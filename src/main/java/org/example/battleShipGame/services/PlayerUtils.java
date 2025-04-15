package org.example.services;

import org.example.battleShipGame.entities.Player;
import org.example.battleShipGame.entities.Ship;
import org.example.battleShipGame.services.ShipUtils;

public class PlayerUtils {

    public static String fireMissile(Player opponentPlayer, int x, int y){
        String result = "";
        var shipList = opponentPlayer.getShipList();
        boolean isHit = false;
        Ship shipHit = null;
        for(var i=shipList.iterator();i.hasNext();){
            var k = i.next();
            if(ShipUtils.checkIfHit(k, x, y)){
                i.remove();
                isHit = true;
                shipHit = k;
                break;
            }
        }
        if(isHit){
            result = "\"Hit\" "+shipHit.getId()+" destroyed :";
        }
        else {
            result = "\"Miss\" :";
        }
        return result;
    }
}
