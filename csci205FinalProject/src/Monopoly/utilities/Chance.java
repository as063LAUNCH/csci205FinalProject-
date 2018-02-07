package Monopoly.utilities;

import java.util.ArrayList;

/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Nick Barpoulis, Emma Overly, Sienna Mosher and Anushikha Sharma
 * Date: Apr 9, 2016
 * Time: 4:06:24 PM
 *
 * Project: csci205FinalProject
 * Package: Monopoly.utilities
 * File: Chance
 * Description: Represents the Chance space
 *
 * ****************************************
 */
/**
 * class representing the Chance space
 *
 * @author emo006 and slm053
 */
public class Chance extends Space {

    /**
     * Represents the array of cards
     */
    private static ArrayList<Card> CCards;
    /**
     * represents the last card drawn
     */
    private Card lastDrawn;
    /**
     * represents the utility class
     */
    private CardUtility utility;

    /**
     * The constructor for the CommunityChest
     *
     * @param type
     * @param name
     * @param location
     * @param input
     */
    public Chance(String type, String name, int location,
                  ArrayList<Card> input) {
        super(name, location, type);
        this.CCards = input;
        this.lastDrawn = null;
        this.utility = new CardUtility();
    }

    /**
     * represents the action taken when a player lands on this space
     *
     * @param players
     * @param index
     * @param spaces
     */
    public String landOnChance(ArrayList<Player> players, int index,
                               ArrayList<Space> spaces) {
        try {
            String cardMessage = this.landed(players.get(index));
            String output = String.format(
                    "You landed on a Chance space! The card message is: \n %s",
                    cardMessage);

            this.action(players.get(index), spaces);
            return output;
        } catch (InsufficientFundsException e) {
            String output = String.format(
                    "You landed on a Chance space! You don't have enough money in your bank account to pay the fee\n");
            return output;
        }
    }

    /**
     * method that draws card
     *
     * @param onCC
     * @return String of the card drawn
     */
    public String landed(Player onCC) {
        Card chosen = utility.chooseCard(CCards);
        lastDrawn = chosen;
        return CardUtility.displayCard(lastDrawn);

    }

    /**
     * method that performs the action
     *
     * @param onCC
     * @param spaces
     * @throws Monopoly.utilities.InsufficientFundsException
     */
    public void action(Player onCC, ArrayList<Space> spaces) throws InsufficientFundsException {
        CardUtility.act(lastDrawn, onCC, spaces);
        this.lastDrawn = null;

    }
}
