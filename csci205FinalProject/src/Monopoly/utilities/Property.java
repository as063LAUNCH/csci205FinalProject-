/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Nick Barpoulis, Emma Overly, Sienna Mosher and Anushikha Sharma
 * Date: Apr 7, 2016
 * Time: 8:34:41 PM
 *
 * Project: csci205FinalProject
 * Package: Monopoly.utilities
 * File: Property
 * Description: a file containing the Property class and pertinant exceptions
 *
 * ****************************************
 */
package Monopoly.utilities;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A custom exception thrown if a player attempts to build a house when
 * currently owning the maximum number of houses
 *
 * @author njb011
 */
//==============================================================================
/**
 *
 * @author njb011 and slm053
 */
public class Property extends Space {

    private String name;
    private Color color;
    /**
     * represents how much the property costs to buy
     */
    private int price;
    /**
     * represents how much the building price is
     */
    private int buildingPrice;
    /**
     * represents where the property is on the board
     */
    private int location;
    /**
     * represents the multiplier for the rent
     */
    private int multiplier;
    /**
     * represents who owns the property
     */
    private int ownerID;
    /**
     * represents the number of houses on the property
     */
    private int numHouses;
    /**
     * represents whether or not this property has been purchased
     */
    private boolean purchased;
    /**
     * represents the current rent price
     */
    private int currentRent;
    /**
     * represents the base price for rent ( no houses/hotels)
     */
    private int rentBase;
    /**
     * represents the rent with one house
     */
    private final int rentHouse1;
    /**
     * represents the rent with two houses
     */
    private final int rentHouse2;
    /**
     * represents the rent with three houses
     */
    private final int rentHouse3;
    /**
     * represents the rent with four houses
     */
    private final int rentHouse4;
    /**
     * represents the rent with one hotel
     */
    private final int rentHotel;

    /**
     * Constructs an instance of the property class
     *
     * @param type
     * @param name - The name of the property
     * @param location - The location on the board of the property
     * @param color - the color of the property
     * @param price - the price of buying the property
     * @param rentBase
     * @param rentHouse1
     * @param rentHouse2
     * @param rentHouse3
     * @param rentHouse4
     * @param rentHotel
     * @param buildingPrice
     */
    public Property(String type, String name, int location, Color color,
                    int price, int rentBase, int rentHouse1, int rentHouse2,
                    int rentHouse3, int rentHouse4, int rentHotel,
                    int buildingPrice) {
        super(name, location, type);
        this.color = color;
        this.price = price;
        this.buildingPrice = buildingPrice;
        this.location = location;
        this.multiplier = 1;
        this.currentRent = rentBase;
        this.rentBase = rentBase;
        this.rentHouse1 = rentHouse1;
        this.rentHouse2 = rentHouse2;
        this.rentHouse3 = rentHouse3;
        this.rentHouse4 = rentHouse4;
        this.rentHotel = rentHotel;
        this.purchased = false;
        this.numHouses = 0;
        this.ownerID = 100; //just setting this to a high number that isn't a player I.D
    }

    /**
     * method representing the interaction with this property
     *
     * @param players
     * @param index
     */
    public void purchaseProperty(ArrayList<Player> players, int index) throws InsufficientFundsException {

        players.get(index).getBankAccount().withdraw(this.price);
        this.ownerID = index;
        this.purchased = true;
        players.get(index).getPropertiesOwned().add((Property) this);
        this.color.boughtProperty(color);

    }

    public String payRentOnProperty(ArrayList<Player> players, int index) {
        if (players.get(ownerID).isIsBankrupt()) {
            String output
                   = "Player who owns this space is bankrupt and no longer in the game.\n";

            return output;
        } else {
            try {
                String output = String.format("%s owes %s $%d\n",
                                              players.get(index).getPlayerName(),
                                              players.get(
                                                      this.ownerID).getPlayerName(),
                                              this.currentRent);
                players.get(index).getBankAccount().withdraw(
                        this.currentRent);
                players.get(this.ownerID).getBankAccount().deposit(
                        this.currentRent);
                return output;
            } catch (InsufficientFundsException e) {
                String output = String.format(
                        "Player does not have enough funds in bank, so is now bankrupt\n");
                players.get(this.ownerID).getBankAccount().deposit(
                        this.currentRent);
                players.get(index).getBankAccount().setBalance(0);
                players.get(index).setIsBankrupt(true);
                return output;
            }
        }
    }

