/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Nick Barpoulis, Emma Overly, Sienna Mosher and Anushikha Sharma
 * Date: Apr 13, 2016
 * Time: 10:23:46 AM
 *
 * Project: csci205FinalProject
 * Package: Monopoly.utilities
 * File: Free
 * Description: represents the Free parking space on the board
 *
 * ****************************************
 */
package Monopoly.utilities;

import java.util.ArrayList;

/**
 *
 * @author emo006 and slm053
 */
public class Free extends Space {
    /**
     * represents the amount of money within the space
     */
    private Account freeSpaceAccount;

    /**
     * constructor for the free space. Takes a type, name and location
     *
     * @param type
     * @param name
     * @param location
     */
    public Free(String type, String name, int location) {
        super(name, location, type);
        this.freeSpaceAccount = new Account("Free Space Account");
        this.freeSpaceAccount.setBalance(0);
    }

    /**
     * getter method for the account
     *
     * @return - Account object
     */
    public Account getFreeSpaceAccount() {
        return freeSpaceAccount;
    }

    /**
     * method that represents the interaction that can take place when this
     * space is landed on
     *
     * @param players
     * @param index
     * @return
     */
    public String landOnFree(ArrayList<Player> players, int index) {
        if (this.getAmount() != 0) {
            players.get(index).getBankAccount().deposit(this.getAmount());
            String output = String.format(
                    "You landed on Academic Quad-- Free Space, collect %d!",
                    this.getAmount());
            this.collectMoney();
            return output;
        } else {
            String output = String.format(
                    "You landed on Academic Quad-- Free Space, but the community pot was empty!");
            return output;
        }
    }

    /**
     * how much money is in the community pot
     *
     * @return - int of money
     */
    public int getAmount() {
        return this.freeSpaceAccount.getBalance();
    }

    /**
     * Deposits into the community pot
     *
     * @param amount
     */
    public void addAmount(int amount) {
        this.freeSpaceAccount.deposit(amount);
    }

    /**
     * sets the balance in the community pot to zero when someone lands on the
     * spot and collects the money
     */
    public void collectMoney() {
        this.freeSpaceAccount.setBalance(0);
    }

}
