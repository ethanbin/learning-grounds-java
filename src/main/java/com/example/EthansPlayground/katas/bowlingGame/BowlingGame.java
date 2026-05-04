package com.example.EthansPlayground.katas.bowlingGame;

public abstract class BowlingGame {

    /**
     * void roll(int) is called each time the player rolls a ball. The argument is the number of pins knocked down
     * @param pinsKnockedDown
     */
    public abstract void roll(int pinsKnockedDown);

    /**
     * int score() returns the total score for that game
     * @return score
     */
    public abstract int score();
}