    //THIS METHOD IS NO LONGER USED IN THE GUI-- WAS BROKEN INTO SMALLER METHODS
    public void landOnProperty(ArrayList<Player> players, int index) {
        //check to see if they already own the class
        if (players.get(index).getPlayerNumber() == this.ownerID) {
            System.out.format("%s already owns this spot.\n",
                              players.get(index).getPlayerName());
        } else if (this.purchased) {
            if (players.get(ownerID).isIsBankrupt()) {
                System.out.println(
                        "Player who owns this space is bankrupt and no longer in the game.\n");
            } else {
                try {
                    System.out.format("%s owes %s $%d\n",
                                      players.get(index).getPlayerName(),
                                      players.get(
                                              this.ownerID).getPlayerName(),
                                      this.currentRent);
                    players.get(index).getBankAccount().withdraw(
                            this.currentRent);
                    players.get(this.ownerID).getBankAccount().deposit(
                            this.currentRent);
                } catch (InsufficientFundsException e) {
                    System.out.println(
                            "Player does not have enough funds in bank\n");
                    players.get(this.ownerID).getBankAccount().deposit(
                            this.currentRent);
                    players.get(index).getBankAccount().setBalance(0);
                    players.get(index).setIsBankrupt(true);
                }
            }
        } else {
            Scanner in = new Scanner(System.in);
            System.out.format(
                    "Would you like to buy this property for $%d? (y or n) \n",
                    this.price);
            String response = in.next();
            if (response.equals("y")) {
                try {
                    players.get(index).getBankAccount().withdraw(this.price);
                    this.ownerID = index;
                    this.purchased = true;
                    players.get(index).getPropertiesOwned().add((Property) this);
                } catch (InsufficientFundsException e) {
                    System.out.println(
                            "You do not have enough in your account to purchase this property\n");
                }
            }
        }
        //check to see if the property is owned
        //if it is, withdraw the current rent from player
        //give money to player that owns the property
        //if it isn't owned
        //give option to purchase
    }

    /**
     * Gets the name of the property
     *
     * @return a string containing the name of the property
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the current price multiplier (changed when monopoly acquired)
     *
     * @return the property multiplier
     */
    public int getMultiplier() {
        return this.multiplier;
    }

    /**
     * Gets the ID of the owner
     *
     * @return the owner ID
     */
    public int getOwnerID() {
        return this.ownerID;
    }

    /**
     * Gets the color of the property
     *
     * @return the color of the property
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Gets the cost of buying the property
     *
     * @return the cost of the property
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * Gets the cost of buying a house for the property
     *
     * @return the cost of buying a house
     */
    public int getBuildingPrice() {
        return this.buildingPrice;
    }

    /**
     * Gets the current property rent (used if someone lands on the property)
     *
     * @return the current property rent amount
     */
    public int getCurrentRent() {
        return this.currentRent * this.multiplier;
    }

    /**
     * Gets the current number of houses on the property
     *
     * @return the number of houses built on the property
     */
    public int getNumHouses() {
        return numHouses;
    }

    /**
     * Sets the current owner ID (used if properties are traded)
     *
     * @param ownerID
     */
    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    /**
     * Increments the number of houses on the property
     *
     * @throws MaxHousesException
     */
    public void incrementNumHouses() throws MaxHousesException {
        if (this.numHouses == 5) {
            throw new MaxHousesException(
                    "ERROR: YOU CANNOT ADD ANY MORE HOUSES TO THIS PROPERTY!");
        } else {
            this.numHouses += 1;
        }
    }

    /**
     * Increments the rent the property charged (called when houses are added or
     * monopoly is acquired)
     */
    public void incrementCurrentRent() {
        if (this.currentRent == this.rentBase) {
            if (this.multiplier == 1) {
                this.multiplier = 2;
            } else {
                this.multiplier = 1;
                this.currentRent = this.rentHouse1;
            }
        } else if (this.currentRent == this.rentHouse1) {
            this.currentRent = this.rentHouse2;
        } else if (this.currentRent == this.rentHouse2) {
            this.currentRent = this.rentHouse3;
        } else if (this.currentRent == this.rentHouse3) {
            this.currentRent = rentHouse4;
        } else {
            this.currentRent = rentHotel;
        }
    }

    /**
     * Changes the current status of the property
     *
     * @param purchased - whether or not the property has been purchased
     */
    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    /**
     * Checks to see if the property has been purchased yet
     *
     * @return whether or not the property has been purchased
     */
    public boolean isPurchased() {
        return purchased;
    }

}
