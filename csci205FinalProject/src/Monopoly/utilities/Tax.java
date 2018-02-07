package Monopoly.utilities;

import java.util.ArrayList;

/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Nick Barpoulis, Emma Overly, Sienna Mosher and Anushikha Sharma
 * Date: Apr 10, 2016
 * Time: 9:14:24 PM
 *
 * Project: csci205FinalProject
 * Package: Monopoly.utilities
 * File: Tax
 * Description: a file containing the tax class
 *
 * ****************************************
 */
/**
 * A class used to set up a tax instance
 *
 * @author njb011, emo006
 */
public class Tax extends Space {
    /**
     * represents the amount of tax that needs to be paid
     */
    private int taxAmount;

    /**
     * The tax class constructor
     *
     * @param type - the type of the space
     * @param taxName - the name of the tax
     * @param taxLocation - the location on the board of the tax
     * @param taxAmount - the amount to be taxed
     */
    public Tax(String type, String taxName, int taxLocation, int taxAmount) {
        super(taxName, taxLocation, type);
        this.taxAmount = taxAmount;
    }

    /**
     * method that represents the interaction with this Space. (Pay the tax)
     *
     * @param player
     * @param index
     * @return
     * @throws InsufficientFundsException
     */
    public String landOnTax(ArrayList<Player> player, int index) throws InsufficientFundsException {
        if (player.get(index).getBankAccount().getBalance() <= taxAmount) {
            player.get(index).getBankAccount().setBalance(0);
            player.get(index).setIsBankrupt(true);
            String output = String.format(
                    "You had to pay %d in tax, and you are now bankrupt",
                    taxAmount
            );
            return output;
        } else {
            player.get(index).getBankAccount().withdraw(taxAmount);
            String output = String.format("You had to pay %d in tax.", taxAmount);
            return output;
        }

    }

    /**
     * Gets the tax amount
     *
     * @return taxAmount - the tax price
     */
    public int getTaxAmount() {
        return taxAmount;
    }

    /**
     * Sets the new tax amount
     *
     * @param taxAmount - the new tax price
     */
    public void setTaxAmount(int taxAmount) {
        this.taxAmount = taxAmount;
    }

}
