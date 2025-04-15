package org.example.battleShipGame;


import org.example.battleShipGame.entities.BattleField;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
Assumptions:
1. All ships will be parallel to x-axis and y-axis
2. Assuming missiles only fired at integer values
3. Only one ship hit even if hit at border of two ship of opponent
4. If Opponent and Player Ship touch at border, will hit opponent ship only.
5. Size will be multiple of 2, else can't plot grid
 */

public class Main {
    public static void main(String[] args) {
        BattleField battleField = BattleField.getInstance();
        int N = 10;
        battleField.initGame(N);

       //battleField.addShip("SH1", 4, 3, 3, 7, 7);

        // Ship size should be even
        //battleField.addShip("SH2", 1, 3, 3, 4, 4);

        // Same id should be unique
        //battleField.addShip("SH1", 2, 2, 2, 4, 4);

        // Ship should be in player area
        //battleField.addShip("SH2", 2, 3, 8, 5, 0);

        // Ship should not overlap with existing ship
        //battleField.addShip("SH2", 2, 3, 5, 5, 0);

        battleField.addShip("SH1", 2, 1, 1, 6, 1);
        battleField.addShip("SH2", 2, 4, 1, 9, 1);
        battleField.addShip("SH3", 4, 3, 6, 7, 6);


        battleField.viewBattleField();
        battleField.startGame();
    }
}
