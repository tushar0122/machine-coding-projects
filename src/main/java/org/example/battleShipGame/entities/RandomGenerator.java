package org.example.battleShipGame.entities;

import java.util.Random;

public class RandomGenerator {
    private final Random random;
    public static RandomGenerator randomGenerator;
    private RandomGenerator(){
        random = new Random();
    }

    public static RandomGenerator getInstance(){
        if(randomGenerator==null){
            randomGenerator = new RandomGenerator();
        }
        return randomGenerator;
    }

    public int getRandom(int x, int y){
        return  random.nextInt(x, y);
    }
}
