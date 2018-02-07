package Monopoly.utilities;

import java.util.ArrayList;

/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Nick Barpoulis, Emma Overly, Sienna Mosher and Anushikha Sharma
 * Date: Apr 7, 2016
 * Time: 8:35:10 PM
 *
 * Project: csci205FinalProject
 * Package: Monopoly.utilities
 * File: Player
 * Description: a file containing the Player class
 *
 * ****************************************
 */
/**
 *
 * @author njb011 and slm053
 */
public class Player {
    /**
     * represents that static value of how many spaces are on the board
     */
    private static final int MAX_SPACE_NUM = 39;
    /**
     * represents the Account of the player
     */
    private Account bankAccount;
    /**
     * represents the player's number (how to find them in the array list of
     * players)
     */
    private int playerNumber;
    /**
     * represents an array of all the properties owned by the player
     */
    private ArrayList<Space> propertiesOwned;
    /**
     * represents whether or not the player is in jail
     */
    private boolean isInJail;
    /**
     * represents the number of rolls the player has had while in jail
     */
    private int rollsInJail;
    /**
     * represents the player's current location on the board
     */
    private int currLocation;
    /**
     * represents the player's name
     */
    private String playerName;
    /**
     * represents whether or not the player is bankrupt
     */
    private boolean isBankrupt;

    /**
     * Constructor for the Player class
     *
     * @param playerNumber
     * @param playerName
     */
    public Player(int playerNumber, String playerName) {
        this.bankAccount = new Account(playerName);  // somehow set it up so everyone starts with $1500
        this.propertiesOwned = new ArrayList<Space>();  //initialize empty list of spaces
        this.playerNumber = playerNumber;   //every player will be assigned a num 1-4
        this.isInJail = false;      //everyone starts out not in jail
        this.currLocation = 0; //everyone starts out on "Go" aka the ELC
        this.rollsInJail = 0;
        this.playerName = playerName;
        this.isBankrupt = false;
    }

    public void setIsBankrupt(boolean isBankrupt) {
        this.isBankrupt = isBankrupt;
    }

    public boolean isIsBankrupt() {
        return isBankrupt;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPropOwnedStats() {
        String output = "";
        for (int x = 0; x < this.propertiesOwned.size(); x++) {
            output = output + "\n" + this.propertiesOwned.get(x).getSpaceName();
        }
        return output;
    }

    public String jailStats() {
        String output = "";
        if (this.isInJail) {
            output = "In Jail";
        } else {
            output = "Not in Jail";
        }
        return output;
    }

    /**
     * method that puts all the player's important information into a string and
     * returns it
     *
     * @return string representation of the player's info
     */
    public String getStats() {

        String inAccount = String.format(
                "\n-------------------------\n %s has $%d in their bank account.\n ",
                this.playerName, this.getBankAccount().getBalance());
        String propertiesOwned = "Properties owned: \n";

        for (int i = 0; i <= this.propertiesOwned.size() - 1; i++) {
            propertiesOwned.concat(String.format("%s\n",
                                                 this.propertiesOwned.get(i).getSpaceName()));

        }
        return inAccount + propertiesOwned + ("-------------------------\n");

    }

    /**
     * method that adds to the count of jail rolls
     */
    public void incrementRollsInJail() {
        this.rollsInJail++;
    }

    /**
     * method that moves the player.
     *
     * @param numSpaces
     */
    public void move(int numSpaces) {
        if ((currLocation + numSpaces) > MAX_SPACE_NUM) {
            this.currLocation = (numSpaces - (MAX_SPACE_NUM - currLocation)) - 1;
            this.getBankAccount().deposit(200);
        } else {
            this.currLocation += numSpaces;
        }
    }

    public Account getBankAccount() {
        return bankAccount;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public ArrayList<Space> getPropertiesOwned() {
        return propertiesOwned;
    }

    public boolean isIsInJail() {
        return isInJail;
    }

    public int getRollsInJail() {
        return rollsInJail;
    }

    public int getCurrLocation() {
        return currLocation;
    }

    public void setCurrLocation(int currLocation) {
        this.currLocation = currLocation;
    }

    public void setIsInJail(boolean isInJail) {
        this.isInJail = isInJail;
    }

    public void setRollsInJail(int rollsInJail) {
        this.rollsInJail = rollsInJail;
    }

}
