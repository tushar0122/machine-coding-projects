package org.example.battleShipGame.services;


import org.example.battleShipGame.entities.Ship;

public class GridUtils {

    public static void initializeGrid(String [][] grid, int N){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                grid[i][j]="|     |";
            }
        }
    }

    public static void updateGrid(String [][] grid, String playerId, Ship ship){
        int xMin = ship.getxMin();
        int xMax = ship.getxMax();
        int yMin = ship.getyMin();
        int yMax = ship.getyMax();
        for(int i=xMin;i<xMax;i++){
            for(int j=yMin;j<yMax;j++){
                grid[j][i]="|"+playerId+"-"+ship.getId()+"|";
            }
        }
    }

    public static void printGrid(String [][] grid, int N){
        System.out.println();
        for(int i=N-1;i>=0;i--){
            for(int j=0;j<N;j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
