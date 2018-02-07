package Monopoly.utilities;

import java.util.ArrayList;
import java.util.Scanner;

/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Nick Barpoulis, Emma Overly, Sienna Mosher and Anushikha Sharma
 * Date: Apr 10, 2016
 * Time: 9:22:07 PM
 *
 * Project: csci205FinalProject
 * Package: Monopoly.utilities
 * File: AcademicProperty
 * Description: a file containing a class for the academic properties
 *
 * ****************************************
 */
/**
 *
 * @author njb011 and slm053
 */
public class AcademicProperty extends Space {
    /**
     * represents an integer value price of a space
     */
    private int price;
    /**
     * represents an integer value of the current rent price
     */
    private int currentRent;
    /**
     * represents an integer of the multiplier for the rent
     */
    private int multiplier;
    /**
     * represents whether or not the space is purchased
     */
    private boolean purchased;
    /**
     * represents who owns the space
     */
    private int ownerID;

    /**
     * Constructs an instance of the property class
     *
     * @param type
     * @param name - The name of the property
     * @param location - The location on the board of the property
     * @param price - the price of buying the property
     * @param rent - the rent of the academic property
     */
    public AcademicProperty(String type, String name, int location,
                            int price,
                            int rent) {
        super(name, location, type);
        this.price = price;
        this.currentRent = rent;
        this.multiplier = 1;
        this.purchased = false;
        this.ownerID = 100; //initialized to a high number that isn't a owner ID
    }

    public void purchaseACProperty(ArrayList<Player> players, int index) throws InsufficientFundsException {

        players.get(index).getBankAccount().withdraw(this.price);
        this.ownerID = index;
        this.purchased = true;
        players.get(index).getPropertiesOwned().add((AcademicProperty) this);
    }

    public int getMultiplier() {
        return multiplier;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public String payRentOnACProperty(ArrayList<Player> players, int index) {
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
                        "Player does not have enough funds in bank\n");
                players.get(this.ownerID).getBankAccount().deposit(
                        this.currentRent);
                players.get(index).getBankAccount().setBalance(0);
                players.get(index).setIsBankrupt(true);
                return output;
            }
        }
    }

    /**
     * A method that represents possible courses of action if a player lands on
     * property.
     *
     * @param players
     * @param index
     */
    public void landOnAcademicProp(ArrayList<Player> players, int index) {
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
                    "Would you like to buy this academic building for $%d? (y or n) \n",
                    this.price);
            String response = in.next();
            if (response.equals("y")) {
                try {
                    players.get(index).getBankAccount().withdraw(this.price);
                    this.ownerID = index;
                    this.purchased = true;
                    players.get(index).getPropertiesOwned().add(this);
                } catch (InsufficientFundsException e) {
                    System.out.println(
                            "You do not have enough in your account to purchase this property\n");
                }
            }
        }
    }

    /**
     * Gets the cost of buying the property
     *
     * @return the cost of the property
     */
    public int getPrice() {
        return price;
    }

    /**
     * Gets the current property rent (used if someone lands on the property)
     *
     * @return the current property rent amount
     */
    public int getCurrentRent() {
        return this.currentRent;
    }

    /**
     * Sets the current property multiplier (used if someone gets a monopoly)
     *
     * @param multiplier - the property base rent multiplier
     */
    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
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
