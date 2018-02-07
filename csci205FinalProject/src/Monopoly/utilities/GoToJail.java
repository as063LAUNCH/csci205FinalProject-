/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Nick Barpoulis, Emma Overly, Sienna Mosher and Anushikha Sharma
 * Date: Apr 13, 2016
 * Time: 10:48:29 AM
 *
 * Project: csci205FinalProject
 * Package: Monopoly.utilities
 * File: GoToJail
 * Description: represents the goTOJail space on the board
 *
 * ****************************************
 */
package Monopoly.utilities;

import java.util.ArrayList;

/**
 *
 * @author emo006
 */
public class GoToJail extends Space {
    /**
     * constructor for the GoToJail class. Takes the type, name, and location on
     * the board
     *
     * @param type
     * @param name
     * @param location
     */
    public GoToJail(String type, String name, int location) {
        super(name, location, type);
    }

    /**
     * represents interaction with the players. (TO JAIL AHAHAHA)
     *
     * @param players
     * @param index
     */
    public String sendToJail(ArrayList<Player> players, int index) {
        String output = String.format("%s was sent to jail (aka Breakiron 164",
                                      players.get(index).getPlayerName());
        players.get(index).setCurrLocation(10);
        players.get(index).setIsInJail(true);
        players.get(index).setRollsInJail(0);
        return output;
    }

}
