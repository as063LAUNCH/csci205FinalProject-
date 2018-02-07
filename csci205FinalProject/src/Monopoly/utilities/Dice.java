package Monopoly.utilities;

/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Nick Barpoulis, Emma Overly, Sienna Mosher and Anushikha Sharma
 * Date: Apr 7, 2016
 * Time: 8:35:56 PM
 *
 * Project: csci205FinalProject
 * Package: Monopoly.utilities
 * File: Dice
 * Description: a file containing the Dice class
 *
 * ****************************************
 */
/**
 *
 * @author njb011 and slm053
 */
public class Dice {

    /**
     * represents the rolled numbers by the day
     */
    private int[] rolled = new int[2];

    /**
     * represents the number of faces of each die
     */
    private static int faces = 6;

    /**
     * represents the randomness of the
     */
    //private Random die;
    /**
     * Constructor class for the Dice
     */
    public Dice() {

    }

    /**
     * method that rolls the dice, returns the value for each dice.
     *
     * @return an int of the rolled die
     */
    private int rollDie() {

        return (int) ((Math.random() * 6) + 1);
    }

    /**
     * method that actually rolls the dice
     *
     * @return an integers array
     */
    public int[] roll() {

        int[] rollDie = new int[2];
        rollDie[0] = rollDie();
        rollDie[1] = rollDie();
        this.rolled = rollDie;
        return rollDie;
    }

    /**
     * getter for rolled
     *
     * @return an integer array representing rolled dice
     */
    public int[] getRolled() {
        return rolled;
    }

}
