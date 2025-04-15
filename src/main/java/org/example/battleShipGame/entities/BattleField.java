package org.example.battleShipGame.entities;

import org.example.battleShipGame.constants.GameStatus;
import org.example.battleShipGame.services.GridUtils;
import org.example.battleShipGame.services.ShipUtils;
import org.example.services.PlayerUtils;

import java.util.HashSet;

public class BattleField {

    int N;
    String grid [][];
    Player player1;
    Player player2;
    Player strikingPlayer;
    Player opponentPlayer;
    GameStatus gameStatus;
    RandomGenerator randomGenerator;
    HashSet<Coordinate> targetedCoordinates;

    private static BattleField battleField;

    private BattleField(){
        this.gameStatus = GameStatus.TOSTART;
        this.randomGenerator = RandomGenerator.getInstance();
        this.targetedCoordinates = new HashSet<Coordinate>();
    }

    public static BattleField getInstance(){
        if(battleField==null){
            battleField = new BattleField();
        }
        return battleField;
    }

    public void initGame(int N){
        this.N = N;
        grid = new String[N][N];
        player1 = new Player("PlayerA", "A", 0, N/2, 0, N);
        player2 = new Player("PlayerB", "B", N/2, N, 0, N);
        GridUtils.initializeGrid(grid, N);
    }

    public void addShip(String id, int size, int x1, int y1, int x2, int y2){
        Ship ship1 = new Ship(id, size, x1, y1);
        Ship ship2 = new Ship(id, size, x2, y2);
        if(!ShipUtils.validateShip(player1, ship1, N)||!ShipUtils.validateShip(player2, ship2, N)){
            System.exit(0);
        }
        player1.addShip(ship1);
        player2.addShip(ship2);
        GridUtils.updateGrid(grid, player1.getShortId(), ship1);
        GridUtils.updateGrid(grid, player2.getShortId(), ship2);
    }

    public void startGame(){
        this.gameStatus = GameStatus.INPROGRESS;
        strikingPlayer = player1;
        opponentPlayer = player2;
        while(this.gameStatus!=GameStatus.WIN){
            this.makeTurn(strikingPlayer);
            if(!opponentPlayer.isShipPresent()){
                this.gameStatus = GameStatus.WIN;
            }
            else{
                swapTurn();
            }
        }
        System.out.println("GameOver. "+strikingPlayer.getId()+" wins.");
    }

    public void makeTurn(Player player){
        Coordinate coordinate = player.play(randomGenerator, opponentPlayer);
        if(targetedCoordinates.contains(coordinate)){
            System.out.println("Coordinates repeated: x:"+coordinate.getX()+" y:"+coordinate.getY());
            makeTurn(player);
        }
        else{
            targetedCoordinates.add(coordinate);
        }
        int x = coordinate.getX();
        int y = coordinate.getY();
        String result = PlayerUtils.fireMissile(opponentPlayer, x, y);
        StringBuilder msg = new StringBuilder(strikingPlayer.getId()+"'s turn: Missile fired at ("+x+","+y+") : ");
        msg.append(result);
        msg.append("Ships Remaining - "+player1.getId()+":"+player1.getShipList().size()+",  "+player2.getId()+":"+player2.getShipList().size());
        System.out.println(msg);
    }

    public void swapTurn(){
        Player temp = strikingPlayer;
        strikingPlayer = opponentPlayer;
        opponentPlayer = temp;
    }

    public void viewBattleField(){
        GridUtils.printGrid(grid, N);
    }
}
