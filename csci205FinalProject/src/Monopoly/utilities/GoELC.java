/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Nick Barpoulis, Emma Overly, Sienna Mosher and Anushikha Sharma
 * Date: Apr 14, 2016
 * Time: 5:54:46 PM
 *
 * Project: csci205FinalProject
 * Package: Monopoly.utilities
 * File: GoELC
 * Description: Represents the Go space (fondly named the ELC) on the board
 *
 * ****************************************
 */
package Monopoly.utilities;

import java.util.ArrayList;

/**
 *
 * @author emo006
 */
public class GoELC extends Space {
    /**
     * The constructor for the ELC Space. Takes the type, name, and location on
     * the board
     *
     * @param type
     * @param taxName
     * @param taxLocation
     */
    public GoELC(String type, String taxName, int taxLocation) {
        super(taxName, taxLocation, type);
    }

    /**
     * represents the interaction to take place when a player lands on this
     * space
     *
     * @param players
     * @param index
     * @return
     */
    public String landOnGo(ArrayList<Player> players, int index) {
        players.get(index).getBankAccount().deposit(200);
        String output = String.format("%s landed on go! Collect $200.\n",
                                      players.get(index).getPlayerName());
        return output;
    }

}
