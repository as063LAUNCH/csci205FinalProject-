package Monopoly.utilities;

/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Nick Barpoulis, Emma Overly, Sienna Mosher and Anushikha Sharma
 * Date: Apr 7, 2016
 * Time: 8:35:26 PM
 *
 * Project: csci205FinalProject
 * Package:
 * File: Account
 * Description: a file containing the Account class and all pertinent exceptions
 * ****************************************
 */
/**
 * A custom exception thrown if the amount attempted to be withdrawn from the
 * account exceeds its balance
 *
 * @author njb011
 */
/**
 * A bank account class used to manage a players funds
 *
 * @author njb011
 */
public class Account {
    /**
     * represents the name of the account
     */
    private String name;
    /**
     * represents the amount in the account
     */
    private int balance;
    /**
     * represents the starting amount for all players
     */
    private static final int INITIAL_AMOUNT = 1500;

    /**
     * Account class constructor
     *
     * @param name - the name of the account
     */
    public Account(String name) {
        this.name = name;
        this.balance = INITIAL_AMOUNT;
    }

    /**
     * Returns the name of the account
     *
     * @return - the account name
     */
    public String getName() {
        return name;
    }

    /**
     * Allows the user to change the name of the account
     *
     * @param name - the desired new account name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the current account balance
     *
     * @return - the amount of money currently in the account
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Allows the user to set a new account balance
     *
     * @param balance - the desired balance amount
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * Allows the user to withdraw money from the account
     *
     * @param amount - the amount of money to withdraw from the account
     * @throws InsufficientFundsException
     */
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > this.balance) {
            throw new InsufficientFundsException(
                    "ERROR: Insufficient Funds to complete transaction! \nCHARGE: $" + amount + "\nBALANCE: $" + this.balance);
        } else {
            this.balance -= amount;
        }

    }

    /**
     * Allows the user to deposit money into the account
     *
     * @param amount - the amount to add to the account
     */
    public void deposit(double amount) {
        this.balance += amount;
    }

    /**
     * Allows the user to display the account as a String
     *
     * @return the account details
     */
    @Override
    public String toString() {
        return "THE ACCOUNT " + this.getName() + "CURRENTLY CONTAINS $" + this.getBalance();
    }
}
